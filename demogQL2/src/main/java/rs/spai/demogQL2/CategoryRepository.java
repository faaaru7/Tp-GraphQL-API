package rs.spai.demogQL2;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
	@Query("SELECT c FROM Category c WHERE LOWER(c.categoryName) LIKE LOWER(CONCAT('%', :keyword, '%'))")
	List<Category> searchByName(@Param("keyword") String keyword, Pageable pageable);

	@Query("SELECT COUNT(c) FROM Category c WHERE LOWER(c.categoryName) LIKE LOWER(CONCAT('%', :keyword, '%'))")
	long countByName(@Param("keyword") String keyword);

	
	
}
