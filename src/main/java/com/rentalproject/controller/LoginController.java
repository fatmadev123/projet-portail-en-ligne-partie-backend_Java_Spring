package com.rentalproject.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rentalproject.services.JWTService;


@RestController
public class LoginController {


	private JWTService jwtService;
	
	public LoginController(JWTService jwtService) {
		this.jwtService = jwtService;
	}
	
	@PostMapping("/auth/login")
	public String getToken(Authentication authentication) {
        		String token = jwtService.generateToken(authentication);
        		return token;
	}
	
	//@PostMapping("/auth/register")
	//@GetMapping("/auth/me")
	
}
