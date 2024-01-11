package com.rentalproject.models;

import lombok.Data;
import jakarta.persistence.Table;

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
	
	@Column(name="surface")private Long surface;
	
	@Column(name="price") private Long price;
	
	@Column(name="picture") private String picture;
	
	@Column(name="owener_id") private Long owenerId;
	  
	@Column(name="created_at") private Long createdAt;
	  
	@Column(name="updated_at") private Long updatedAt;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getSurface() {
		return surface;
	}

	public void setSurface(Long surface) {
		this.surface = surface;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public Long getOwenerId() {
		return owenerId;
	}

	public void setOwenerId(Long owenerId) {
		this.owenerId = owenerId;
	}

	public Long getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Long createdAt) {
		this.createdAt = createdAt;
	}

	public Long getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Long updatedAt) {
		this.updatedAt = updatedAt;
	}
	 

}
