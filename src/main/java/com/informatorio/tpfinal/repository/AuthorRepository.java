package com.informatorio.tpfinal.repository;

import com.informatorio.tpfinal.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

// using this repository and the entity Author, we can perform CRUD operations
@Repository
//public interface AuthorRepository extends PagingAndSortingRepository<Author, Long> {
public interface AuthorRepository extends JpaRepository<Author, Long> {
    //    https://www.baeldung.com/spring-data-derived-queries
    //    5. Similarity Condition Keywords
    List<Author> findByFullNameContaining(String fullName);

//    https://www.bezkoder.com/jpa-repository-query/#JPA_Repository_Query_with_Comparison
//    https://www.bezkoder.com/jpa-repository-query/#JPA_find_by_field
//    https://www.bezkoder.com/jpa-repository-query/#JPA_find_by_multiple_Columns
    List<Author> findByCreatedAtGreaterThanEqual(LocalDate createdAt);


    //    tratando de hacer funcionar la relacion manyToOne
    Author findByIdContaining(Long idAuthor);


}
