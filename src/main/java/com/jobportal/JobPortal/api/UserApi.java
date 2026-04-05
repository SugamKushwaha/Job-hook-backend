package com.jobportal.JobPortal.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jobportal.JobPortal.dto.LoginDto;
import com.jobportal.JobPortal.dto.ResponseDto;
import com.jobportal.JobPortal.dto.UserDto;
import com.jobportal.JobPortal.exception.JobPortalException;
import com.jobportal.JobPortal.service.UserService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;

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

    @PostMapping("/changePass")
    public ResponseEntity<ResponseDto> changePassword( @RequestBody @Valid LoginDto loginDto)throws JobPortalException{
         return new ResponseEntity<>(userService.changePassword(loginDto),HttpStatus.OK);
    }

    @PostMapping("/sendOtp/{email}")
     public ResponseEntity<ResponseDto> sendOtp(@PathVariable @Email(message ="{user.email.invalid}") String email)throws Exception{
          userService.sendOtp(email);
         return new ResponseEntity<>(new ResponseDto("OTP sent successfully"),HttpStatus.OK);
    }

     @GetMapping("/verifyOtp/{email}/{otp}")
     public ResponseEntity<ResponseDto> verifyOtp(@PathVariable @Email(message = "{user.email.invalid}") String email,@PathVariable @Pattern(regexp = "^[0-9]{6}$",message = "{otp.invalid}") String otp)throws JobPortalException{
          userService.verifyOtp(email,otp);
         return new ResponseEntity<>(new ResponseDto("OTP has been verified."),HttpStatus.OK);
    }

}
