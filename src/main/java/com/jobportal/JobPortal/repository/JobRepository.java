package com.jobportal.JobPortal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jobportal.JobPortal.entity.Job;

public interface JobRepository extends JpaRepository<Job, Long>{
    
    public List<Job> findByPostedBy(Long PostedBy);
}
