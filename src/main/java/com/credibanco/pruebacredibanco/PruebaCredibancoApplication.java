package com.credibanco.pruebacredibanco;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@ComponentScan ({"com.credibanco.pruebacredibanco"})
@EnableJpaRepositories ({"com.credibanco.pruebacredibanco"})
public class PruebaCredibancoApplication {

	public static void main(String[] args) {
		SpringApplication.run(PruebaCredibancoApplication.class, args);
	}

}
