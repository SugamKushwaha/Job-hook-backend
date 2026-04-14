package com.jobportal.JobPortal.entity;

import java.time.LocalDateTime;

import com.jobportal.JobPortal.dto.NotificationDto;
import com.jobportal.JobPortal.dto.NotificationStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Notification {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    private String message;

    private String action;

    private String route;

    @Enumerated(EnumType.STRING)
    private NotificationStatus status;

    private LocalDateTime timeStamp;

    public NotificationDto toDTO(){
        return new NotificationDto(id, userId, message, action, route, status, timeStamp);
    }
}
