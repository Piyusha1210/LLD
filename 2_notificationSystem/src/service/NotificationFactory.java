package service;

import enums.NotificationType;

public class NotificationFactory {

    public NotificationService getNotificationService(NotificationType type) {
        if(type == NotificationType.EMAIL) {
            return new EmailNotificationService();
        }

        throw new IllegalArgumentException("Unsupported notification type");
    }
}
