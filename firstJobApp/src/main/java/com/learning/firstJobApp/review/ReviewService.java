package com.learning.firstJobApp.review;

import java.util.List;

public interface ReviewService {
	List<Review> getAllReviews(Long companyId);
	boolean addReview(Long companyId, Review review);
}
