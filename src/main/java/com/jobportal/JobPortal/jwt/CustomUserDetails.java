package com.jobportal.JobPortal.jwt;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.jobportal.JobPortal.dto.AccountType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomUserDetails implements UserDetails{

   private Long id;

   private String userName;

   private String password;

   private AccountType accountType;

   private Collection<?extends GrantedAuthority> authorities;

    @Override
    public String getUsername() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
   
}
