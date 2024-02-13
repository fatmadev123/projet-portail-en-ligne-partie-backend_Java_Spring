package com.rentalproject.dto;

import java.time.LocalDateTime;

import com.rentalproject.models.User;

import lombok.Data;

@Data
public class RentalDto {
	private Long id;
	private String name;
	private Float surface;
	private Float price;
	private String picture;
	private String description;
	private User user;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
}

