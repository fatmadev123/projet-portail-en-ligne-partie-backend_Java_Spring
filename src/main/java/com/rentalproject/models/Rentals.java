package com.rentalproject.models;

import lombok.Data;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.Entity;
@Data
@Entity
@Table(name = "rentals")
public class Rentals {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
	@Column(name="name")private String name;
	@Column(name="surface")private Float surface;
	@Column(name="price") private Float price;
	@Column(name="picture") private String picture;
	@Column(name="description")private String description;
	@Column(name="owener_id") private Long owenerId;
	@Column(name="created_at") private LocalDateTime createdAt;
	@Column(name="updated_at") private LocalDateTime updatedAt;
	
	public Rentals() {
		super();
	}
	
	public Rentals(Long id, String name, Float surface, Float price, String description) {
		super();
		this.id = id;
		this.name = name;
		this.surface = surface;
		this.price = price;
		this.description = description;
	}
}
