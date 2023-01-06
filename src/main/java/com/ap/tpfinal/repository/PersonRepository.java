package com.ap.tpfinal.repository;

import com.ap.tpfinal.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// using this repository and the entity Article, we can perform CRUD operations
@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    List<Person> findByFirstNameContainingOrLastNameContaining(String firstName, String lastName);

    // https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation
    List<Person> findByFirstNameContainingAndLastNameContaining(String firstName, String lastName);

}
