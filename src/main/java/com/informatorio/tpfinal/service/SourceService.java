package com.informatorio.tpfinal.service;

import com.informatorio.tpfinal.entity.Education;
import com.informatorio.tpfinal.repository.SourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SourceService {

    //    private HelloService helloService = new HelloService();
    /*  Aplico el concepto de INYECCIÓN DE DEPENDENCIA,
      no lo instancio, lo delego.
      Ya no tengo el control, invierto el control (con @Autowired)
      y el que tiene el control es SPRING */
    @Autowired
    private SourceRepository sourceRepository;

    //  Below functions are called from the controller
    //    ------------------------
    public Education add(Education education) {
        return sourceRepository.save(education);
    }

    public Education update(Education education) {
        return sourceRepository.save(education);
    }

    public String deleteById(Long id) {
        sourceRepository.deleteById(id);
        return "education " + id + " deleted";
    }

    //    ------------------------
    public List<Education> getAll() {
        return sourceRepository.findAll();
    }

    public Education getById(Long id) {
//        return sourceRepository.findById(id).get();
        return sourceRepository.findById(id).orElse(null);
    }

    //    ------------------------
    public List<Education> findByNameContaining(String name) {
        return sourceRepository.findByNameContaining(name);
    }

}