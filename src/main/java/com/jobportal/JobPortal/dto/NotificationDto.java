package com.jobportal.JobPortal.dto;

import java.time.LocalDateTime;

import com.jobportal.JobPortal.entity.Notification;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotificationDto {

     private Long id;

    private Long userId;

    private String message;

    private String action;

    private String route;

    private NotificationStatus status;

    private LocalDateTime timeStamp;

    public Notification toEntity(){
       return new Notification(null, userId, message, action, route, status, timeStamp);
    }
    
}
