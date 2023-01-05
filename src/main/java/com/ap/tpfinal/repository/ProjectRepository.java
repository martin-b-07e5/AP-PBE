package com.ap.tpfinal.repository;

import com.ap.tpfinal.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

    List<Project> findByNameContaining(String name);

    List<Project> findByCreatedAtGreaterThanEqual(LocalDate createdAt);

}
