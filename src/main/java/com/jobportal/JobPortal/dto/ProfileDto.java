package com.jobportal.JobPortal.dto;

import java.util.Base64;
import java.util.List;

import com.jobportal.JobPortal.entity.Profile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfileDto {

     private Long id;

    private String name;

    private String email;

    private String jobTitle;

    private String company;

    private String location;

    private String about;

    private String image;

    private Long totalExp;

    private List<String> skills;

    private List<Experience> experience;

    private List<Certification> certification;

    private List<Long> savedJobs;

    public Profile toEntity(){
        return new Profile(id,name, email, jobTitle, company, location, about, image != null ? Base64.getDecoder().decode(this.image): null, totalExp,skills, experience, certification,savedJobs);
    }
    
}
 