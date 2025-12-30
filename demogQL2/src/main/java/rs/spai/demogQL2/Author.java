package rs.spai.demogQL2;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Author {
	
	 @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long idA;
	    private String name;
	    private Integer age;
	    private String nationality;
	    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
	    private List<Book> books;
		public Long getIdA() {
			return idA;
		}
		public void setIdA(Long idA) {
			this.idA = idA;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Integer getAge() {
			return age;
		}
		public void setAge(Integer age) {
			this.age = age;
		}
		public String getNationality() {
			return nationality;
		}
		public void setNationality(String nationality) {
			this.nationality = nationality;
		}
		public List<Book> getBooks() {
			return books;
		}
		public void setBooks(List<Book> books) {
			this.books = books;
		}
	  
}
