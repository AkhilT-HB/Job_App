package com.learning.firstJobApp.job.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.learning.firstJobApp.job.JobClass;
import com.learning.firstJobApp.job.JobRepository;
import com.learning.firstJobApp.job.JobService;

@Service
public class JobServiceImpl implements JobService {

	// private List<JobClass> jobs = new ArrayList<>();

	JobRepository jobRepository;

	public JobServiceImpl(JobRepository jobRepository) {
		this.jobRepository = jobRepository;
	}

	@Override
	public List<JobClass> findAllJobs() {
		return jobRepository.findAll();
	}

	@Override
	public void createJob(JobClass job) {
		jobRepository.save(job);
	}

	@Override
	public JobClass getJobById(Long id) {
		return jobRepository.findById(id).orElse(null);
	}

	@Override
	public boolean deleteJobById(Long id) {
		try {
			jobRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean updateJobById(Long id, JobClass updatedJob) {

		Optional<JobClass> jobOptional = jobRepository.findById(id);

		if (jobOptional.isPresent()) {
			JobClass job = jobOptional.get();
			job.setTitle(updatedJob.getTitle());
			job.setDescription(updatedJob.getDescription());
			job.setMinSalary(updatedJob.getMinSalary());
			job.setMaxSalary(updatedJob.getMaxSalary());
			job.setLocation(updatedJob.getLocation());
			jobRepository.save(job);
			return true;
		}
		return false;
	}

}
