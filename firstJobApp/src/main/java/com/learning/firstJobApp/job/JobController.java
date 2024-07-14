package com.learning.firstJobApp.job;

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
@RequestMapping("/jobs")
public class JobController {
	private JobService jobService;

	public JobController(JobService jobService) {
		super();
		this.jobService = jobService;
	}

	@GetMapping
	public ResponseEntity<List<JobClass>> findAllJobs() {
		return ResponseEntity.ok(jobService.findAllJobs());
	}

	@PostMapping
	public ResponseEntity<String> createJob(@RequestBody JobClass job) {
		jobService.createJob(job);
		return new ResponseEntity<>("Job created successfully",HttpStatus.OK);
	}

	
	@GetMapping("{id}")
	public ResponseEntity<JobClass> getJobByID(@PathVariable Long id) {
		JobClass job = jobService.getJobById(id);

		if (job != null) {
			return new ResponseEntity<>(job,HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);

	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteJob(@PathVariable Long id){
		boolean deleted = jobService.deleteJobById(id);
		
		if(deleted) {
			return new ResponseEntity<>("Job deleted successfully",HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	
	@PutMapping("{id}")
	public ResponseEntity<String> updateJob(@PathVariable Long id,@RequestBody JobClass updatedJob){
		boolean updated = jobService.updateJobById(id,updatedJob);
		
		if(updated) {
			return new ResponseEntity<>("Job updated successfully",HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		 
	}
	

}
