package com.rentalproject.models;

import lombok.Data;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;

@Data
@Entity
@Table(name="messages")
public class Messages {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="rental_id") private Long rentalId;
	@Column(name="user_id") private Long userId;
	@Column(name="message")private String message;
	@Column(name="created_at")private LocalDateTime  createdAt;
	@Column(name="updated_at")private LocalDateTime  updatedAt;
}


