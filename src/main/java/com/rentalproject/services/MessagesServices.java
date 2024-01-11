package com.rentalproject.services;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rentalproject.models.Messages;
import com.rentalproject.repository.MessageProxy;
import com.rentalproject.repository.MessageRepository;

import lombok.Data;

@Data
@Service
public class MessagesServices {
    @Autowired
    private MessageRepository messageRepository;

    public Optional<Messages> getmessage(final Long id) {
        return messageRepository.findById(id);
    }

    public Iterable<Messages> getMessages() {
        return messageRepository.findAll();
    }

    public void deleteMessage(final Long id) {
    	messageRepository.deleteById(id);
    }

    public Messages saveMessage(Messages message) {
        Messages savedMessage = messageRepository.save(message);
        return savedMessage;
    }
    
    
    

	/*
	 * @Autowired private MessageProxy messageProxy;
	 * 
	 * public Messages getMessage(final int id) { return
	 * messageProxy.getMessages(id); }
	 * 
	 * public Iterable<Messages> getMessage() { return messageProxy.getMessages(); }
	 * 
	 * public void deletemessage(final int id) { messageProxy.deletemessage(id); }
	 * 
	 * public Messages savemessage(Messages message) { Messages savedMessages;
	 * 
	 * if(message.getId() == null) { // Si l'id est nul, alors c'est un nouvel
	 * message. savedMessages = messageProxy.createMessages(message); } else {
	 * savedMessages = messageProxy.updateMessage(message); }
	 * 
	 * return savedMessages; }
	 */

}