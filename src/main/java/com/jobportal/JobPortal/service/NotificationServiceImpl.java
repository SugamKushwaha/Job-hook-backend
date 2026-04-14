package com.jobportal.JobPortal.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobportal.JobPortal.dto.NotificationDto;
import com.jobportal.JobPortal.dto.NotificationStatus;
import com.jobportal.JobPortal.entity.Notification;
import com.jobportal.JobPortal.exception.JobPortalException;
import com.jobportal.JobPortal.repository.NotificationRepository;

@Service
public class NotificationServiceImpl implements NotificationService{

    @Autowired
    private NotificationRepository notificationRepository;

    @Override
    public void sendNotification(NotificationDto notificationDto) {
        notificationDto.setStatus(NotificationStatus.UNREAD);
        notificationDto.setTimeStamp(LocalDateTime.now());
        notificationRepository.save(notificationDto.toEntity());
        
    }

    @Override
    public List<Notification> getUnreadNotifications(Long userId) {
        return notificationRepository.findByUserIdAndStatus(userId, NotificationStatus.UNREAD);
    }

    @Override
    public void readNotification(Long id) throws JobPortalException {
       Notification noti = notificationRepository.findById(id).orElseThrow(()->new JobPortalException("No Notifications"));

       noti.setStatus(NotificationStatus.READ);
       notificationRepository.save(noti);
    }
    
}
