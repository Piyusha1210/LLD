# Entities
- entities.User
  - userID
  - name
  
- entities.Notification
  - String notificationID
  - String userID
  - String message
  - NotificationStatus status
  - enums.NotificationType type
  - int retryCount
  
- enums.NotificationType (enum)
- NotificationStatus (enum)
  - SUCCESS
  - FAILED
  - PENDING

- enums.NotificationPriority
  - NORMAL
  - HIGH

# Service
- NotificationController
  + sendNotification(entities.User user, String message, enums.NotificationType type)

- service.NotificationService (interface)
  + sendNotification(entities.Notification notification);

- EmailNotificationService implements service.NotificationService;
- SmsNotificationService implements service.NotificationService;

- service.NotificationFactory
  + service.NotificationService getNotificationService(enums.NotificationType)

- NotificationStrategy
  + List<enums.NotificationType> getNotificationType(enums.NotificationType type)

- NormalNotificationStrategy implements NotificationStrategy
- HighNotificationStrategy implements NotificationStrategy

- NotificationRetryDecorator implements service.NotificationService
