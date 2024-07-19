package com.learning.firstJobApp.review;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@GetMapping("/reviews/{reviewId}")
	public ResponseEntity<Review> getReview(@PathVariable Long companyId, @PathVariable Long reviewId){
		System.out.println("inside controller "+companyId+" "+reviewId);
		Review review = reviewService.getReview(companyId, reviewId);
		
			return new ResponseEntity<>(review,HttpStatus.OK);
	
	}
	
	
	@PutMapping("/reviews/{reviewId}")
	public ResponseEntity<String> updateReview(@PathVariable Long companyId, @PathVariable Long reviewId, 
												@RequestBody Review updatedReview){
		boolean isReviewUpdated = reviewService.updateReview(companyId, reviewId, updatedReview);
		if(isReviewUpdated) {
		return new ResponseEntity<>("Review Updated Successfully",HttpStatus.OK);
		}
		return new ResponseEntity<>("Review not found",HttpStatus.NOT_FOUND);
	}
	
	
	@DeleteMapping("/reviews/{reviewId}")
	public ResponseEntity<String> deleteReview(@PathVariable Long companyId, @PathVariable Long reviewId){
		boolean isReviewDeleted = reviewService.deleteReview(companyId,reviewId);
		if(isReviewDeleted) {
			return new ResponseEntity<>("Review deleted Successfully",HttpStatus.OK);
			}
			return new ResponseEntity<>("Review not deleted",HttpStatus.NOT_FOUND);
	}
	
	
	
}
