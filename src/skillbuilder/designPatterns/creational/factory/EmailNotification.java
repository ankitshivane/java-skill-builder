package skillbuilder.designPatterns.creational.factory;

// Step 2: Concrete Products
public class EmailNotification implements Notification {
    public void notifyUser() {
        System.out.println("Sending Email Notification");
    }
}