package rs.spai.demogQL2;

import java.util.List;
public class SearchResult {
    private List<Book> books;
    private List<Author> authors;
    private List<Category> categories;
    private PageInfo pageInfo;
    
    public SearchResult() {
    }

    public SearchResult(List<Book> books, List<Author> authors, List<Category> categories, PageInfo pageInfo) {
        this.books = books;
        this.authors = authors;
        this.categories = categories;
        this.pageInfo = pageInfo;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public PageInfo getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
    }
}
