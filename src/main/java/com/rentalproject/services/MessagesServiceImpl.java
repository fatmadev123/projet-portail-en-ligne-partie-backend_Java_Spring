package com.rentalproject.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rentalproject.models.Messages;
import com.rentalproject.repository.MessageRepository;

@Service
public class MessagesServiceImpl implements MessagesService {

	@Autowired
	private MessageRepository messageRepository;

	public void createMessage(Messages message) {

		if (message.getMessage().isBlank()) {
			throw new IllegalArgumentException("Invalid message");
		}

		if (Double.isNaN(message.getId()) || message.getId() < 0 || Double.isNaN(message.getRentalId())
				|| message.getRentalId() < 0) {
			throw new IllegalArgumentException("Invalid id values");
		}
		
		message.setCreatedAt(LocalDateTime.now());
		message.setUpdatedAt(LocalDateTime.now());

		messageRepository.save(message);
	}
}
