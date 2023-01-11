package com.ap.tpfinal.service;

import com.ap.tpfinal.repository.EducationRepository;
import com.ap.tpfinal.entity.Education;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationService {

    @Autowired
    private EducationRepository educationRepository;

    // READ ----------------------------------
    public List<Education> getAll() {
        return educationRepository.findAll();
    }

    public Education getById(Long id) {
        return educationRepository.findById(id).orElse(null);
    }

    // CREATE/UPDATE ----------------------------------
    public Education save(Education education) {
        return educationRepository.save(education);
    }

    // DELETE ----------------------------------
    public String deleteById(Long id) {
        educationRepository.deleteById(id);
        return "education " + id + " deleted";
    }

    // ----------------------------------
    public List<Education> findByNameContaining(String name) {
        int query = name.length();
        if (query >= 3) {
            return educationRepository.findByNameContaining(name);
        } else
            throw new IllegalArgumentException(
                    "The query must be 3 characters or more: " +
                            "Name: " + name
            );
    }

}
