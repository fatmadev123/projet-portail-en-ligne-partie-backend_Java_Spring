package com.rentalproject.services;

import java.util.Optional;

import com.rentalproject.models.User;

public interface UserService {
	Optional<User> getUserById(Long id);
}
