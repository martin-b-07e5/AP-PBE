package com.informatorio.tpfinal.controller;

import com.informatorio.tpfinal.entity.Article;
import com.informatorio.tpfinal.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController  //https://www.baeldung.com/spring-controller-vs-restcontroller
//@RequestMapping(value = "/article")
@RequestMapping(value = "/api/v1/article")  //https://www.baeldung.com/spring-requestmapping
public class ArticleController {

    //    private HelloService helloService = new HelloService();
    /*  Aplico el concepto de INYECCIÓN DE DEPENDENCIA,
      no lo instancio, lo delego.
      Ya no tengo el control, invierto el control (con @Autowired)
      y el que tiene el control es SPRING */
    @Autowired
    private ArticleService articleService;

    //    ------------------------
    @GetMapping("")
    public String helloE() {
        return "HELLO from the ArticleController";
    }

    @GetMapping("/")
    public String helloR() {
        return "HELLO from the ArticleController/";
    }

    //    ------------------------
    @PostMapping("/add")
    public Article addArticle(@RequestBody Article article) {
        return articleService.add(article);
    }

    // se podría hacer con 'PathVariable' tipo 'deleteById' y 'findById'
    // y 'RequestParam' tipo 'findByTitleContainingOrDescriptionContaining'
    @PutMapping("/update")
    public Article updateArticle(@RequestBody Article article) {
        return articleService.update(article);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteById(@PathVariable Long id) {
        return articleService.deleteById(id);
    }

    //    ------------------------
    @GetMapping("/findAll")
    public List<Article> findAll() {
        return articleService.findAll();
    }

    @GetMapping("/findById/{id}")
    public Article findById(@PathVariable Long id) {
        return articleService.findById(id);
    }

    //    ------------------------
    @GetMapping("/findByTitleContainingOrDescriptionContaining")
    public List<Article> findByTitleContainingOrDescriptionContaining(@RequestParam String title, String description) {
        return articleService.findByTitleContainingOrDescriptionContaining(title, description);
    }

}
