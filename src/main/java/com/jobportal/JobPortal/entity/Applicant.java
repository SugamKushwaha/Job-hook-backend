package com.jobportal.JobPortal.entity;

import java.time.LocalDateTime;
import java.util.Base64;

import org.hibernate.annotations.CreationTimestamp;

import com.jobportal.JobPortal.dto.ApplicantDTO;
import com.jobportal.JobPortal.dto.ApplicationStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Applicant {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long applicantId;

    private String name;
    private String email;
    private Long phone;
    private String website;

    @Lob
    private byte[] resume;
    private String coverLetter;

    @CreationTimestamp
    private LocalDateTime timeStamp;

    @Enumerated(EnumType.STRING)
    private ApplicationStatus applicationStatus;
    private LocalDateTime interviewTime;

    public ApplicantDTO toDTO(){
      return new ApplicantDTO(applicantId, name, email, phone, website, resume!=null?Base64.getEncoder().encodeToString(this.resume):null, coverLetter, timeStamp, applicationStatus,interviewTime);
    }
}
