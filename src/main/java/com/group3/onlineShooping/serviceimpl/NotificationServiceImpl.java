package com.group3.onlineShooping.serviceimpl;

import com.group3.onlineShooping.domain.Notification;
import com.group3.onlineShooping.repository.NotificationRepository;
import com.group3.onlineShooping.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service("NotificationService")
@Transactional
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Notification addNotification(Notification notification) {
        return notificationRepository.save(notification);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public List<Notification> getAll() {
        Iterable<Notification> notificationIterable = notificationRepository.findAll();
        List<Notification> notifications = new ArrayList<>();
        notificationIterable.forEach(notifications::add);
        return notifications;
    }

    @Override
    public List<Notification> getAllUnSeen() {
        List<Notification> notifications = getAll()
                .stream()
                .filter(notif -> !notif.getSeen())
                .collect(Collectors.toList());
        return notifications;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Notification getNotification(Long id) {
        Optional<Notification> notification = notificationRepository.findById(id);
        if (!notification.isPresent()) {
            // a cusmtom excepttion has to be thrown
            try {
                throw new Exception("order not found");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return notification.get();
    }

    @Override
    public void deleteNotification(Long id) {
        Notification notification = getNotification(id);
        editNotification(notification);
    }

    @Override
    public Notification editNotification(Notification notification) {
        if (notification.getId() == null) {
            notification = notificationRepository.save(notification);
            return notification;
        } else {
            Optional<Notification> existingEntity = notificationRepository.findById(notification.getId());
            if (existingEntity.isPresent()) {
                Notification newEntity = existingEntity.get();
                newEntity.setSeen(notification.getSeen());
                newEntity = notificationRepository.save(newEntity);
                return newEntity;
            } else {
                notification = notificationRepository.save(notification);
                return notification;
            }
        }
    }
}
