package com.learning.firstJobApp.company;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.learning.firstJobApp.job.JobClass;
import com.learning.firstJobApp.review.Review;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Company {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private String description;
	
	@JsonIgnore
	@OneToMany(mappedBy = "company")
	private List<JobClass> jobs;
	
	@OneToMany(mappedBy="company")
	private List<Review> reviews;

	public Company() {
	}
	
	

	public List<Review> getReviews() {
		return reviews;
	}



	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<JobClass> getJobs() {
		return jobs;
	}

	public void setJobs(List<JobClass> jobs) {
		this.jobs = jobs;
	}
	
	

}
