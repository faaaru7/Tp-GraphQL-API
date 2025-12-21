package rs.spai.demogQL2;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Category {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idC;
    private String categoryName;
    private int parentCategory;
	@OneToMany (mappedBy = "category")
	private List<Book> books;

}
