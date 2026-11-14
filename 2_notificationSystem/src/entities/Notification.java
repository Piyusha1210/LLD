package entities;

import enums.NotificationPriority;
import enums.NotificationStatus;
import enums.NotificationType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Notification {
    private String notificationID;
    private String userID;
    private NotificationType notificationType;
    private NotificationPriority priority;
    private Integer retryCount;
    private NotificationStatus status;
}
