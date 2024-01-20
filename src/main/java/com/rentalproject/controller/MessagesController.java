package com.rentalproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.rentalproject.models.Messages;
import com.rentalproject.services.MessagesServices;

@RestController
public class MessagesController {
	@Autowired
    private MessagesServices messageService;
	
	    @GetMapping("/messages")
	    public Iterable<Messages> getMessages() {
	        return messageService.getMessages();
	    }
}
