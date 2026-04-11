package com.jobportal.JobPortal.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Application {
    private Long id;
    private Long applicationId;
    private LocalDateTime interviewTime;
    private ApplicationStatus applicationStatus;
}
