package com.rentalproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rentalproject.models.Messages;
import com.rentalproject.services.MessagesServices;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class MessagesController {
	@Autowired
    private MessagesServices messageService;
	
	  /**
	    * Read - Get all messages
	    * @return - An Iterable object of message full filled
	    */
	    @GetMapping("/messages")
	    public Iterable<Messages> getMessages() {
	        return messageService.getMessages();
	    }
}
