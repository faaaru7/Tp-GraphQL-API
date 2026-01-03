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
                bRepo.findBooksWithPagination(size, offset);     //tjib les livres par offset
        int remainingItems =    //chhal 93do les livres
                Math.max(0, (int) totalItems - (page * size));   //par exmple 170 - (1*10)=160

        PageInfo info = new PageInfo();
        info.setPage(page); //numéro de page
        info.setSize(size); //size de page
        info.setTotalItems((int) totalItems); //totale des livres
        info.setRemainingItems(remainingItems); //rest des livres
 
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
        if (page == null || page < 1) page = 1; //pardéfaut 1
        if (size == null || size < 1) size = 10; //pardéfaut 10
        int offset = (page - 1) * size;  
        List<Book> books = bRepo.findFilteredBooks(     //tjib les livres par offset
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
    public List<Book> booksByCategory(   //listes des livres par category
            @Argument Long categoryId,
            @Argument Boolean recursive // true pour or false
    ) {
        Category category = cRepo.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category not found"));  //if this category existe
        List<Long> categoryIds; //category by id

        if (Boolean.TRUE.equals(recursive)) {    //if recursive
            categoryIds = getAllCategoryIds(category);
        } else {     //if not recursive
            categoryIds = List.of(categoryId);
        }
        return bRepo.findBooksByCategoryIds(categoryIds);
    }
    //pour get all subcategory et category
    private List<Long> getAllCategoryIds(Category category) {
        List<Long> idsub = new ArrayList<>();
        idsub.add(category.getIdC()); 

        if (category.getSubCategories() != null && !category.getSubCategories().isEmpty()) {  //if existe a sub gategory
            for (Category sub : category.getSubCategories()) {    //On appelle récursivement getAllCategoryIds(sub)
                idsub.addAll(getAllCategoryIds(sub));    //get sub category et category
            }
        }
        return idsub;
    }  

    
 //Les livres by authors  
    @QueryMapping
    public List<Book> booksByAuthor(@Argument Long authorId) {
        return bRepo.findBooksByAuthorId(authorId);  //trové les livers d'un authors
    }
    @QueryMapping
    public List<Book> booksByAuthorName(@Argument String authorName) {
        return bRepo.findBooksByAuthorName(authorName); 
    }
    
   //search using key word 
    @QueryMapping
    public SearchResult search(   //la méthode principale
            @Argument String keyword,  //le mot clé 
            @Argument SearchType type, //author , book , category
            @Argument Integer page,  //numéro de page 
            @Argument Integer size  //nombre d'éléments par page
    ) {
        int pageNum = (page == null || page < 1) ? 1 : page;  //pardéfaut page=1
        int pageSize = (size == null || size < 1) ? 10 : size; //pardéfaur size=10

        var pageable = PageRequest.of(pageNum - 1, pageSize); //par exemple livres 1 → 10 pour pageNum = 0      livres 11 → 20 pour pageNum = 1

        SearchResult result = new SearchResult();   //résultat final
        PageInfo pageInfo = new PageInfo();
        pageInfo.setPage(pageNum);
        pageInfo.setSize(pageSize);

        if (type == null) {
            type = SearchType.BOOK;     //si type est null pardéfaut book
        }

        if (type == SearchType.BOOK) {  //si le type est livre
            handleBookSearch(keyword, pageable, pageNum, pageSize, result, pageInfo);
        }

        if (type == SearchType.AUTHOR) { //si le type est author
            handleAuthorSearch(keyword, pageable, pageNum, pageSize, result, pageInfo);
        }

        if (type == SearchType.CATEGORY) {  //si le type est category
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
        List<Book> books = bRepo.searchByTitle(keyword, pageable);  //rechercher les livres par le mot clé 
        long total = bRepo.countByTitle(keyword);   //le nbr totale des livres 

        pageInfo.setTotalItems((int) total); //nombre total d’éléments trouvés
        pageInfo.setRemainingItems(Math.max(0, (int) (total - page * size))); //nombre d’éléments restants
        result.setBooks(books);   //remplit le résultat
    }

    private void handleAuthorSearch(
            String keyword,
            PageRequest pageable,
            int page,
            int size,
            SearchResult result,
            PageInfo pageInfo
    ) {
        List<Author> authors = aRepo.searchByName(keyword, pageable);  //rechercher les authors par le mot clé 
        long total = aRepo.countByName(keyword); //le nbr totale des authors

        pageInfo.setTotalItems((int) total);//nombre total d’éléments trouvés
        pageInfo.setRemainingItems(Math.max(0, (int) (total - page * size))); //nombre d’éléments restants
        result.setAuthors(authors); //remplit le résultat
    }

    private void handleCategorySearch(
            String keyword,
            PageRequest pageable,
            int page,
            int size,
            SearchResult result,
            PageInfo pageInfo
    ) {
        List<Category> categories = cRepo.searchByName(keyword, pageable);   //rechercher les categorys par le mot clé 
        long total = cRepo.countByName(keyword);  //le nbr totale des categorys

        pageInfo.setTotalItems((int) total);//nombre total d’éléments trouvés
        pageInfo.setRemainingItems(Math.max(0, (int) (total - page * size)));//nombre d’éléments restants
        result.setCategories(categories);//remplit le résultat
    }

    
    //Part 2
    //Ajouter un Livre 
    @MutationMapping   //pour ajouter et modifier les données 
    @PreAuthorize("hasRole('ADMIN')")  //just l'admin qui acceder
    @Transactional
    public Book addBook(   //les données pour créer un livre
            @Argument String title,
            @Argument Integer publicationYear,
            @Argument String language,
            @Argument Integer nbPages,
            @Argument Long authorId,
            @Argument Long categoryId
    ) {
        Author author = getAuthorById(authorId);   //if le author est existe
        Category category = getCategoryById(categoryId);  //if le category est existe

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
    private Author getAuthorById(Long id) {  //pour rechercher un author est existe ou pas 
        return aRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Author not found"));
    }

    private Category getCategoryById(Long id) {
        return cRepo.findById(id)   //pour rechercher une category existe ou pas
                .orElseThrow(() -> new RuntimeException("Category not found"));
    }
    private Book buildBook(
            String title,  //pour créer un livre
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
    //Supprimer un Author
    @MutationMapping
    @PreAuthorize("hasRole('ADMIN')") //just l'admin qui acceder
    @Transactional
    public Boolean deleteAuthor(@Argument Integer id) {  
        return aRepo.findById(id.longValue()).map(author -> {   //Cherche l’auteur dans la base de données par son ID.
            bRepo.deleteAll(author.getBooks()); //Supprime tous les livres liés à cet auteur
            aRepo.delete(author);  //supprimer l'author
            return true;
        }).orElse(false);
    }  
}

