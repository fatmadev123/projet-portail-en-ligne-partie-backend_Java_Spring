package com.rentalproject.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.rentalproject.dto.MessageRequest;
import com.rentalproject.dto.MessageResponse;
import com.rentalproject.models.Message;
import com.rentalproject.models.Rental;
import com.rentalproject.repository.RentalsRepository;
import com.rentalproject.services.AuthService;
import com.rentalproject.services.MessagesService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/messages")
public class MessagesController {
	@Autowired
	private MessagesService messagesService;
	@Autowired
	private AuthService authService;
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private RentalsRepository rentalRepository;

	@Operation(security = { @SecurityRequirement(name = "bearer-key") }, summary = "Creates a new message")
	@ApiResponse(responseCode = "200", description = "Message created")
	@ApiResponse(responseCode = "400", description = "Invalid message value or invalid id value")
	@ApiResponse(responseCode = "503", description = "Service unavailable")
	@PostMapping("/")
	public ResponseEntity<MessageResponse> createMessage(@RequestBody MessageRequest messageRequest) {
		System.out.println(messageRequest.toString());
		System.out.println(messageRequest.getRental_id());
		System.out.println(messageRequest.getUser_id());
		Message message = modelMapper.map(messageRequest, Message.class);
		System.out.println("message"+message);
		authService.getMe().ifPresent(me -> message.setUser(me));
		Rental rental =(Rental) rentalRepository.findById(messageRequest.getRental_id()).get();
		System.out.println("rental de message"+rental);
		message.setRental(rental);
		System.out.println("messsaaage final"+message);
		try {
			messagesService.createMessage(message);
		} catch (IllegalArgumentException ex) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} catch (Exception ex) {
			return new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);
		}
		MessageResponse messageResponse = new MessageResponse();
		messageResponse.setMessage("Message created");
		return ResponseEntity.status(HttpStatus.OK).body(messageResponse);
	}	
}
