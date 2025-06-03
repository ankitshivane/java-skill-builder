package skillbuilder.designPatterns.behavioural.Observer;

public class ObserverDemo {
    public static void main(String[] args) {
        AppointmentSlotPublisher publisher = new AppointmentSlotPublisher();

        PatientSubscriber ankit = new PatientSubscriber("Ankit");
        PatientSubscriber shivani = new PatientSubscriber("Shivani");

        publisher.subscribe(ankit);
        publisher.subscribe(shivani);

        publisher.newSlotAvailable("2025-06-10", "Agarwal");

        // Remove one observer
        publisher.unsubscribe(ankit);

        publisher.newSlotAvailable("2025-06-15", "Sharma");
    }
}
/*
OUTPUT:
Ankit received notification: New appointment slot available on 2025-06-10 with Dr. Agarwal
Shivani received notification: New appointment slot available on 2025-06-10 with Dr. Agarwal
Shivani received notification: New appointment slot available on 2025-06-15 with Dr. Sharma
 */
