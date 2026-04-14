package com.jobportal.JobPortal.dto;

import java.time.LocalDateTime;
import java.util.Base64;

import com.jobportal.JobPortal.entity.Applicant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApplicantDTO {

    private Long applicantId;
    private Long userId;

    private String name;
    private String email;
    private Long phone;
    private String website;
    private String resume;
    private String coverLetter;

    private LocalDateTime timeStamp;

    private ApplicationStatus applicationStatus;

    private LocalDateTime interviewTime;

    public Applicant toEntity(){
    Applicant applicant = new Applicant();

    applicant.setUserId(userId);
    applicant.setName(name);
    applicant.setEmail(email);
    applicant.setPhone(phone);
    applicant.setWebsite(website);
    applicant.setResume(resume != null ? Base64.getDecoder().decode(this.resume) : null);
    applicant.setCoverLetter(coverLetter);
    applicant.setApplicationStatus(applicationStatus);
    applicant.setInterviewTime(interviewTime);

    // ❌ DO NOT SET ID

    return applicant;
}
    
}

