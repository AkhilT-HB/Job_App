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



	@Override
	public Review getReview(Long companyId, Long reviewId) {
		List<Review> reviews = reviewRepository.findByCompanyId(companyId);
		System.out.println("inside service after findbycompanyid");
		
		return reviews.stream().filter(review -> review.getId().equals(reviewId))
				.findFirst().orElse(null);
	}



	@Override
	public boolean updateReview(Long companyId, Long reviewId, Review updatedReview) {
		if(companyService.getCompanyById(companyId)!=null) {
			updatedReview.setCompany(companyService.getCompanyById(companyId));
			updatedReview.setId(reviewId);
			reviewRepository.save(updatedReview);
			return true;
		}
		return false;
	}



	@Override
	public boolean deleteReview(Long companyId, Long reviewId) {
		if(companyService.getCompanyById(companyId)!=null && reviewRepository.existsById(reviewId)) {
			Review review = reviewRepository.findById(reviewId).orElse(null);
			Company company = review.getCompany();
			
			company.getReviews().remove(review);
			
			companyService.updateCompany(companyId, company);
			
			review.setCompany(null);
			reviewRepository.deleteById(reviewId);
			
			return true;
		}else {
			return false;			
		}

	}

}
