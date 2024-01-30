package com.rentalproject.services;

import java.util.Optional;

import com.rentalproject.models.Users;

public interface UserService {
	Optional<Users> getUserById(Long id);
}
