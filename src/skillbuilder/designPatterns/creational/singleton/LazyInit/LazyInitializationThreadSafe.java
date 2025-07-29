package skillbuilder.designPatterns.creational.singleton.LazyInit;

public class LazyInitializationThreadSafe {
    private static LazyInitializationThreadSafe instance;

    private LazyInitializationThreadSafe() {

    }

    public static synchronized LazyInitializationThreadSafe getInstance() {
        if (null == instance) {
            instance = new LazyInitializationThreadSafe();
        }
        return instance;
    }
}
