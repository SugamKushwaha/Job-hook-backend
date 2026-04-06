package com.jobportal.JobPortal.entity;

import com.jobportal.JobPortal.dto.AccountType;
import com.jobportal.JobPortal.dto.UserDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="User")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true) 
    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    private Long profileId;

    public UserDto toDto(){
        return new UserDto(id, name, email, password, accountType, profileId);
    }
}
