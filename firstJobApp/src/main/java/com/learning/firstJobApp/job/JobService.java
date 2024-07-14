package com.learning.firstJobApp.job;

import java.util.List;

public interface JobService {
	
	List<JobClass> findAllJobs();
	
	void createJob(JobClass job);

	JobClass getJobById(Long id);

	boolean deleteJobById(Long id);

	boolean updateJobById(Long id, JobClass updatedJob);

}
