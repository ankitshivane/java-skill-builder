package skillbuilder.designPatterns.creational.singleton;

public class LazyInitializationDemo1 {
    private static LazyInitializationDemo1 instance;

    private LazyInitializationDemo1() {

    }

    public static synchronized LazyInitializationDemo1 getInstance() {
        if (null == instance) {
            instance = new LazyInitializationDemo1();
        }
        return instance;
    }

    public static LazyInitializationDemo1 getInstance2() {
        synchronized (LazyInitializationDemo1.class) {
            if (null == instance) {
                instance = new LazyInitializationDemo1();
            }
        }
        return instance;
    }
}
