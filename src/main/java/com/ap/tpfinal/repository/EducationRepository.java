package com.ap.tpfinal.repository;

import com.ap.tpfinal.entity.Education;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EducationRepository extends JpaRepository<Education, Long> {

    List<Education> findByNameContaining(String name);

    List<Education> findByCreatedAtGreaterThanEqual(LocalDate createdAt);

}
