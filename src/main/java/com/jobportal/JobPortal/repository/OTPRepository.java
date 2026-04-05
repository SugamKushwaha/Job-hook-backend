package com.jobportal.JobPortal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jobportal.JobPortal.entity.OTP;
import java.time.LocalDateTime;


public interface OTPRepository  extends JpaRepository<OTP, String> {
    
       List<OTP> findByCreationTimeBefore(LocalDateTime expiry);
}
