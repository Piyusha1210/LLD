package service;

import entities.Notification;
import enums.NotificationType;

import java.util.List;

public class NormalPriorityService implements NotificationPriorityService {
    public List<NotificationType> getNotificationType(Notification notification) {
        return List.of(notification.getNotificationType());
    }
}
