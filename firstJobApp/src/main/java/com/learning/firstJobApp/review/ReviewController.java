package com.learning.firstJobApp.review;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/companies/{companyId}")
public class ReviewController {
	
	private ReviewService reviewService;

	public ReviewController(ReviewService reviewService) {
		this.reviewService = reviewService;
	}
	
	@GetMapping("/reviews")
	public ResponseEntity<List<Review>> getAllReviews(@PathVariable Long companyId){
		return new ResponseEntity<>(reviewService.getAllReviews(companyId),HttpStatus.OK);
	}
	
	@PostMapping("/reviews")
	public ResponseEntity<String> addReview(@PathVariable Long companyId ,@RequestBody Review review){
		if(reviewService.addReview(companyId, review)) {
			return new ResponseEntity<>("Review added Successfully", HttpStatus.OK);
		}else {
			return new ResponseEntity<>("Review not saved", HttpStatus.NOT_FOUND);
		}
	}
	
}
