package com.jobportal.JobPortal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jobportal.JobPortal.entity.Profile;

public interface ProfileRepository extends JpaRepository<Profile, Long>  {
    
}
