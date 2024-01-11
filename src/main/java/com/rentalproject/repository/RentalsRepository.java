package com.rentalproject.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rentalproject.models.Rentals;

@Repository
public interface RentalsRepository extends CrudRepository<Rentals, Long>  {

}