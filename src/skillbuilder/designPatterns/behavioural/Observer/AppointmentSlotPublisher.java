package skillbuilder.designPatterns.behavioural.Observer;

import java.util.ArrayList;
import java.util.List;

public class AppointmentSlotPublisher implements Subject {
    private List<Observer> observers = new ArrayList<>();

    @Override
    public void subscribe(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void unsubscribe(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String message) {
        for (Observer obs : observers) {
            obs.update(message);
        }
    }

    public void newSlotAvailable(String date, String doctor) {
        String message = "New appointment slot available on " + date + " with Dr. " + doctor;
        notifyObservers(message);
    }
}
