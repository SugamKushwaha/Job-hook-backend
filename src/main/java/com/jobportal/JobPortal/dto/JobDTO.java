package com.jobportal.JobPortal.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.jobportal.JobPortal.entity.Job;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobDTO {
    private Long id;
    private String jobTitle;
    private String company;
    private List<ApplicantDTO> applicants;
    private String about;
    private String experience;
    private String jobType;
    private String location;
    private Long packageOffered;
    private LocalDateTime postTime;
    private String description;
    private List<String>skillsRequired;
    private JobStatus jobStatus;

    private Long postedBy;

    public Job toEntity(){
        return  new Job(id,jobTitle, company, applicants!=null?this.applicants.stream().map((x)->x.toEntity()).toList():null, about, experience, jobType, location, packageOffered, postTime, description, skillsRequired, jobStatus,postedBy);
    }

 
}
