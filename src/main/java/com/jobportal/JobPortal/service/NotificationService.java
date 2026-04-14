package com.jobportal.JobPortal.service;

import java.util.List;

import com.jobportal.JobPortal.dto.NotificationDto;
import com.jobportal.JobPortal.entity.Notification;
import com.jobportal.JobPortal.exception.JobPortalException;


public interface NotificationService {

    public void sendNotification(NotificationDto notificationDto);
    
    public List<Notification> getUnreadNotifications(Long userId);

    public void readNotification(Long id)throws JobPortalException;

    
}
