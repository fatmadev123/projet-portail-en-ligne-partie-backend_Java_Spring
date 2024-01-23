package com.rentalproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
//import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

//@EnableSwagger2

//@EnableSwagger2WebMvc
@EnableWebMvc
@SpringBootApplication()
public class RentalProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(RentalProjectApplication.class, args);
	}
	
}
