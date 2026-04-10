package com.jobportal.JobPortal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jobportal.JobPortal.entity.Job;

public interface JobRepository extends JpaRepository<Job, Long>{
    
}
