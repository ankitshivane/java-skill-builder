package skillbuilder.designPatterns.creational.singleton;

public class DoubleCheckSingletonDemo {
    private static volatile DoubleCheckSingletonDemo instance;

    private DoubleCheckSingletonDemo() {

    }

    public static DoubleCheckSingletonDemo getInstance() {
        if (instance == null) {
            synchronized (DoubleCheckSingletonDemo.class) {
                // Double check
                if (instance == null) {
                    instance = new DoubleCheckSingletonDemo();
                }
            }
        }
        return instance;
    }
}
