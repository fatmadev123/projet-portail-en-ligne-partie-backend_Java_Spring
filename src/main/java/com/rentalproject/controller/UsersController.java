package com.rentalproject.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rentalproject.models.Users;
import com.rentalproject.repository.UsersRepository;
import com.rentalproject.services.UsersServices;

import jakarta.transaction.Transactional;

@RestController
public class UsersController {
	 @Autowired
	 private UsersRepository usersRepository;
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
	    
	    @PutMapping("/users/{id}")
	    public Users replaceuser(@RequestBody Users newuser, @PathVariable Long id) {
	      return usersRepository.findById(id)
	        .map(user -> {
	        	user.setEmail(newuser.getEmail());
	          user.setName(newuser.getName());
	          user.setPassword(newuser.getPassword());
	 		  user.setCreatedAt(newuser.getCreatedAt());
	 		  user.setUpdatedAt(newuser.getUpdatedAt());
	          return usersRepository.save(user);
	        })
	        .orElseGet(() -> {
	          newuser.setId(id);
	          return usersRepository.save(newuser);
	        });
	    }
	    
	    @PostMapping(value = "/users")
		@Transactional
		public ResponseEntity<Users> saveuser(@RequestBody Users user) {
			Users userSaved = userService.saveUser(user);		
	 		return new ResponseEntity<Users>(userSaved, HttpStatus.CREATED);
	 	}
}
