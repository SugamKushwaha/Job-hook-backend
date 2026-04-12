package com.jobportal.JobPortal.service;

import java.util.List;

import com.jobportal.JobPortal.dto.ProfileDto;
import com.jobportal.JobPortal.exception.JobPortalException;

public interface ProfileService {
    
    public Long createProfile(String email)throws JobPortalException;

    public ProfileDto getProfile(Long id) throws JobPortalException;

    public ProfileDto updateProfile(ProfileDto profileDto) throws JobPortalException;

    public List<ProfileDto> getAllProfile();
}
