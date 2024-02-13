package com.rentalproject.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rentalproject.models.User;
import com.rentalproject.repository.UsersRepository;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UsersRepository userRepository;
//retourner un utilisateur par son Id
    @Override
    public Optional<User> getUserById(Long id) {
        if (Double.isNaN(id) || id < 0) {
            throw new IllegalArgumentException("Invalid value for id");
        }
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return user;
        }
        return null;
    }
}
