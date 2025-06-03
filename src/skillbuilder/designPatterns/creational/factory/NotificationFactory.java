package skillbuilder.designPatterns.creational.factory;

// Step 3: Factory (Creator) Class
public class NotificationFactory {
    public static Notification createNotification(String type) {
        if ("EMAIL".equalsIgnoreCase(type)) {
            return new EmailNotification();
        } else if ("SMS".equalsIgnoreCase(type)) {
            return new SMSNotification();
        }
        throw new IllegalArgumentException("Unknown notification type: " + type);
    }
}
