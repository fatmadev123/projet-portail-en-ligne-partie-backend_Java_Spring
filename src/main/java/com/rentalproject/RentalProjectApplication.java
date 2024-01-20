package com.rentalproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@SpringBootApplication()
public class RentalProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(RentalProjectApplication.class, args);
	}
	
}
