package com.jobportal.JobPortal.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jobportal.JobPortal.dto.ProfileDto;
import com.jobportal.JobPortal.dto.ResponseDto;
import com.jobportal.JobPortal.exception.JobPortalException;
import com.jobportal.JobPortal.service.ProfileService;

import jakarta.validation.constraints.Email;

@RestController
@CrossOrigin
@Validated
@RequestMapping("/profiles")
public class ProfileApi {
    
    @Autowired
    private ProfileService profileService;

      @GetMapping("/get/{id}")
     public ResponseEntity<ProfileDto> getProfile(@PathVariable Long id) throws JobPortalException {
          
        return new ResponseEntity<>(profileService.getProfile(id),HttpStatus.OK);
    }

    @GetMapping("/getAll")
     public ResponseEntity<List<ProfileDto>> getAllProfile() throws JobPortalException {
          
        return new ResponseEntity<>(profileService.getAllProfile(),HttpStatus.OK);
    }

    @PutMapping("/update")
     public ResponseEntity<ProfileDto> updateProfile(@RequestBody ProfileDto profileDto) throws JobPortalException {
          
        return new ResponseEntity<>(profileService.updateProfile(profileDto),HttpStatus.OK);
    }
}
