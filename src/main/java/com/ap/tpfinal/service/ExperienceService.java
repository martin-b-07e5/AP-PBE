package com.ap.tpfinal.service;

import com.ap.tpfinal.entity.Experience;
import com.ap.tpfinal.repository.ExperienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
//@Transactional
public class ExperienceService {

    @Autowired
    private ExperienceRepository experienceRepository;

    //  Below functions are called from the controller

    // READ ----------------------------------
    public List<Experience> getAll() {
        return experienceRepository.findAll();
    }

    public Experience getById(Long id) {
        return experienceRepository.findById(id).orElse(null);
    }

    public Optional<Experience> getOne(Long id) {
        return experienceRepository.findById(id);
    }

    public Optional<Experience> getByName(String name) {
        return experienceRepository.findByName(name);
    }

    // CREATE ----------------------------------
    public void save(Experience experience) {
        experienceRepository.save(experience);
    }

    /*public Experience save(Experience experience) {
        return experienceRepository.save(experience);
    }*/

    public Experience add(Experience experience) {
        return experienceRepository.save(experience);
    }


    // UPDATE ----------------------------------
    public Experience update(Experience experience) {
        return experienceRepository.save(experience);
    }

    // DELETE ----------------------------------
    public String deleteById(Long id) {
        experienceRepository.deleteById(id);
        return "experience " + id + " deleted";
    }

    // ------------------------
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

    // ------------------------
    public boolean existById(Long id) {
        return experienceRepository.existsById(id);
    }

}
