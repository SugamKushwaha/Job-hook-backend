package com.jobportal.JobPortal.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.jobportal.JobPortal.dto.LoginDto;
import com.jobportal.JobPortal.dto.NotificationDto;
import com.jobportal.JobPortal.dto.ResponseDto;
import com.jobportal.JobPortal.dto.UserDto;
import com.jobportal.JobPortal.entity.OTP;
import com.jobportal.JobPortal.entity.User;
import com.jobportal.JobPortal.exception.JobPortalException;
import com.jobportal.JobPortal.repository.OTPRepository;
import com.jobportal.JobPortal.repository.UserRepository;
import com.jobportal.JobPortal.utility.Data;
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

    @Autowired
    private ProfileService profileService;

    @Autowired
    private NotificationService notificationService;

    
    @Override
    public UserDto registerUser(UserDto userDto) {

        Optional<User> optional=userRepository.findByEmail(userDto.getEmail());
        if(optional.isPresent())throw new JobPortalException("USER_FOUND");
   
        userDto.setProfileId(profileService.createProfile(userDto.getEmail()));
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
         message.setText(Data.getMessageBody(genOtp),true);
         mailSender.send(mm);
         return true;
    }

    @Override
    public Boolean verifyOtp(String email,String otp) throws JobPortalException {
       OTP otpEntity = otpRepository.findById(email).orElseThrow(()->new JobPortalException("OTP_NOT_FOUND"));
       if(!otpEntity.getOtpCode().equals(otp))throw new JobPortalException("OTP_INCORRECT");

       return true;
    }

    @Override
    public ResponseDto changePassword(LoginDto loginDto) throws JobPortalException {
         User user = userRepository.findByEmail(loginDto.getEmail()).orElseThrow(()->new JobPortalException("USER_NOT_FOUND"));
         user.setPassword(passwordEncoder.encode(loginDto.getPassword()));
         userRepository.save(user);
 
         NotificationDto noti = new NotificationDto();
         noti.setUserId(user.getId());
         noti.setMessage("Password Reset Successfull");
         noti.setAction("Password Reset");

         notificationService.sendNotification(noti);
         
         
         return new ResponseDto("Password changed Successfully");

    }

    @Scheduled(fixedRate=60000)
    public void removeExpiredOTPs(){
        LocalDateTime expiry = LocalDateTime.now().minusMinutes(5);

        List<OTP> expiredOtps=otpRepository.findByCreationTimeBefore(expiry);
        
        if(!expiredOtps.isEmpty()){
            otpRepository.deleteAll(expiredOtps);
            System.out.println("Removed"+expiredOtps.size()+"expired OTPS");
        }
    }

    @Override
    public UserDto getUserByEmail(String email) throws JobPortalException {
        
        return  userRepository.findByEmail(email).orElseThrow(()->new JobPortalException("USER_NOT_FOUND")).toDto();
    }

    
}
