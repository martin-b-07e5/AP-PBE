package com.ap.tpfinal.service;

import com.ap.tpfinal.repository.ProjectRepository;
import com.ap.tpfinal.entity.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    //  Below functions are called from the controller
    //    ------------------------
    public List<Project> getAll() {
        return projectRepository.findAll();
    }

    public Project getById(Long id) {
        return projectRepository.findById(id).orElse(null);
    }

    //    ------------------------
    public Project add(Project project) {
        return projectRepository.save(project);
    }

    public Project update(Project project) {
        return projectRepository.save(project);
    }

    public String deleteById(Long id) {
        projectRepository.deleteById(id);
        return "project " + id + " deleted";
    }

    //    ------------------------
    public List<Project> findByNameContaining(String name) {
        int query = name.length();
        if (query >= 3) {
            return projectRepository.findByNameContaining(name);
        } else
            throw new IllegalArgumentException(
                    "The query must be 3 characters or more: " +
                            "Name: " + name
            );
    }

    public List<Project> findByCreatedAtGreaterThanEqual(LocalDate createdAt) {
        return projectRepository.findByCreatedAtGreaterThanEqual(createdAt);
    }

}
