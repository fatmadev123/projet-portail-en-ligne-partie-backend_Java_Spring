package com.rentalproject.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.rentalproject.models.Messages;
import com.rentalproject.services.CustomProperties;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class MessageProxy {
		//@Autowired
		private CustomProperties props;

		/**
		 * Get all messages
		 * @return An iterable of all messages
		 */
		public Iterable<Messages> getMessages() {

			String baseApiUrl = props.getApiUrl();
			String getMessagesUrl = baseApiUrl + "/messages";

			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<Iterable<Messages>> response = restTemplate.exchange(
					getMessagesUrl, 
					HttpMethod.GET, 
					null,
					new ParameterizedTypeReference<Iterable<Messages>>() {}
				);
			
//			Log.debug("Get Messages call " + response.getStatusCode().toString());
			
			System.out.println("Get Messages call " + response.getStatusCode().toString());
			
			return response.getBody();
		}
		
		/**
		 * Get an message by the id
		 * @param id The id of the message
		 * @return The message which matches the id
		 */
		public Messages getMessages(int id) {
			String baseApiUrl = props.getApiUrl();
			String getMessagesUrl = baseApiUrl + "/messages/" + id;

			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<Messages> response = restTemplate.exchange(
					getMessagesUrl, 
					HttpMethod.GET, 
					null,
					Messages.class
				);
			
			//log.debug("Get messages call " + response.getStatusCode().toString());
			System.out.println("Get messages call " + response.getStatusCode().toString());
			return response.getBody();
		}
		
		/**
		 * Add a new message 
		 * @param e A new message (without an id)
		 * @return The message full filled (with an id)
		 */
		public Messages createMessages(Messages e) {
			String baseApiUrl = props.getApiUrl();
			String createEmployeeUrl = baseApiUrl + "/messages";
			
			RestTemplate restTemplate = new RestTemplate();
			HttpEntity<Messages> request = new HttpEntity<Messages>(e);
			ResponseEntity<Messages> response = restTemplate.exchange(
					createEmployeeUrl, 
					HttpMethod.POST, 
					request, 
					Messages.class);
			
			//log.debug("Create message call " + response.getStatusCode().toString());
			System.out.println("Create message call " + response.getStatusCode().toString());
			return response.getBody();
		}
		
		/**
		 * Update a message - using the PUT HTTP Method.
		 * @param e Existing message to update
		 */
		public Messages updateMessage(Messages e) {
			String baseApiUrl = props.getApiUrl();
			String updateMessageUrl = baseApiUrl + "/messages/" + e.getId();

			RestTemplate restTemplate = new RestTemplate();
			HttpEntity<Messages> request = new HttpEntity<Messages>(e);
			ResponseEntity<Messages> response = restTemplate.exchange(
					updateMessageUrl, 
					HttpMethod.PUT, 
					request, 
					Messages.class);
			
			//log.debug("Update message call " + response.getStatusCode().toString());
			System.out.println("Update message call " + response.getStatusCode().toString());
			
			return response.getBody();
		}
		
		/**
		 * Delete a message using exchange method of RestTemplate
		 * instead of delete method in order to log the response status code.
		 * @param e The message to delete
		 */
		public void deletemessage(int id) {
			String baseApiUrl = props.getApiUrl();
			String deletemessageUrl = baseApiUrl + "/messages/" + id;
			
			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<Void> response = restTemplate.exchange(
					deletemessageUrl, 
					HttpMethod.DELETE, 
					null, 
					Void.class);
			
			//log.debug("Delete message call " + response.getStatusCode().toString());
			System.out.println("Delete message call " + response.getStatusCode().toString());
		}

	}
