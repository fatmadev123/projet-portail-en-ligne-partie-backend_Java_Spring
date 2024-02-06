package com.rentalproject.models;

import lombok.Data;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Entity;

@Data
@Entity
@Table(name="messages")
public class Message {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="message")private String message;
	@Column(name="created_at")private LocalDateTime  createdAt;
	@Column(name="updated_at")private LocalDateTime  updatedAt;
	@ManyToOne
    @JoinColumn(name = "rental_id", nullable = false)
    private Rental rental;
	@ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

}


