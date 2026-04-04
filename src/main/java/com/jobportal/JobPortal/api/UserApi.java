package com.jobportal.JobPortal.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jobportal.JobPortal.dto.LoginDto;
import com.jobportal.JobPortal.dto.ResponseDto;
import com.jobportal.JobPortal.dto.UserDto;
import com.jobportal.JobPortal.exception.JobPortalException;
import com.jobportal.JobPortal.service.UserService;

import jakarta.validation.Valid;

@RestController
@Validated
@CrossOrigin(origins = "*")
@RequestMapping("/users")
public class UserApi {
    
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserDto> registerUser( @RequestBody @Valid UserDto userDto)throws JobPortalException{
         userDto = userService.registerUser(userDto);
         return new ResponseEntity<>(userDto,HttpStatus.CREATED);
    }

      @PostMapping("/login")
    public ResponseEntity<UserDto> loginUser( @RequestBody @Valid LoginDto loginDto)throws JobPortalException{
         return new ResponseEntity<>(userService.loginUser(loginDto),HttpStatus.OK);
    }

    @PostMapping("/sendOtp/{email}")
     public ResponseEntity<ResponseDto> sendOtp(@PathVariable String email)throws Exception{
          userService.sendOtp(email);
         return new ResponseEntity<>(new ResponseDto("OTP sent successfully"),HttpStatus.OK);
    }

}
