package com.jobportal.JobPortal.entity;

import java.time.LocalDateTime;
import java.util.List;

import com.jobportal.JobPortal.dto.JobDTO;
import com.jobportal.JobPortal.dto.JobStatus;

import jakarta.persistence.CascadeType;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="jobs")
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String jobTitle;

    private String company;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "job_id")
    private List<Applicant> applicants;
    
    private String about;

    private String experience;

    private String jobType;

    private String location;

    private Long packageOffered;

    private LocalDateTime postTime;

    private String description;

    @ElementCollection
    private List<String>skillsRequired;

    @Enumerated(EnumType.STRING)
    private JobStatus jobStatus;

    private Long postedBy;

   public Job(String jobTitle,
           String company,
           List<Applicant> applicants,
           String about,
           String experience,
           String jobType,
           String location,
           Long packageOffered,
           LocalDateTime postTime,
           String description,
           List<String> skillsRequired,
           JobStatus jobStatus,
            Long postedBy) {

    this.jobTitle = jobTitle;
    this.company = company;
    this.applicants = applicants;
    this.about = about;
    this.experience = experience;
    this.jobType = jobType;
    this.location = location;
    this.packageOffered = packageOffered;
    this.postTime = postTime;
    this.description = description;
    this.skillsRequired = skillsRequired;
    this.jobStatus = jobStatus;
    this.postedBy=postedBy;
}

   

    public JobDTO toDTO(){
        return new JobDTO(id, jobTitle, company,  applicants!=null?this.applicants.stream().map((x)->x.toDTO()).toList():null, about, experience, jobType, location, packageOffered, postTime, description, skillsRequired, jobStatus,postedBy);
    }

    
}
