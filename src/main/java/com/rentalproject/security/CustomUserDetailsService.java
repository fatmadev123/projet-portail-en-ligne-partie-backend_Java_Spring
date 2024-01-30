package com.rentalproject.security;

import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import com.rentalproject.models.Users;
import com.rentalproject.repository.UsersRepository;

@Service
@AllArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
    private UsersRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Users user = userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("User does not exist by Username or Email"));;
		if(user == null) {
			throw new UsernameNotFoundException("User not found", null);
		}
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), new ArrayList<>());
	}
}