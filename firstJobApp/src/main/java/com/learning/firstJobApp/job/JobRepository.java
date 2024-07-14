package com.learning.firstJobApp.job;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<JobClass, Long>{
	

}
