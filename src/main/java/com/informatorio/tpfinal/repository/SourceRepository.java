package com.informatorio.tpfinal.repository;

import com.informatorio.tpfinal.entity.Source;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// using this repository and the entity Source, we can perform CRUD operations
@Repository
public interface SourceRepository extends JpaRepository<Source, Long> {
    Source findByName(String name);
}
