package com.learning.firstJobApp.review.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.learning.firstJobApp.company.Company;
import com.learning.firstJobApp.company.CompanyRepository;
import com.learning.firstJobApp.company.CompanyService;
import com.learning.firstJobApp.review.Review;
import com.learning.firstJobApp.review.ReviewRepository;
import com.learning.firstJobApp.review.ReviewService;

@Service
public class ReviewServiceImpl implements ReviewService{
	
	private final ReviewRepository reviewRepository;
	private final CompanyService companyService;
	

	public ReviewServiceImpl(ReviewRepository reviewRepository, CompanyService companyService) {
		this.reviewRepository = reviewRepository;
		this.companyService= companyService;
	}



	@Override
	public List<Review> getAllReviews(Long companyId) {
		List<Review> reviews = reviewRepository.findByCompanyId(companyId);
		return reviews;
	}



	@Override
	public boolean addReview(Long companyId, Review review) {
		Company company = companyService.getCompanyById(companyId);
		if(company != null) {
			review.setCompany(company);
			reviewRepository.save(review);
			return true;
		}else {
			return false;
		}
		
	}

}
