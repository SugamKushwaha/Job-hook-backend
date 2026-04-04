package com.jobportal.JobPortal.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="OTP ")
public class OTP {

    private String email;
    
    private String otpCode;

    private LocalDateTime creationTIme;
    
}
