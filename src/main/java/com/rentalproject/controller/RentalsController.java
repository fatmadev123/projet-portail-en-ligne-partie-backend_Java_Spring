package com.rentalproject.controller;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.rentalproject.models.Rentals;
import com.rentalproject.repository.RentalsRepository;
import com.rentalproject.services.RentalsServices;

import jakarta.transaction.Transactional;

@RestController
public class RentalsController {
	 @Autowired
	 private RentalsRepository rentalRepository;
	@Autowired
    private RentalsServices rentalService;
	
	    @GetMapping("/rentals")
	    public Iterable<Rentals> getRentals() {
	        return rentalService.getRentals();
	    }
	    
	    @PutMapping("/rentals/{id}")
	    public Rentals replacerental(@RequestBody Rentals newRental, @PathVariable Long id) {
	      
	      return rentalRepository.findById(id)
	        .map(rental -> {
	          rental.setName(newRental.getName());
	          rental.setSurface(newRental.getSurface());
	          rental.setPicture(newRental.getPicture());
	 		   rental.setPrice(newRental.getPrice());
	          return rentalRepository.save(rental);
	        })
	        .orElseGet(() -> {
	          newRental.setId(id);
	          return rentalRepository.save(newRental);
	        });
	    }
	    
	    @GetMapping("/rentals/{id}")
		   public ResponseEntity<Rentals> getRental(@PathVariable Long id){
	    	Optional<Rentals> rental = rentalService.getRental(id);
	    	 return rental.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
		    }
	    
	    @PostMapping(value = "/rentals")
		@Transactional
		public ResponseEntity<Rentals> saveRental(@RequestBody Rentals rental) {
			Rentals rentalSaved = rentalService.saveRental(rental);		
	 		return new ResponseEntity<Rentals>(rentalSaved, HttpStatus.CREATED);
	 	}
}
