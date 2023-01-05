package com.ap.tpfinal.service;

import com.ap.tpfinal.repository.PersonRepository;
import com.ap.tpfinal.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    //    private HelloService helloService = new HelloService();
    /*  Aplico el concepto de INYECCIÓN DE DEPENDENCIA,
      no lo instancio, lo delego.
      Ya no tengo el control, invierto el control (con @Autowired)
      y el que tiene el control es SPRING */
    @Autowired
    private PersonRepository personRepository;

    //  Below functions are called from the controller
    //    ------------------------
    public List<Person> findAll() {
        return personRepository.findAll();
    }

    public Person findById(Long id) {
//        return personRepository.findById(id).get();
        return personRepository.findById(id).orElse(null);
    }

    //    ------------------------
    public Person add(Person person) {
        return personRepository.save(person);
    }

    public Person update(Person person) {
        return personRepository.save(person);
    }

    public String deleteById(Long id) {
        personRepository.deleteById(id);
        return "person " + id + " deleted";
    }

    //    ------------------------
    public List<Person> findByFirstNameContainingOrLastNameContaining(String firstName, String lastName) {
        int query = firstName.length() + lastName.length();
        if (query >= 3) {
            return personRepository.findByFirstNameContainingOrLastNameContaining(firstName, lastName);
        } else
            throw new IllegalArgumentException("The query must be 3 characters or more: " + "firstName = " + firstName + ", " + " lastName = " + lastName);
    }

}
