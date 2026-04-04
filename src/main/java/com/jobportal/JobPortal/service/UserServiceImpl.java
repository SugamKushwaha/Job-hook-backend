package com.jobportal.JobPortal.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.jobportal.JobPortal.dto.LoginDto;
import com.jobportal.JobPortal.dto.UserDto;
import com.jobportal.JobPortal.entity.OTP;
import com.jobportal.JobPortal.entity.User;
import com.jobportal.JobPortal.exception.JobPortalException;
import com.jobportal.JobPortal.repository.OTPRepository;
import com.jobportal.JobPortal.repository.UserRepository;
import com.jobportal.JobPortal.utility.Utilitties;

import jakarta.mail.internet.MimeMessage;


@Service(value="userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OTPRepository otpRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JavaMailSender mailSender;

    
    @Override
    public UserDto registerUser(UserDto userDto) {

        Optional<User> optional=userRepository.findByEmail(userDto.getEmail());
        if(optional.isPresent())throw new JobPortalException("USER_FOUND");

       userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
       User user = userDto.toEntity();
      user = userRepository.save(user);
      return user.toDto();
    }

    @Override
    public UserDto loginUser(LoginDto loginDto) throws JobPortalException {
       User user = userRepository.findByEmail(loginDto.getEmail()).orElseThrow(()->new JobPortalException("USER_NOT_FOUND"));

       if(!passwordEncoder.matches(loginDto.getPassword(), user.getPassword()))throw new JobPortalException("INVALID_CREDENTIALS");

       return user.toDto();
    }

    @Override
    public Boolean sendOtp(String email) throws Exception {
         User user = userRepository.findByEmail(email).orElseThrow(()->new JobPortalException("USER_NOT_FOUND"));

         MimeMessage mm = mailSender.createMimeMessage();
         MimeMessageHelper message = new MimeMessageHelper(mm,true);
         
         message.setTo(email);
         message.setSubject("Your OTP Code");

         String genOtp = Utilitties.generateOtp();

         OTP otp = new OTP(email, genOtp, LocalDateTime.now());

         otpRepository.save(otp);
         message.setText("Your Code is :"+genOtp,false);
         
    }

    
}
