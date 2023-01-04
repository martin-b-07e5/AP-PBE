package com.informatorio.tpfinal.repository;

import com.informatorio.tpfinal.entity.Technology;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TechnologyRepository extends JpaRepository<Technology, Long> {

    List<Technology> findByNameContaining(String name);

    List<Technology> findByCreatedAtGreaterThanEqual(LocalDate createdAt);

}
