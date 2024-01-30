package com.rentalproject.services;

import com.rentalproject.dto.LoginRequest;
import com.rentalproject.dto.RegisterRequest;
import com.rentalproject.models.Users;
import com.rentalproject.repository.UsersRepository;
import com.rentalproject.security.JwtTokenProvider;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService {

	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private UsersRepository userRepository;
	@Autowired
	private JwtTokenProvider jwtTokenProvider;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	public String login(LoginRequest loginRequest) {

		if (!loginRequest.getEmail().contains("@") || loginRequest.getPassword().length() < 3) {
			throw new IllegalArgumentException("Invalid input");
		}

		if (userRepository.existsByEmail(loginRequest.getEmail()) == false) {
			throw new IllegalArgumentException("User email not found");
		}
		return authenticate(loginRequest);
	}

	@Override
	public String register(RegisterRequest registerRequest) {

		if (registerRequest.getName().length() < 3 || !registerRequest.getEmail().contains("@")
				|| registerRequest.getPassword().length() < 3) {
			throw new IllegalArgumentException("Invalid input");
		}

		if (userRepository.existsByEmail(registerRequest.getEmail()) == true) {
			throw new IllegalArgumentException("Email already exists");
		}

		Users user = modelMapper.map(registerRequest, Users.class);
		user.setPassword(bCryptPasswordEncoder().encode(user.getPassword()));
		user.setCreatedAt(LocalDateTime.now());
		user.setUpdatedAt(LocalDateTime.now());

		userRepository.save(user);

		LoginRequest loginRequest = new LoginRequest(registerRequest.getEmail(), registerRequest.getPassword());
		return authenticate(loginRequest);
	}

	@Override
	public Optional<Users> getMe() {
		String name = SecurityContextHolder.getContext().getAuthentication().getName();

		Optional<Users> user = userRepository.findByEmail(name);

		if (user.isPresent()) {
			return user;
		}
		return null;
	}

	private String authenticate(LoginRequest loginRequest) {
		Authentication authentication;
		try {
			authentication = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
		} catch (AuthenticationCredentialsNotFoundException ex) {
			throw new AuthenticationCredentialsNotFoundException("Authentication not permitted");
		}
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String token = jwtTokenProvider.generateToken(authentication);
		return token;
	}
}
