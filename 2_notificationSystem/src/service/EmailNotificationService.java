package service;

import entities.Notification;

public class EmailNotificationService implements NotificationService {

    public Boolean sendNotification(Notification notification) {
        return true;
    }
}
