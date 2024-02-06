package com.rentalproject.services;

import java.util.List;
import java.util.Optional;

import com.rentalproject.models.Rental;

public interface RentalsService {
	List<Rental> getRentals();
	Optional<Rental> getRentalById(Long id);
	void createRental(Rental createdRental);
	void updateRental(Long id, Rental updatedRental);
}
