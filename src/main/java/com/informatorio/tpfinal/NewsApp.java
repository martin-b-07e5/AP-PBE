package com.informatorio.tpfinal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EntityScan("com.informatorio.tpfinal.entity")  // where entities are located.
// https://www.baeldung.com/spring-entityscan-vs-componentscan
@ComponentScan({"com.informatorio.tpfinal.controller", "com.informatorio.tpfinal.service"})
public class NewsApp {

    public static void main(String[] args) {
        SpringApplication.run(NewsApp.class, args);
    }

}
