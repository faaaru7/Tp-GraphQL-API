package rs.spai.demogQL2;


public class PageInfo {
	
	 private int page;  //numéro de page 
	    private int size; //nombre d'éléments par page
	    private int totalItems; //nbr totale des livres
	    private int remainingItems; //nbr des page d93do 
	    
	    
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
