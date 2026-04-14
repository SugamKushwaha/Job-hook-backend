package com.jobportal.JobPortal.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jobportal.JobPortal.dto.ResponseDto;
import com.jobportal.JobPortal.entity.Notification;
import com.jobportal.JobPortal.service.NotificationService;

@RestController
@CrossOrigin
@RequestMapping("/notification")
@Validated
public class NotificationApi {

    @Autowired
    private NotificationService notificationService;

    @GetMapping("/get/{userId}")
    public ResponseEntity<List<Notification>> getNotifications(@PathVariable Long userId){

        return  new ResponseEntity<>(notificationService.getUnreadNotifications(userId),HttpStatus.OK);
    }

    @PutMapping("/read/{id}")
    public ResponseEntity<ResponseDto> readNotifications    (@PathVariable Long id){
    
        notificationService.readNotification(id);
        return new ResponseEntity<>(new ResponseDto    ("Success"), HttpStatus.OK);
    }    
    
}
