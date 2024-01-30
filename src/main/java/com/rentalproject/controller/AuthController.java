package com.rentalproject.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.AllArgsConstructor;
import com.rentalproject.dto.AuthSuccess;
import com.rentalproject.dto.LoginRequest;
import com.rentalproject.dto.RegisterRequest;
import com.rentalproject.dto.UserDto;
import com.rentalproject.models.Users;
import com.rentalproject.services.AuthService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/auth")
public class AuthController {

	@Autowired
	private AuthService authService;

	@Autowired
	private ModelMapper modelMapper;

	@PostMapping("/login")
	@Operation(summary = "Logs a user")
	@ApiResponse(responseCode = "200", description = "User is logged")
	@ApiResponse(responseCode = "400", description = "Invalid input or email not found")
	@ApiResponse(responseCode = "503", description = "Service unavailable")
	public ResponseEntity<AuthSuccess> login(@RequestBody LoginRequest loginRequest) {
		String token;

		try {
			token = authService.login(loginRequest);
		}

		catch (IllegalArgumentException ex) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		catch (AuthenticationCredentialsNotFoundException ex) {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}

		catch (Exception ex) {
			return new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);
		}

		AuthSuccess authSuccess = new AuthSuccess();
		authSuccess.setToken(token);

		return ResponseEntity.status(HttpStatus.OK).body(authSuccess);
	}

	@Operation(summary = "Registers a new user")
	@ApiResponse(responseCode = "200", description = "User is created and logged")
	@ApiResponse(responseCode = "400", description = "Invalid input or already existing email")
	@ApiResponse(responseCode = "503", description = "Service unavailable")
	@PostMapping("/register")
	public ResponseEntity<AuthSuccess> register(@RequestBody RegisterRequest registerRequest) {
		String token;

		try {
			token = authService.register(registerRequest);
		}

		catch (IllegalArgumentException ex) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		catch (AuthenticationCredentialsNotFoundException ex) {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}

		catch (Exception ex) {
			return new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);
		}

		AuthSuccess authSuccess = new AuthSuccess();
		authSuccess.setToken(token);

		return ResponseEntity.status(HttpStatus.OK).body(authSuccess);
	}

	@Operation(security = { @SecurityRequirement(name = "bearer-key") }, summary = "Gets the connected user")
	@ApiResponse(responseCode = "200", description = "User is found")
	@ApiResponse(responseCode = "404", description = "User not found")
	@ApiResponse(responseCode = "503", description = "Service unavailable")
	@GetMapping("/me")
	public ResponseEntity<UserDto> getMe() {
		Optional<Users> user;

		try {
			user = authService.getMe();
		} 
		
		catch (Exception ex) {
			return new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);
		}
		
		if (user.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		UserDto userDTO = modelMapper.map(user, UserDto.class);
		return ResponseEntity.status(HttpStatus.OK).body(userDTO);
	}
}
