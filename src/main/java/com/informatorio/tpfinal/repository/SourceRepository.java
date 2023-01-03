package com.informatorio.tpfinal.repository;

import com.informatorio.tpfinal.entity.Education;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// using this repository and the entity Source, we can perform CRUD operations
@Repository
public interface SourceRepository extends JpaRepository<Education, Long> {

    //    https://www.baeldung.com/spring-data-derived-queries
    //    5. Similarity Condition Keywords
    List<Education> findByNameContaining(String name);

}
