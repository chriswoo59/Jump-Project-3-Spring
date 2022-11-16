package com.cognixia.jump.project3spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication

@OpenAPIDefinition(
info = @Info( title="Restaurant API", version="1.0",
		 description="API that allows a Restaurant to keep track of orders"))
public class Project3SpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(Project3SpringApplication.class, args);
	}

}
