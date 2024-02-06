package com.rentalproject.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rentalproject.models.Message;
import com.rentalproject.repository.MessageRepository;

@Service
public class MessagesServiceImpl implements MessagesService {

	@Autowired
	private MessageRepository messageRepository;

	public void createMessage(Message message) {
		message.setCreatedAt(LocalDateTime.now());
		message.setUpdatedAt(LocalDateTime.now());

		messageRepository.save(message);
	}
}
