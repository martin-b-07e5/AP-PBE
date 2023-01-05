package com.ap.tpfinal.service;

import com.ap.tpfinal.repository.TechnologyRepository;
import com.ap.tpfinal.entity.Technology;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnologyService {

    @Autowired
    private TechnologyRepository technologyRepository;

    //  Below functions are called from the controller
    //    ------------------------
    public List<Technology> getAll() {
        return technologyRepository.findAll();
    }

    public Technology getById(Long id) {
        return technologyRepository.findById(id).orElse(null);
    }

    //    ------------------------
    public Technology add(Technology technology) {
        return technologyRepository.save(technology);
    }

    public Technology update(Technology technology) {
        return technologyRepository.save(technology);
    }

    public String deleteById(Long id) {
        technologyRepository.deleteById(id);
        return "technology " + id + " deleted";
    }

    //    ------------------------
    public List<Technology> findByNameContaining(String name) {
        int query = name.length();
        if (query >= 3) {
            return technologyRepository.findByNameContaining(name);
        } else
            throw new IllegalArgumentException(
                    "The query must be 3 characters or more: " +
                            "Name: " + name
            );
    }

}
