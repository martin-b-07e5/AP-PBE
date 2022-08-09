package com.informatorio.tpfinal.repository;

import com.informatorio.tpfinal.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// using this repository and the entity Author, we can perform CRUD operations
@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

}
