import entities.Notification;

public class NotificationController {

    private static NotificationController instance;
    private NotificationManager manager;

    private NotificationController() {
        this.manager = new NotificationManager();
    }

    public static NotificationController getInstance()  {
        if(instance == null) {
            instance = new NotificationController();
        }
        return instance;
    }

    public Boolean sendNotification(Notification notification) {
        return manager.sendNotification(notification);
    }
}
