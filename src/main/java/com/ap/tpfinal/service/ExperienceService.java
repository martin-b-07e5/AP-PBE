package com.ap.tpfinal.service;

import com.ap.tpfinal.entity.Experience;
import com.ap.tpfinal.repository.ExperienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//@Transactional
public class ExperienceService {

    @Autowired
    ExperienceRepository experienceRepository;

    // READ ----------------------------------
    public List<Experience> getAll() {
        return experienceRepository.findAll();
    }

    public Experience getById(Long id) {
        return experienceRepository.findById(id).get();
    }

    // CREATE/UPDATE ----------------------------------
    public Experience save(Experience experience) {
        return experienceRepository.save(experience);
    }

    // DELETE ----------------------------------
    public String deleteById(Long id) {
        experienceRepository.deleteById(id);
        return "experience " + id + " deleted";
    }

    // ----------------------------------
    public List<Experience> findByNameContaining(String name) {
        int query = name.length();
        if (query >= 3) {
            return experienceRepository.findByNameContaining(name);
        } else
            throw new IllegalArgumentException(
                    "The query must be 3 characters or more: " +
                            "Name: " + name
            );
    }

}
