package com.labo.rech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
@EnableJpaRepositories
public class LaboDeRechercheApplication {

	public static void main(String[] args) {
		SpringApplication.run(LaboDeRechercheApplication.class, args);
		System.out.println("hello world");
		
		
	}

}
