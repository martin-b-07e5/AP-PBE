package com.informatorio.tpfinal.controller;

import com.informatorio.tpfinal.entity.Author;
import com.informatorio.tpfinal.repository.AuthorRepository;
import com.informatorio.tpfinal.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController  //https://www.baeldung.com/spring-controller-vs-restcontroller
@RequestMapping("/author")  //https://www.baeldung.com/spring-requestmapping
public class AuthorController {

    //    private HelloService helloService = new HelloService();
    /*  Aplico el concepto de INYECCIÓN DE DEPENDENCIA,
      no lo instancio, lo delego.
      Ya no tengo el control, invierto el control (con @Autowired)
      y el que tiene el control es SPRING */
    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private AuthorService authorService;

    //    ------------------------
    @GetMapping("")
    public String helloE() {
        return "HELLO from the AuthorController";
    }

    @GetMapping("/")
    public String helloR() {
        return "HELLO from the AuthorController/";
    }

    //    ------------------------
    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public @ResponseBody Iterable<Author> findAuthors() {
        return authorRepository.findAll();
    }

    // call function defined in SourceService
    @GetMapping("/getAll")
    public List<Author> getAll() {
        return authorService.getAll();
    }

    @GetMapping("/getById/{id}")
    public Author getById(@PathVariable Long id) {
        return authorService.getById(id);
    }

    //    ------------------------
    @PostMapping("/add")
    public Author createAuthor(@RequestBody Author author) {
        return authorService.add(author);
    }

    @PutMapping("/update")
    public Author update(@RequestBody Author author){
        return authorService.update(author);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteById(@PathVariable Long id) {
        return authorService.deleteById(id);
    }

}