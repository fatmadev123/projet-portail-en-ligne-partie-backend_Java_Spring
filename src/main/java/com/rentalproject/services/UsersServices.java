package com.rentalproject.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rentalproject.models.Users;
import com.rentalproject.repository.UsersRepository;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Service
public class UsersServices  {
    @Autowired
    private UsersRepository userRepository;

    public Optional<Users> getUser(final Long id) {
        return userRepository.findById(id);
    }

    public Iterable<Users> getUsers() {
        return userRepository.findAll();
    }

    public void deleteUser(final Long id) {
    	userRepository.deleteById(id);
    }

    public Users saveUser(Users user) {
    	Users savedUser = userRepository.save(user);
        return savedUser;
    }

}