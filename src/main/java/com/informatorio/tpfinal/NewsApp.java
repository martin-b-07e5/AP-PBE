package com.informatorio.tpfinal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/* https://www.baeldung.com/spring-autowire
Moreover, Spring Boot introduces the @SpringBootApplication annotation.
This single annotation is equivalent to using @Configuration, @EnableAutoConfiguration, and @ComponentScan.
Let's use this annotation in the main class of the application:
*/
@SpringBootApplication
// https://www.baeldung.com/spring-entityscan-vs-componentscan
@EntityScan("com.informatorio.tpfinal.entity")  // package where entities are located.
@ComponentScan({"com.informatorio.tpfinal.controller", "com.informatorio.tpfinal.service"})
@EnableJpaRepositories("com.informatorio.tpfinal.repository")
public class NewsApp {
    public static void main(String[] args) {
        SpringApplication.run(NewsApp.class, args);
        System.out.println("ok");
    }
}
