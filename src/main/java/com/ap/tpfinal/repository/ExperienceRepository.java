package com.ap.tpfinal.repository;

import com.ap.tpfinal.entity.Experience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ExperienceRepository extends JpaRepository<Experience, Long> {

    List<Experience> findByNameContaining(String name);

    List<Experience> findByCreatedAtGreaterThanEqual(LocalDate createdAt);

    // ------------------------
    boolean existsByName(String name);

}
