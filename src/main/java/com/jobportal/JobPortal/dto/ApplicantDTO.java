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

    private String name;
    private String email;
    private Long phone;
    private String website;
    private String resume;
    private String coverLetter;

    private LocalDateTime timeStamp;

    private ApplicationStatus applicationStatus;

    public Applicant toEntity(){
        return new Applicant(applicantId, name, email, phone, website, resume!=null?Base64.getDecoder().decode(this.resume):null, coverLetter, timeStamp, applicationStatus);
    }
    
}
