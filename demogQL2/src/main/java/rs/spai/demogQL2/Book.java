package rs.spai.demogQL2;



import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;


@Entity
public class Book {
	
	

	 
	 @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long idBook;
	    private String title;
	    private Integer publicationYear;
	    private String language;
	    private Integer nbPages;
	    @ManyToOne
	    private Author author;
	    @ManyToOne
	    private Category category;
		public Long getIdBook() {
			return idBook;
		}
		public void setIdBook(Long idBook) {
			this.idBook = idBook;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public Integer getPublicationYear() {
			return publicationYear;
		}
		public void setPublicationYear(Integer publicationYear) {
			this.publicationYear = publicationYear;
		}
		public String getLanguage() {
			return language;
		}
		public void setLanguage(String language) {
			this.language = language;
		}
		public Integer getNbPages() {
			return nbPages;
		}
		public void setNbPages(Integer nbPages) {
			this.nbPages = nbPages;
		}
		public Author getAuthor() {
			return author;
		}
		public void setAuthor(Author author) {
			this.author = author;
		}
		public Category getCategory() {
			return category;
		}
		public void setCategory(Category category) {
			this.category = category;
		}
		public static Object builder() {
			// TODO Auto-generated method stub
			return null;
		}
	    

	  
	}
		
			
		
	