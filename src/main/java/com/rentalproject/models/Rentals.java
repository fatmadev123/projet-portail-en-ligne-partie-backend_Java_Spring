package com.rentalproject.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.Table;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.Entity;
@Data
@Getter
@Setter
@Entity
@Table(name = "rentals")
public class Rentals {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
	
	@Column(name="name")private String name;
	
	@Column(name="surface")private Long surface;
	
	@Column(name="price") private Long price;
	
	@Column(name="picture") private String picture;
	
	@Column(name="owener_id") private Long owenerId;
	  
	@Column(name="created_at") private Date createdAt;
	  
	@Column(name="updated_at") private Date updatedAt;
}
