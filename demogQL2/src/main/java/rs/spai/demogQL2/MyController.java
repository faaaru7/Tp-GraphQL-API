package rs.spai.demogQL2;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.PageRequest;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
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
 //Part 01:
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
            @Argument SearchType type,
            @Argument Integer page,
            @Argument Integer size
    ) {
        int pageNum = (page == null || page < 1) ? 1 : page;
        int pageSize = (size == null || size < 1) ? 10 : size;

        var pageable = PageRequest.of(pageNum - 1, pageSize);

        SearchResult result = new SearchResult();
        PageInfo pageInfo = new PageInfo();
        pageInfo.setPage(pageNum);
        pageInfo.setSize(pageSize);

        if (type == null) {
            type = SearchType.BOOK;
        }

        if (type == SearchType.BOOK) {
            handleBookSearch(keyword, pageable, pageNum, pageSize, result, pageInfo);
        }

        if (type == SearchType.AUTHOR) {
            handleAuthorSearch(keyword, pageable, pageNum, pageSize, result, pageInfo);
        }

        if (type == SearchType.CATEGORY) {
            handleCategorySearch(keyword, pageable, pageNum, pageSize, result, pageInfo);
        }

        result.setPageInfo(pageInfo);
        return result;
    }
    private void handleBookSearch(
            String keyword,
            PageRequest pageable,
            int page,
            int size,
            SearchResult result,
            PageInfo pageInfo
    ) {
        List<Book> books = bRepo.searchByTitle(keyword, pageable);
        long total = bRepo.countByTitle(keyword);

        pageInfo.setTotalItems((int) total);
        pageInfo.setRemainingItems(Math.max(0, (int) (total - page * size)));
        result.setBooks(books);
    }

    private void handleAuthorSearch(
            String keyword,
            PageRequest pageable,
            int page,
            int size,
            SearchResult result,
            PageInfo pageInfo
    ) {
        List<Author> authors = aRepo.searchByName(keyword, pageable);
        long total = aRepo.countByName(keyword);

        pageInfo.setTotalItems((int) total);
        pageInfo.setRemainingItems(Math.max(0, (int) (total - page * size)));
        result.setAuthors(authors);
    }

    private void handleCategorySearch(
            String keyword,
            PageRequest pageable,
            int page,
            int size,
            SearchResult result,
            PageInfo pageInfo
    ) {
        List<Category> categories = cRepo.searchByName(keyword, pageable);
        long total = cRepo.countByName(keyword);

        pageInfo.setTotalItems((int) total);
        pageInfo.setRemainingItems(Math.max(0, (int) (total - page * size)));
        result.setCategories(categories);
    }

    
    //Part 2
    
    @MutationMapping
    @PreAuthorize("hasRole('ADMIN')")
    @Transactional
    public Book addBook(
            @Argument String title,
            @Argument Integer publicationYear,
            @Argument String language,
            @Argument Integer nbPages,
            @Argument Long authorId,
            @Argument Long categoryId
    ) {
        Author author = getAuthorById(authorId);
        Category category = getCategoryById(categoryId);

        Book book = buildBook(
                title,
                publicationYear,
                language,
                nbPages,
                author,
                category
        );

        return bRepo.save(book);
    }
    private Author getAuthorById(Long id) {
        return aRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Author not found"));
    }

    private Category getCategoryById(Long id) {
        return cRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));
    }

    private Book buildBook(
            String title,
            Integer year,
            String language,
            Integer pages,
            Author author,
            Category category
    ) {
        Book book = new Book();
        book.setTitle(title);
        book.setPublicationYear(year);
        book.setLanguage(language);
        book.setNbPages(pages);
        book.setAuthor(author);
        book.setCategory(category);
        return book;
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

