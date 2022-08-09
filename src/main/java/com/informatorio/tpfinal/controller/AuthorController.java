package com.informatorio.tpfinal.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController  //https://www.baeldung.com/spring-controller-vs-restcontroller
@RequestMapping("/author")  //https://www.baeldung.com/spring-requestmapping
public class AuthorController {
    @GetMapping("/")
    public String hello() {
        return "HELLO from the controller";
    }
}
