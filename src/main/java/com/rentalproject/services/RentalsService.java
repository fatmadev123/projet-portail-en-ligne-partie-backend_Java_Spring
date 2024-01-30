package com.rentalproject.services;

import java.util.List;
import java.util.Optional;

import com.rentalproject.models.Rentals;

public interface RentalsService {
	List<Rentals> getRentals();
	Optional<Rentals> getRentalById(Long id);
	void createRental(Rentals createdRental);
	void updateRental(Long id, Rentals updatedRental);
}
