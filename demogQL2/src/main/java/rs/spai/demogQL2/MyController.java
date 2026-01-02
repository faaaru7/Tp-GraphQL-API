package rs.spai.demogQL2;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.PageRequest;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;


@Controller
public class MyController {
	
	private final BookRepository bRepo;
    private final AuthorRepository aRepo;
    private final CategoryRepository cRepo;

    public MyController(BookRepository bookRepo, AuthorRepository authorRepo, CategoryRepository categoryRepo) {
    	super();
        this.bRepo = bookRepo;
        this.aRepo = authorRepo;
        this.cRepo = categoryRepo;
    }

    
  //Liste pour touts les livres 
    @QueryMapping
    public List<Book> books() {
        return bRepo.findAll();
    }
   //Liste pour touts les authors 
    @QueryMapping
    public List<Author> authors() {
        return aRepo.findAll();
    }
    //Liste pour touts les category 
    @QueryMapping
    public List<Category> categories() {
        return cRepo.findAll();
    }

 //Liste Book with Remaining Items and size par défaut 10
    @QueryMapping
    public BookPage listBooks(@Argument Integer page,
                              @Argument Integer size) {
        // par default 
        if (page == null || page < 1) page = 1;  //numéro de page 
        if (size == null || size < 1) size = 10; //nombre d'éléments par page
        int offset = size * (page - 1);  //par exemple page = 1 → offset = 0
        long totalItems = bRepo.count();  //nbr totale des livres 
        List<Book> books =
                bRepo.findBooksWithPagination(size, offset);
        int remainingItems =    //chhal 93do les livres
                Math.max(0, (int) totalItems - (page * size));   

        PageInfo info = new PageInfo();
        info.setPage(page);
        info.setSize(size);
        info.setTotalItems((int) totalItems);
        info.setRemainingItems(remainingItems);

        BookPage pageResult = new BookPage();
        pageResult.setBooks(books);
        pageResult.setPageInfo(info);
        return pageResult;
    }
    //Filtred by category        
    @QueryMapping(name = "listBooksFilterd")
    public BookPage listBooksFilterd(
            @Argument Integer page,
            @Argument Integer size,
            @Argument Integer publicationYear,
            @Argument String language,
            @Argument Long categoryId) {
        if (page == null || page < 1) page = 1;
        if (size == null || size < 1) size = 10;
        int offset = (page - 1) * size;
        List<Book> books = bRepo.findFilteredBooks(
                publicationYear,
                language,
                categoryId,
                size,
                offset
        );
        long totalItems = bRepo.countFilteredBooks(     //pour calculer les livers by category
                publicationYear,
                language,
                categoryId
        );
        int remainingItems = Math.max(0, (int) (totalItems - page * size));  //pour calculer chhal 93do les livres
        PageInfo pageInfo = new PageInfo();
        pageInfo.setPage(page);
        pageInfo.setSize(size);
        pageInfo.setTotalItems((int) totalItems);
        pageInfo.setRemainingItems(remainingItems);
        BookPage result = new BookPage();
        result.setBooks(books);
        result.setPageInfo(pageInfo);
        return result;
    }
    //Fetching books of a selected category (recursive or not)
    @QueryMapping
    public List<Book> booksByCategory(
            @Argument Long categoryId,
            @Argument Boolean recursive // true pour or false
    ) {
        Category category = cRepo.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category not found"));
        List<Long> categoryIds;

        if (Boolean.TRUE.equals(recursive)) {    //if recursive
            categoryIds = getAllCategoryIds(category);
        } else {     //if not recursive
            categoryIds = List.of(categoryId);
        }
        return bRepo.findBooksByCategoryIds(categoryIds);
    }
    //pour get all category
    private List<Long> getAllCategoryIds(Category category) {
        List<Long> idsub = new ArrayList<>();
        idsub.add(category.getIdC()); 

        if (category.getSubCategories() != null && !category.getSubCategories().isEmpty()) {  //if existe a sub gategory
            for (Category sub : category.getSubCategories()) {   
                idsub.addAll(getAllCategoryIds(sub));    //get sub category
            }
        }
        return idsub;
    }   
    

    
 //Les livres by authors  
    @QueryMapping
    public List<Book> booksByAuthor(@Argument Long authorId) {
        return bRepo.findBooksByAuthorId(authorId);
    }
    
  
   
   //search using key word 
    @QueryMapping
    public SearchResult search(
            @Argument String keyword,
            @Argument SearchType type,  //book category or author
            @Argument Integer page,
            @Argument Integer size
    ) {
        if (page == null || page < 1) page = 1;
        if (size == null || size < 1) size = 10;
        Pageable pageable = PageRequest.of(page - 1, size);
        SearchResult result = new SearchResult();
        PageInfo pageInfo = new PageInfo();
        pageInfo.setPage(page);
        pageInfo.setSize(size);

        switch (type) {
            case BOOK -> {
                List<Book> books = bRepo.searchByTitle(keyword, pageable);   //by title
                long totalBooks = bRepo.countByTitle(keyword);
                pageInfo.setTotalItems((int) totalBooks);
                pageInfo.setRemainingItems((int) Math.max(0, totalBooks - page * size));   //thsab d93do
                result.setBooks(books);
            }
            case AUTHOR -> {
                List<Author> authors = aRepo.searchByName(keyword, pageable);  //by author name
                long totalAuthors = aRepo.countByName(keyword);
                pageInfo.setTotalItems((int) totalAuthors);
                pageInfo.setRemainingItems((int) Math.max(0, totalAuthors - page * size));
                result.setAuthors(authors);
            }
            case CATEGORY -> {
                List<Category> categories = cRepo.searchByName(keyword, pageable);
                long totalCategories = cRepo.countByName(keyword);
                pageInfo.setTotalItems((int) totalCategories);
                pageInfo.setRemainingItems((int) Math.max(0, totalCategories - page * size));
                result.setCategories(categories);
            }
        }

        result.setPageInfo(pageInfo);
        return result;
    }
    
    @MutationMapping
    @PreAuthorize("hasRole('ADMIN')")   //just l'admin qui acceder
    public Book addBook(
        @Argument String title,
        @Argument Integer publicationYear,
        @Argument String language,
        @Argument Integer nbPages,
        @Argument Long authorId,
        @Argument Long categoryId
    ) {
        Author author = aRepo.findById(authorId) //vérifier if le author existe
                .orElseThrow(() -> new RuntimeException("Author not found"));  

        Category category = cRepo.findById(categoryId)  //vérifier if category existe
                .orElseThrow(() -> new RuntimeException("Category not found")); 
       //Ajouter new book
        Book book = new Book();
        book.setTitle(title);
        book.setPublicationYear(publicationYear);
        book.setLanguage(language);
        book.setNbPages(nbPages);
        book.setAuthor(author);
        book.setCategory(category);

        return bRepo.save(book);
    }
    
    @MutationMapping
    @PreAuthorize("hasRole('ADMIN')") //just l'admin qui acceder
    @Transactional
    public Boolean deleteAuthor(@Argument Integer id) { 
        return aRepo.findById(id.longValue()).map(author -> {
            bRepo.deleteAll(author.getBooks());
            aRepo.delete(author);  //supprimer l'author
            return true;
        }).orElse(false);
    }  
}

