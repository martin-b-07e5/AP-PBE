package com.informatorio.tpfinal.repository;

import com.informatorio.tpfinal.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// using this repository and the entity Author, we can perform CRUD operations
@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
//    List<Author> findByFullNameContaining(String fullName);

    //    https://www.baeldung.com/spring-data-derived-queries
    //    5. Similarity Condition Keywords
//    List<Author> findByNameStartingWith(String prefix);
//    List<Author> findByFirstNameStartingWith(String firstName);

//    List<Author> findByNameEndingWith(String suffix);

//    List<Author> findByNameContaining(String infix);
    List<Author> findByFullNameContaining(String fullName);

}
