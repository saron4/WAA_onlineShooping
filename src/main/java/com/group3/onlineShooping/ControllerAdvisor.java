package com.group3.onlineShooping;

import com.group3.onlineShooping.domain.Notification;
import com.group3.onlineShooping.service.NotificationService;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@ControllerAdvice
public class ControllerAdvisor {
    private final NotificationService notificationService;

    public ControllerAdvisor(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @ModelAttribute("unSeenNotifications")
    public List<Notification> notifications() {
        List<Notification> notifications = notificationService.getAllUnSeen();
        return notifications;
    }
}
