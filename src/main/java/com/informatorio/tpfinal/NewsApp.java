package com.informatorio.tpfinal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.informatorio.tpfinal.entity")  // where entities are located.
public class NewsApp {

	public static void main(String[] args) {
		SpringApplication.run(NewsApp.class, args);
	}

}
