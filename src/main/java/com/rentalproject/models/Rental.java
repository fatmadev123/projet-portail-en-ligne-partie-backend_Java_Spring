package com.rentalproject.models;

import lombok.Data;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Entity;
@Data
@Entity
@Table(name = "rentals")
public class Rental {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
	@Column(name="name")private String name;
	@Column(name="surface")private Float surface;
	@Column(name="price") private Float price;
	@Column(name="picture") private String picture;
	@Column(name="description")private String description;
	@JoinColumn(name="owner_id", nullable = false)
	@ManyToOne()
	private User user;
	@Column(name="created_at") private LocalDateTime createdAt;
	@Column(name="updated_at") private LocalDateTime updatedAt;
	
	public Rental() {
		super();
	}
	
	public Rental(Long id, String name, Float surface, Float price, String description) {
		super();
		this.id = id;
		this.name = name;
		this.surface = surface;
		this.price = price;
		this.description = description;
	}
}
