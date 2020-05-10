package com.group3.onlineShooping.service;

import com.group3.onlineShooping.domain.Notification;
import com.group3.onlineShooping.domain.Order;

import java.util.List;

public interface NotificationService {
    public Notification addNotification(Notification notification);

    public List<Notification> getAll();
    public List<Notification> getAllUnSeen();

    public Notification getNotification(Long id);

    public void deleteNotification(Long id);

    public Notification editNotification(Notification notification);
}
