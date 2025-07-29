package skillbuilder.designPatterns.creational.singleton;

public class EagerInitializationDemo {
    // Eagerly instantiating the class at the time of declaring the instance
    private static final EagerInitializationDemo instance = new EagerInitializationDemo();

    private EagerInitializationDemo() {
    }

    public static EagerInitializationDemo getInstance() {
        return instance;
    }
}