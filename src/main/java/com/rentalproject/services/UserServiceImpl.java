package com.rentalproject.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rentalproject.models.Users;
import com.rentalproject.repository.UsersRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UsersRepository userRepository;

    @Override
    public Optional<Users> getUserById(Long id) {

        if (Double.isNaN(id) || id < 0) {
            throw new IllegalArgumentException("Invalid value for id");
        }

        Optional<Users> user = userRepository.findById(id);

        if (user.isPresent()) {
            return user;
        }

        return null;
    }
}
