package com.informatorio.tpfinal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
// https://www.baeldung.com/spring-entityscan-vs-componentscan
@EntityScan("com.informatorio.tpfinal.entity")  // package where entities are located.
@ComponentScan({"com.informatorio.tpfinal.controller", "com.informatorio.tpfinal.service"})
@EnableJpaRepositories("com.informatorio.tpfinal.repository")
public class NewsApp {

    public static void main(String[] args) {
        SpringApplication.run(NewsApp.class, args);
    }
}
