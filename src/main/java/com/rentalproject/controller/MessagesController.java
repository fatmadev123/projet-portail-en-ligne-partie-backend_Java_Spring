package com.rentalproject.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.rentalproject.models.Messages;
import com.rentalproject.repository.MessageRepository;
import com.rentalproject.services.MessagesServices;

import jakarta.transaction.Transactional;

@RestController
public class MessagesController {
	 @Autowired
	 private MessageRepository messagesRepository;
	@Autowired
    private MessagesServices messageService;
	
	    @GetMapping("/messages")
	    public Iterable<Messages> getMessages() {
	        return messageService.getMessages();
	    }
	    
	    @PutMapping("/messages/{id}")
	    public Messages replacemessage(@RequestBody Messages newMessages, @PathVariable Long id) {
	      
	      return messagesRepository.findById(id)
	        .map(message -> {
	          message.setMessage(newMessages.getMessage());
	          message.setCreatedAt(newMessages.getCreatedAt());
	          message.setUpdatedAt(newMessages.getUpdatedAt());
	          return messagesRepository.save(message);
	        })
	        .orElseGet(() -> {
	          newMessages.setId(id);
	          return messagesRepository.save(newMessages);
	        });
	    }
	    
	    @GetMapping("/messages/{id}")
		   public ResponseEntity<Messages> getMessage(@PathVariable Long id){
	    	Optional<Messages> message = messageService.getmessage(id);
	    	 return message.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
		    }
	    
	    @PostMapping(value = "/messages")
		@Transactional
		public ResponseEntity<Messages> saveMessage(@RequestBody Messages message) {
			Messages messageSaved = messageService.saveMessage(message);		
	 		return new ResponseEntity<Messages>(messageSaved, HttpStatus.CREATED);
	 	}
}
