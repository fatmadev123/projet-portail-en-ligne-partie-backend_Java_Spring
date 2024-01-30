package com.rentalproject.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import com.rentalproject.models.Rentals;
import com.rentalproject.repository.RentalsRepository;

@Service
public class RentalsServiceImpl implements RentalsService {

    @Autowired
    private RentalsRepository rentalRepository;

    @Override
    public List<Rentals> getRentals() {
        return (List<Rentals>) rentalRepository.findAll();
    }

    @Override
    public Optional<Rentals> getRentalById(Long id) {

        if (Double.isNaN(id) || id < 0) {
            throw new IllegalArgumentException("Invalid value for id");
        }

        Optional<Rentals> rental = rentalRepository.findById(id);

        if (rental.isPresent()) {
            return rental;
        }

        return null;
    }

    @Override
    public void createRental(Rentals createdRental) {
        createdRental.setCreatedAt(LocalDateTime.now());
        rentalRepository.save(createdRental);
    }

    @Override
    public void updateRental(Long id, Rentals updatedRental) {

        if (updatedRental.getName().isBlank() || updatedRental.getSurface().isNaN() || updatedRental.getPrice().isNaN() || updatedRental.getDescription().isBlank()) {
            throw new IllegalArgumentException("Invalid input for update!");
        }

        Rentals rentalToUpdate = rentalRepository.findById(id).orElse(null);

        if (rentalToUpdate == null) {
            throw new NotFoundException("Rental not found!");
        }

        if (!Objects.equals(rentalToUpdate.getName(), updatedRental.getName())) {
            rentalToUpdate.setName(updatedRental.getName());
        }
        if (!Objects.equals(rentalToUpdate.getSurface(), updatedRental.getSurface())) {
            rentalToUpdate.setSurface(updatedRental.getSurface());
        }
        if (!Objects.equals(rentalToUpdate.getPrice(), updatedRental.getPrice())) {
            rentalToUpdate.setPrice(updatedRental.getPrice());
        }
        if (!Objects.equals(rentalToUpdate.getDescription(), updatedRental.getDescription())) {
            rentalToUpdate.setDescription(updatedRental.getDescription());
        }

        rentalToUpdate.setUpdatedAt(LocalDateTime.now());

        rentalRepository.save(rentalToUpdate);
    }
}
