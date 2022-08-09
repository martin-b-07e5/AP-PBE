package com.informatorio.tpfinal.controller;

import com.informatorio.tpfinal.entity.Author;
import com.informatorio.tpfinal.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController  //https://www.baeldung.com/spring-controller-vs-restcontroller
//@RequestMapping("/author")  //https://www.baeldung.com/spring-requestmapping
public class AuthorController {

    @Autowired
    private AuthorRepository repository;

    //    private HelloService helloService = new HelloService();
    /*  Aplico el concepto de INYECCIÓN DE DEPENDENCIA,
      no lo instancio, lo delego.
      Ya no tengo el control, invierto el control (con @Autowired)
      y el que tiene el control es SPRING */

    @GetMapping("/")
    public String hello() {
        return "HELLO from the controller";
    }

    @RequestMapping(value = "/author", method = RequestMethod.GET)
    public @ResponseBody Iterable<Author> findEmpleados() {
        return repository.findAll();
    }
}
