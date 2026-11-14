package service;

import enums.NotificationPriority;

public class NotificationPriorityFactory {
    public NotificationPriorityService getNotificationPriorityService(NotificationPriority priority) {
        if(priority == NotificationPriority.HIGH)
            return new HighPriorityService();

        return new NormalPriorityService();
    }
}
