package com.informatorio.tpfinal.service;

import com.informatorio.tpfinal.entity.Education;
import com.informatorio.tpfinal.repository.EducationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationService {

    @Autowired
    private EducationRepository educationRepository;

    //  Below functions are called from the controller
    //    ------------------------
    public List<Education> getAll() {
        return educationRepository.findAll();
    }

    public Education getById(Long id) {
        return educationRepository.findById(id).orElse(null);
    }

    //    ------------------------
    public Education add(Education education) {
        return educationRepository.save(education);
    }

    public Education update(Education education) {
        return educationRepository.save(education);
    }

    public String deleteById(Long id) {
        educationRepository.deleteById(id);
        return "education " + id + " deleted";
    }

    //    ------------------------
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
