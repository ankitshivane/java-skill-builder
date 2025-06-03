package skillbuilder.designPatterns.behavioural.Observer;

public class PatientSubscriber implements Observer {
    private String name;

    public PatientSubscriber(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + " received notification: " + message);
    }
}
