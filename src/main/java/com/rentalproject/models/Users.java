package com.rentalproject.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.Entity;
@Data
@Getter
@Setter
@Entity
@Table(name = "users")
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="email") private String email;
	@Column(name="name") private String name;
	@Column(name="password") private String password;
	@Column(name="created_at") private LocalDateTime createdAt;
	@Column(name="updated_at") private LocalDateTime updatedAt;
}
