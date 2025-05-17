package skillbuilder.designPatterns.creational.singleton;

public class EagerInitializationDemo {
    private static final EagerInitializationDemo intance = new EagerInitializationDemo();

    private EagerInitializationDemo() {
    }

    public static EagerInitializationDemo getInstance() {
        return intance;
    }
}