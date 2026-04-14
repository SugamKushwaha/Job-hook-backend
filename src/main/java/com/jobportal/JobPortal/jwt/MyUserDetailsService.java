package com.jobportal.JobPortal.jwt;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jobportal.JobPortal.dto.UserDto;
import com.jobportal.JobPortal.exception.JobPortalException;
import com.jobportal.JobPortal.service.UserService;

@Service
public class MyUserDetailsService implements  UserDetailsService{

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
      try {
         UserDto dto = userService.getUserByEmail(email);
         return new CustomUserDetails(dto.getId(),email,dto.getPassword(),dto.getAccountType(), new ArrayList<>());
          
      } catch (JobPortalException e) {
        e.printStackTrace();
      }
      return null;

    }
    
}
