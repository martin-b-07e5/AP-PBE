package com.informatorio.tpfinal.repository;

import com.informatorio.tpfinal.entity.Source;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// using this repository and the entity Source, we can perform CRUD operations
@Repository
public interface SourceRepository extends JpaRepository<Source, Long> {

    //    https://www.baeldung.com/spring-data-derived-queries
    //    5. Similarity Condition Keywords
    List<Source> findByNameContaining(String name);

}
