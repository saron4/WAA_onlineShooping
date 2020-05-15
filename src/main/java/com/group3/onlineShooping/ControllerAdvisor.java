package com.group3.onlineShooping;

import com.group3.onlineShooping.domain.Notification;
import com.group3.onlineShooping.service.NotificationService;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.List;

@ControllerAdvice
public class ControllerAdvisor {
    private final NotificationService notificationService;

    public ControllerAdvisor(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @ModelAttribute("unreadNotifications")
    public List<Notification> notifications() {
        List<Notification> notifications = notificationService.getAllUnSeen();
        return notifications;
    }

    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(AccessDeniedException.class)
    public String accessDeniedException(AccessDeniedException e) throws Exception {
        return "/accessdenied";
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public String badRequest(Exception e) throws Exception {
        return "/pagenotfound";
    }
/*
    @ExceptionHandler(Exception.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public String exception(Exception e) throws Exception {
        return "/error";
    }*/

}
