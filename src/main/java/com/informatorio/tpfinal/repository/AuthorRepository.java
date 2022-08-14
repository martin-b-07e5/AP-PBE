package com.informatorio.tpfinal.repository;

import com.informatorio.tpfinal.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

// using this repository and the entity Author, we can perform CRUD operations
@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
//public interface AuthorRepository extends PagingAndSortingRepository<Author, Long> {
    //    https://www.baeldung.com/spring-data-derived-queries
    //    5. Similarity Condition Keywords
    List<Author> findByFullNameContaining(String fullName);

    Author findByCreatedAtGreaterThanEqual(LocalDate createdAt);


}
