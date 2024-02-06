package com.rentalproject.services;

import java.util.Optional;

import com.rentalproject.dto.LoginRequest;
import com.rentalproject.dto.RegisterRequest;
import com.rentalproject.models.User;

public interface AuthService {
    String login(LoginRequest loginRequest);
    String register(RegisterRequest registerRequest);
    Optional<User> getMe();
}