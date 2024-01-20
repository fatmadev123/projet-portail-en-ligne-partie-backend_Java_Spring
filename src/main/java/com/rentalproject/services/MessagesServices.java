package com.rentalproject.services;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rentalproject.models.Messages;
import com.rentalproject.repository.MessageRepository;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
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
    
}
