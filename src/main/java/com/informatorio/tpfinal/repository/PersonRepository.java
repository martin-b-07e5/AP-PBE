package com.informatorio.tpfinal.repository;

import com.informatorio.tpfinal.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// using this repository and the entity Article, we can perform CRUD operations
@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    List<Person> findByFirstNameContainingOrLastNameContaining(String firstName, String lastName);
//  List<Article> findByFirstNameContainingAndLastNameContaining(String firstName, String lastName);

}
