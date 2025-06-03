package skillbuilder.designPatterns.creational.factory;

// Step 4: Client Code
public class ClientApp {
    public static void main(String[] args) {
        Notification notification = NotificationFactory.createNotification("EMAIL");
        notification.notifyUser();  // Output: Sending Email Notification
        // OUTPUT: Sending Email Notification
    }
}
