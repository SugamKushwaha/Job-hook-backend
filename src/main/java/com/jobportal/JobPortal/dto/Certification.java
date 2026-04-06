package com.jobportal.JobPortal.dto;

import java.time.LocalDateTime;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Certification {

    private String name;

    private String issuer;

    private LocalDateTime issueDate;

    private String certificationId;
    
}
