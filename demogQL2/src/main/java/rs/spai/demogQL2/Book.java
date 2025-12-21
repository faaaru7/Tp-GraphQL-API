package rs.spai.demogQL2;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Book {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idBook;
    private String title;
    private int publicationYear;
    private String language;
    private int nbPages;
   
    @ManyToOne
    
    private Author author;
    
    @ManyToOne
    private Category category;
}
