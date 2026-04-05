package com.jobportal.JobPortal.service;


import com.jobportal.JobPortal.dto.LoginDto;
import com.jobportal.JobPortal.dto.ResponseDto;
import com.jobportal.JobPortal.dto.UserDto;
import com.jobportal.JobPortal.exception.JobPortalException;

import jakarta.validation.Valid;


public interface UserService {
    
    public UserDto registerUser(UserDto userDto);

    public UserDto loginUser(LoginDto loginDto)throws JobPortalException;

    public Boolean sendOtp(String email)throws Exception;

    public Boolean verifyOtp(String email,String otp) throws JobPortalException;

    public ResponseDto changePassword(LoginDto loginDto)throws JobPortalException;
}
