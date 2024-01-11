package com.rentalproject.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rentalproject.models.Rentals;
import com.rentalproject.services.RentalsServices;

@CrossOrigin(origins = "http://localhost:4200")
//@RequestMapping("/api")
@RestController
public class RentalsController {
	@Autowired
    private RentalsServices rentalService;
	
	 
	    @GetMapping("/api/rentals")
	    public Iterable<Rentals> getRentals() {
	        return rentalService.getRentals();
	    }
	    
	    @PutMapping("/api/rentals/{id}")
	    public void updateRental(@PathVariable Long id, Rentals Rentals)
	    {
	    	rentalService.updateRental(id, Rentals);
	    }
	    
	    @GetMapping("/api/rentals/{id}")
		   public ResponseEntity<Rentals> getRental(@PathVariable Long id){
	    	Optional<Rentals> rental = rentalService.getRental(id);
	    	 return rental.map(ResponseEntity::ok)
	                   .orElseGet(() -> ResponseEntity.notFound()
                                       .build());
		    }
	    
	    @PostMapping("/api/rentals")
	    public Rentals saveRental(Rentals rental) { 
	    	return rentalService.saveRental(rental);
	    }
	    
	    
		/*
		 * @GetMapping("/api/rentals/:id") 
		 * public Optional<Rentals> getRental(final Long id)
		 * { return rentalService.getRental(id); }
		 */
	    
	  
	    
}