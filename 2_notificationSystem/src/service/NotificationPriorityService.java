package service;

import entities.Notification;
import enums.NotificationType;

import java.util.List;

public interface NotificationPriorityService {

    public List<NotificationType> getNotificationType(Notification notification);
}
