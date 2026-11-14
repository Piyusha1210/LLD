import decorator.RetryNotificationDecorator;
import entities.Notification;
import enums.NotificationType;
import service.NotificationFactory;
import service.NotificationPriorityFactory;
import service.NotificationPriorityService;
import service.NotificationService;

import java.util.List;

public class NotificationManager {

    private NotificationFactory notificationFactory;
    private NotificationPriorityFactory priorityFactory;

    public NotificationManager() {
        notificationFactory = new NotificationFactory();
        priorityFactory = new NotificationPriorityFactory();
    }

    public Boolean sendNotification(Notification notification) {
        NotificationPriorityService priorityService =
                priorityFactory.getNotificationPriorityService(notification.getPriority());

        List<NotificationType> types = priorityService.getNotificationType(notification);

        for(NotificationType type: types) {
            NotificationService service = new RetryNotificationDecorator(
                    notificationFactory.getNotificationService(type), 3);

            service.sendNotification(notification);
        }
        return true;
    }
}
