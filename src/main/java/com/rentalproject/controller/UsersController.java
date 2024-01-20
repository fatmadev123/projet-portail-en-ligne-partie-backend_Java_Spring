package com.rentalproject.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.rentalproject.models.Users;
import com.rentalproject.services.UsersServices;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UsersController {
	@Autowired
    private UsersServices userService;
	
	    @GetMapping("/users")
	    public Iterable<Users> getUsers() {
	        return userService.getUsers();
	    }
	    
	    @GetMapping("/users/{id}")
	    public Optional<Users> getUser(@PathVariable Long id) {
	    	return userService.getUser(id);
	    }

}
