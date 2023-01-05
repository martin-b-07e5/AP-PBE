package com.ap.tpfinal.controller;

import com.ap.tpfinal.entity.Person;
import com.ap.tpfinal.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController  //https://www.baeldung.com/spring-controller-vs-restcontroller
//@RequestMapping(value = "/person")
@RequestMapping(value = "/api/v1/person")  //https://www.baeldung.com/spring-requestmapping
public class PersonController {

    //    private HelloService helloService = new HelloService();
    /*  Aplico el concepto de INYECCIÓN DE DEPENDENCIA,
      no lo instancio, lo delego.
      Ya no tengo el control, invierto el control (con @Autowired)
      y el que tiene el control es SPRING */
    @Autowired
    private PersonService personService;

    //    ------------------------
    @GetMapping("")
    public String helloE() {
        return "HELLO from the PersonController";
    }

    @GetMapping("/")
    public String helloR() {
        return "HELLO from the PersonController/";
    }

    //    ------------------------
    @PostMapping("/add")
    public Person addPerson(@RequestBody Person person) {
        return personService.add(person);
    }

    @PutMapping("/update")
    public Person updateArticle(@RequestBody Person person) {
        return personService.update(person);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteById(@PathVariable Long id) {
        return personService.deleteById(id);
    }

    //    ------------------------
    @GetMapping("/findAll")
    public List<Person> findAll() {
        return personService.findAll();
    }

    @GetMapping("/findById/{id}")
    public Person findById(@PathVariable Long id) {
        return personService.findById(id);
    }

    //    ------------------------
    @GetMapping("/findByFirstNameContainingOrLastNameContaining")
    public List<Person> findByFirstNameContainingOrLastNameContaining(@RequestParam String firstName, String lastName) {
        return personService.findByFirstNameContainingOrLastNameContaining(firstName, lastName);
    }

}
