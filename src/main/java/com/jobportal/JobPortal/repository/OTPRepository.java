package com.jobportal.JobPortal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jobportal.JobPortal.entity.OTP;

public interface OTPRepository  extends JpaRepository<OTP, String> {
    
}
