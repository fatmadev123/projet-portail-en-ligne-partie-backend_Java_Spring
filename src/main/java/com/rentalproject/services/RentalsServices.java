package com.rentalproject.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rentalproject.models.Rentals;
import com.rentalproject.repository.RentalsRepository;

import lombok.Data;

@Data
@Service
public class RentalsServices  {
    @Autowired
    private RentalsRepository rentalRepository;

    public Optional<Rentals> getRental(final Long id) {
        return rentalRepository.findById(id);
    }

    public Iterable<Rentals> getRentals() {
        return rentalRepository.findAll();
    }

    public void deleteRental(final Long id) {
    	rentalRepository.deleteById(id);
    }
    
    public void updateRental(final Long id, Rentals Rentals) {
    	Optional<Rentals> rent = rentalRepository.findById(id);
    	  if (rent.isPresent()) {
              Rentals rt = rent.get();
              rt.setName(Rentals.getName());
              rt.setSurface(Rentals.getSurface());
              rt.setPicture(Rentals.getPicture());
              rt.setPrice(Rentals.getPrice());
             
              rentalRepository.save(rt);
          }
    }
    
    

    public Rentals saveRental(Rentals rental) {
        Rentals savedRental = rentalRepository.save(rental);
        return savedRental;
    }

}
