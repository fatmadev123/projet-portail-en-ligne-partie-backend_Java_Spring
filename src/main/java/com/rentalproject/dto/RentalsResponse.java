package com.rentalproject.dto;

import java.util.List;

import lombok.Data;

@Data
public class RentalsResponse {
	List<RentalDto> rentals;
}

