package com.jobportal.JobPortal.service;


import com.jobportal.JobPortal.dto.LoginDto;
import com.jobportal.JobPortal.dto.UserDto;
import com.jobportal.JobPortal.exception.JobPortalException;


public interface UserService {
    
    public UserDto registerUser(UserDto userDto);

    public UserDto loginUser(LoginDto loginDto)throws JobPortalException;

    public Boolean sendOtp(String email)throws Exception;
}
