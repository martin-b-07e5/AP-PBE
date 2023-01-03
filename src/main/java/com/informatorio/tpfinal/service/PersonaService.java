package com.informatorio.tpfinal.service;

import com.informatorio.tpfinal.entity.Persona;
import com.informatorio.tpfinal.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaService {

    //    private HelloService helloService = new HelloService();
    /*  Aplico el concepto de INYECCIÓN DE DEPENDENCIA,
      no lo instancio, lo delego.
      Ya no tengo el control, invierto el control (con @Autowired)
      y el que tiene el control es SPRING */
    @Autowired
    private PersonaRepository personaRepository;

    //  Below functions are called from the controller
    //    ------------------------
    public List<Persona> findAll() {
        return personaRepository.findAll();
    }

    public Persona findById(Long id) {
//        return personaRepository.findById(id).get();
        return personaRepository.findById(id).orElse(null);
    }

    //    ------------------------
    public Persona add(Persona persona) {
        return personaRepository.save(persona);
    }

    public Persona update(Persona persona) {
        return personaRepository.save(persona);
    }

    public String deleteById(Long id) {
        personaRepository.deleteById(id);
        return "persona " + id + " deleted";
    }

    //    ------------------------
    public List<Persona> findByFirstNameContainingOrLastNameContaining(String firstName, String lastName) {
        int query = firstName.length() + lastName.length();
        if (query >= 3) {
            return personaRepository.findByFirstNameContainingOrLastNameContaining(firstName, lastName);
        } else
            throw new IllegalArgumentException("The query must be 3 characters or more: " + "firstName = " + firstName + ", " + " lastName = " + lastName);
    }

}
