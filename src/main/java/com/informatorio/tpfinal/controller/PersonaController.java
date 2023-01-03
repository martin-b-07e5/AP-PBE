package com.informatorio.tpfinal.controller;

import com.informatorio.tpfinal.entity.Persona;
import com.informatorio.tpfinal.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController  //https://www.baeldung.com/spring-controller-vs-restcontroller
//@RequestMapping(value = "/persona")
@RequestMapping(value = "/api/v1/persona")  //https://www.baeldung.com/spring-requestmapping
public class PersonaController {

    //    private HelloService helloService = new HelloService();
    /*  Aplico el concepto de INYECCIÓN DE DEPENDENCIA,
      no lo instancio, lo delego.
      Ya no tengo el control, invierto el control (con @Autowired)
      y el que tiene el control es SPRING */
    @Autowired
    private PersonaService personaService;

    //    ------------------------
    @GetMapping("")
    public String helloE() {
        return "HELLO from the PersonaController";
    }

    @GetMapping("/")
    public String helloR() {
        return "HELLO from the PersonaController/";
    }

    //    ------------------------
    @PostMapping("/add")
    public Persona addPersona(@RequestBody Persona persona) {
        return personaService.add(persona);
    }

    @PutMapping("/update")
    public Persona updateArticle(@RequestBody Persona persona) {
        return personaService.update(persona);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteById(@PathVariable Long id) {
        return personaService.deleteById(id);
    }

    //    ------------------------
    @GetMapping("/findAll")
    public List<Persona> findAll() {
        return personaService.findAll();
    }

    @GetMapping("/findById/{id}")
    public Persona findById(@PathVariable Long id) {
        return personaService.findById(id);
    }

    //    ------------------------
    @GetMapping("/findByFirstNameContainingOrLastNameContaining")
    public List<Persona> findByFirstNameContainingOrLastNameContaining(@RequestParam String firstName, String lastName) {
        return personaService.findByFirstNameContainingOrLastNameContaining(firstName, lastName);
    }

}
