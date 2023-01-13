package com.ap.tpfinal.controller;

import com.ap.tpfinal.entity.Person;
import com.ap.tpfinal.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController  //https://www.baeldung.com/spring-controller-vs-restcontroller
//@RequestMapping(value = "/person")
@RequestMapping(value = "/api/v1/person")  //https://www.baeldung.com/spring-requestmapping
@CrossOrigin(origins = "http://localhost:4200")
//@CrossOrigin(origins = "https://ap-front--2023-01-12--firebase.web.app")
public class PersonController {

    //    private HelloService helloService = new HelloService();
    /*  Aplico el concepto de INYECCIÓN DE DEPENDENCIA,
      no lo instancio, lo delego.
      Ya no tengo el control, invierto el control (con @Autowired)
      y el que tiene el control es SPRING */
    @Autowired
    private PersonService personService;

    // READ ------------------------------
    @GetMapping("")
    public String helloE() {
        return "HELLO from the PersonController";
    }

    @GetMapping("/")
    public String helloR() {
        return "HELLO from the PersonController/";
    }

    // CREATE ------------------------------
    @PostMapping("/add")
    public Person addPerson(@RequestBody Person person) {
        return personService.add(person);
    }

    // UPDATE ------------------------------
    @PutMapping("/update")
    public Person updateArticle(@RequestBody Person person) {
        return personService.update(person);
    }
    // DELETE ------------------------------
    @DeleteMapping("/delete/{id}")
    public String deleteById(@PathVariable Long id) {
        return personService.deleteById(id);
    }

    // READ ------------------------------
    @GetMapping("/findAll")
    public List<Person> findAll() {
        return personService.findAll();
    }

    @GetMapping("/findById/{id}")
    public Person findById(@PathVariable Long id) {
        return personService.findById(id);
    }

    //    ------------------------
    /*@GetMapping("/findByFirstNameContainingOrLastNameContaining")
    public List<Person> findByFirstNameContainingOrLastNameContaining(@RequestParam String firstName, String lastName) {
        return personService.findByFirstNameContainingOrLastNameContaining(firstName, lastName);
    }*/

}
