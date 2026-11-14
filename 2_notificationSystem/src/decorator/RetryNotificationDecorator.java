package decorator;

import entities.Notification;
import service.NotificationService;

public class RetryNotificationDecorator implements NotificationService {

    private NotificationService notificationService;
    private Integer retryCount;

    public RetryNotificationDecorator(NotificationService notificationService, Integer retryCount) {
        this.notificationService = notificationService;
        this.retryCount = retryCount;
    }

    public Boolean sendNotification(Notification notification) {
        int count = 0;
        while(retryCount > count) {
            if(notificationService.sendNotification(notification)) {
                return true;
            }
            count++;
        }
        return false;
    }

}
