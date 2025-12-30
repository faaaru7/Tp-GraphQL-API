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

    

    @QueryMapping
    public List<Book> books() {
        return bRepo.findAll();
    }

    @QueryMapping
    public List<Author> authors() {
        return aRepo.findAll();
    }

    @QueryMapping
    public List<Category> categories() {
        return cRepo.findAll();
    }

    
    @QueryMapping
    public BookPage listBooks(
    		   @Argument Integer page,
    	        @Argument Integer size) {

    	    if (page == null || page < 1) {
    	        page = 1;
    	    }

    	    if (size == null || size < 1) {
    	        size = 10;
    	    }

    	    int offset = (page - 1) * size;

    	    List<Book> books = bRepo.findBooksWithPagination(size, offset);
    	    long totalItems = bRepo.count();

    	    int remainingItems = Math.max(0, (int) (totalItems - page * size));

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

        long totalItems = bRepo.countFilteredBooks(
                publicationYear,
                language,
                categoryId
        );

        int remainingItems = Math.max(0, (int) (totalItems - page * size));

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
  
    
    @QueryMapping
    public List<Book> booksByAuthor(@Argument Long authorId) {
        return bRepo.findBooksByAuthorId(authorId);
    }
    
    
    @QueryMapping
    public SearchResult search(
            @Argument String keyword,
            @Argument SearchType type,
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
                List<Book> books = bRepo.searchByTitle(keyword, pageable);
                long totalBooks = bRepo.countByTitle(keyword);
                pageInfo.setTotalItems((int) totalBooks);
                pageInfo.setRemainingItems((int) Math.max(0, totalBooks - page * size));
                result.setBooks(books);
            }
            case AUTHOR -> {
                List<Author> authors = aRepo.searchByName(keyword, pageable);
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
    //books by category 
    private List<Long> getAllCategoryIds(Category category) {
        List<Long> ids = new ArrayList<>();
        ids.add(category.getIdC()); // l'ID de la catégorie principale

        if (category.getSubCategories() != null && !category.getSubCategories().isEmpty()) {
            for (Category sub : category.getSubCategories()) {
                ids.addAll(getAllCategoryIds(sub)); // récursion
            }
        }

        return ids;
    }
    
    @QueryMapping
    public List<Book> booksByCategory(
            @Argument Long categoryId,
            @Argument Boolean recursive // true pour inclure les sous-catégories
    ) {
        Category category = cRepo.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category not found"));

        List<Long> categoryIds;

        if (Boolean.TRUE.equals(recursive)) {
            categoryIds = getAllCategoryIds(category);
        } else {
            categoryIds = List.of(categoryId);
        }

        return bRepo.findBooksByCategoryIds(categoryIds);
    }
    
    @MutationMapping
    @PreAuthorize("hasRole('ADMIN')")
    public Book addBook(
        @Argument String title,
        @Argument Integer publicationYear,
        @Argument String language,
        @Argument Integer nbPages,
        @Argument Long authorId,
        @Argument Long categoryId
    ) {
        Author author = aRepo.findById(authorId)
                .orElseThrow(() -> new RuntimeException("Author not found"));

        Category category = cRepo.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category not found"));

        Book book = new Book();
        book.setTitle(title);
        book.setPublicationYear(publicationYear);
        book.setLanguage(language);
        book.setNbPages(nbPages);
        book.setAuthor(author);
        book.setCategory(category);

        return bRepo.save(book);
    }
    
    @Transactional
    @MutationMapping
    @PreAuthorize("hasRole('ADMIN')")
    
    public Boolean deleteAuthor(@Argument Long id) {
        return aRepo.findById(id).map(author -> {
            bRepo.deleteAll(author.getBooks()); 
            aRepo.delete(author);             
            return true;
        }).orElse(false);
    }
   
}

