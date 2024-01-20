package com.rentalproject.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.Table;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;

import jakarta.persistence.Entity;

@Data
@Getter
@Setter
@Entity
@Table(name="messages")
public class Messages {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="rental_id") private Long rentalId;
	
	@Column(name="user_id") private Long userId;
	
	@Column(name="message")private String message;
	
	@Column(name="created_at")private Date createdAt;
	
	@Column(name="updated_at")private Date updatedAt;
}
