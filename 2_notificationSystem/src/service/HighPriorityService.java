package service;

import entities.Notification;
import enums.NotificationType;

import java.util.List;

public class HighPriorityService implements NotificationPriorityService {

    public List<NotificationType> getNotificationType(Notification notification) {
        return List.of(NotificationType.EMAIL, NotificationType.SMS);
    }
}
