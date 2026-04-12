package com.jobportal.JobPortal.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobportal.JobPortal.dto.ProfileDto;
import com.jobportal.JobPortal.entity.Profile;
import com.jobportal.JobPortal.exception.JobPortalException;
import com.jobportal.JobPortal.repository.ProfileRepository;

@Service
public class ProfileServiceImpl implements ProfileService{

    @Autowired
    private ProfileRepository profileRepository;

    @Override
    public Long createProfile(String email) throws  JobPortalException {
       Profile profile = new Profile();
       profile.setEmail(email);
       profile.setSkills(new ArrayList<>());
       profile.setExperience(new ArrayList<>());
       profile.setCertification(new ArrayList<>());

       profileRepository.save(profile);

       return profile.getId();
    }

    @Override
    public ProfileDto getProfile(Long id) throws JobPortalException {
        return profileRepository.findById(id).orElseThrow(()-> new JobPortalException("PROFILE_NOT_FOUND")).tDto();
    }

    @Override
    public ProfileDto updateProfile(ProfileDto profileDto) throws JobPortalException {
         profileRepository.findById(profileDto.getId()).orElseThrow(()-> new JobPortalException("PROFILE_NOT_FOUND")).tDto();
        profileRepository.save(profileDto.toEntity());
        return profileDto;

    }

    @Override
    public List<ProfileDto> getAllProfile() {
       return profileRepository.findAll().stream().map((x)->x.tDto()).toList();
    }
    
}
