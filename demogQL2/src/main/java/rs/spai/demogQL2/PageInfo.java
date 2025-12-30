package rs.spai.demogQL2;


public class PageInfo {
	
	 private int page;
	    private int size;
	    private int totalItems;
	    private int remainingItems;
	    
	    
	    public PageInfo() {
	    }

	    public PageInfo(int page, int size, int totalItems, int remainingItems) {
	        this.page = page;
	        this.size = size;
	        this.totalItems = totalItems;
	        this.remainingItems = remainingItems;
	    }

	    public int getPage() {
	        return page;
	    }

	    public void setPage(int page) {
	        this.page = page;
	    }

	    public int getSize() {
	        return size;
	    }

	    public void setSize(int size) {
	        this.size = size;
	    }

	    public int getTotalItems() {
	        return totalItems;
	    }

	    public void setTotalItems(int totalItems) {
	        this.totalItems = totalItems;
	    }

	    public int getRemainingItems() {
	        return remainingItems;
	    }

	    public void setRemainingItems(int remainingItems) {
	        this.remainingItems = remainingItems;
	    }

}
