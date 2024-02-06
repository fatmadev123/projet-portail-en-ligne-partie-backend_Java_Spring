package com.rentalproject.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rentalproject.models.User;

@Repository
public interface UsersRepository  extends CrudRepository<User, Long> {
	 Optional<User> findByEmail(String email);
	 Boolean existsByEmail(String email);
}
