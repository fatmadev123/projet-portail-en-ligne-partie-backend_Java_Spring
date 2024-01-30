package com.rentalproject.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rentalproject.models.Users;

@Repository
public interface UsersRepository  extends CrudRepository<Users, Long> {
	 Optional<Users> findByEmail(String email);
	 Boolean existsByEmail(String email);
}
