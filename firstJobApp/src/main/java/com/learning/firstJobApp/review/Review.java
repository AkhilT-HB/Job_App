package com.learning.firstJobApp.review;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.learning.firstJobApp.company.Company;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Review {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private String description;
	private double rating;
	
	@JsonIgnore
	@ManyToOne
	private Company company;
	
	public Review() {
	}



	public Review(Long id, String title, String description, double rating) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.rating = rating;
	}
	
	

}
