package rs.spai.demogQL2;
import java.util.List;



public class BookPage {
	   private List<Book> books;
	    private PageInfo pageInfo;

	    public List<Book> getBooks() {
	        return books;
	    }

	    public void setBooks(List<Book> books) {
	        this.books = books;
	    }

	    public PageInfo getPageInfo() {
	        return pageInfo;
	    }

	    public void setPageInfo(PageInfo pageInfo) {
	        this.pageInfo = pageInfo;
	    }

}
