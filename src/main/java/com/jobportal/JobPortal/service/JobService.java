package com.jobportal.JobPortal.service;

import java.util.List;

import com.jobportal.JobPortal.dto.ApplicantDTO;
import com.jobportal.JobPortal.dto.Application;
import com.jobportal.JobPortal.dto.JobDTO;
import com.jobportal.JobPortal.exception.JobPortalException;


public interface JobService {

    public JobDTO postJob(JobDTO jobDTO);

    public List<JobDTO> getAllJobs();

    public JobDTO getjob(Long id)throws JobPortalException;

    public void applyJob(long id, ApplicantDTO applicantDTO) throws  JobPortalException;

    public List<JobDTO> getJobsPostedBy(Long id);

    public void changeAppStatus(Application application)throws  JobPortalException;

    
}
