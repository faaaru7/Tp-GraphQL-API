package rs.spai.demogQL2;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;



public interface AuthorRepository  extends JpaRepository<Author,Long>{
	@Query("SELECT a FROM Author a WHERE LOWER(a.name) LIKE LOWER(CONCAT('%', :keyword, '%'))")
	List<Author> searchByName(@Param("keyword") String keyword, Pageable pageable);

	@Query("SELECT COUNT(a) FROM Author a WHERE LOWER(a.name) LIKE LOWER(CONCAT('%', :keyword, '%'))")
	long countByName(@Param("keyword") String keyword);


}
