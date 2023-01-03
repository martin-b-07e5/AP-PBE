package com.informatorio.tpfinal.service;

import com.informatorio.tpfinal.entity.Experience;
import com.informatorio.tpfinal.repository.ExperienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ExperienceService {

    //    private HelloService helloService = new HelloService();
    /*  Aplico el concepto de INYECCIÓN DE DEPENDENCIA,
      no lo instancio, lo delego.
      Ya no tengo el control, invierto el control (con @Autowired)
      y el que tiene el control es SPRING */
    @Autowired
    private ExperienceRepository experienceRepository;

    //  Below functions are called from the controller
    //    ------------------------
    public List<Experience> getAll() {
        return experienceRepository.findAll();
    }

    public Experience getById(Long id) {
        return experienceRepository.findById(id).get();
    }

    //    ------------------------
    public Experience add(Experience experience) {
        return experienceRepository.save(experience);
    }

    public Experience update(Experience experience) {
        return experienceRepository.save(experience);
    }

    public String deleteById(Long id) {
        experienceRepository.deleteById(id);
        return "author " + id + " deleted";
    }

    //    ------------------------
    public List<Experience> findByNameContaining(String name) {
        return experienceRepository.findByNameContaining(name);
    }

    public List<Experience> findByCreatedAtGreaterThanEqual(LocalDate createdAt) {
        return experienceRepository.findByCreatedAtGreaterThanEqual(createdAt);
    }

}
