package com.jobportal.JobPortal.entity;

import java.util.List;

import com.jobportal.JobPortal.dto.Certification;
import com.jobportal.JobPortal.dto.Experience;
import com.jobportal.JobPortal.dto.ProfileDto;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="profile")
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String jobTitle;

    private String company;

    private String location;

    private String about;

    @ElementCollection
    private List<String> skills;

    @ElementCollection
    private List<Experience> experience;

    @ElementCollection
    private List<Certification> certification;

    public ProfileDto tDto(){
        return new ProfileDto(id, email, jobTitle, company, location, about, skills, experience, certification);
    }
    
}
