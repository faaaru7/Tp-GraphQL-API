package rs.spai.demogQL2;


import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
//import org.springframework.data.domain.Pageable;
import java.util.List;

public interface BookRepository  extends JpaRepository<Book,Long>{
	
	@Query(
		      value = "SELECT * FROM book LIMIT :size OFFSET :offset",
		      nativeQuery = true
		    )
		    List<Book> findBooksWithPagination(int size, int offset);
	
	
	 @Query(value = """
		        SELECT * FROM book b
		        WHERE (:publicationYear IS NULL OR b.publication_year = :publicationYear)
		          AND (:language IS NULL OR b.language = :language)
		          AND (:categoryId IS NULL OR b.category_idc = :categoryId)
		        LIMIT :size OFFSET :offset
		        """, nativeQuery = true)
	 List<Book> findFilteredBooks(
	            @Param("publicationYear") Integer publicationYear,
	            @Param("language") String language,
	            @Param("categoryId") Long categoryId,
	            @Param("size") int size,
	            @Param("offset") int offset
	    );

	    @Query(value = """
	        SELECT COUNT(*) FROM book b
	        WHERE (:publicationYear IS NULL OR b.publication_year = :publicationYear)
	          AND (:language IS NULL OR b.language = :language)
	          AND (:categoryId IS NULL OR b.category_idc = :categoryId)
	        """, nativeQuery = true)
	    long countFilteredBooks(
	            @Param("publicationYear") Integer publicationYear,
	            @Param("language") String language,
	            @Param("categoryId") Long categoryId
	    );
	    
	    @Query("SELECT b FROM Book b WHERE b.category.idC IN :categoryIds")
	    List<Book> findBooksByCategoryIds(@Param("categoryIds") List<Long> categoryIds);
	    
	    @Query("SELECT b FROM Book b WHERE b.author.idA = :authorId")
	    List<Book> findBooksByAuthorId(@Param("authorId") Long authorId);
	    
	    @Query("SELECT b FROM Book b WHERE LOWER(b.author.name) LIKE LOWER(CONCAT('%', :authorName, '%'))")
	    List<Book> findBooksByAuthorName(@Param("authorName") String authorName);


	    @Query("SELECT b FROM Book b WHERE LOWER(b.title) LIKE LOWER(CONCAT('%', :keyword, '%'))")
	    List<Book> searchByTitle(@Param("keyword") String keyword, Pageable pageable);

	    @Query("SELECT COUNT(b) FROM Book b WHERE LOWER(b.title) LIKE LOWER(CONCAT('%', :keyword, '%'))")
	    long countByTitle(@Param("keyword") String keyword);
	    

}
