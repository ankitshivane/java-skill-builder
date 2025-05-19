package skillbuilder.designPatterns.creational.singleton.reflectionToBreakSingleton;

public class PreventEagerInitializationWithReflection {
    private static final PreventEagerInitializationWithReflection INSTANCE = new PreventEagerInitializationWithReflection();

    private PreventEagerInitializationWithReflection() {
        if (INSTANCE != null) {
            throw new RuntimeException("Use getInstance() only");
        }
    }

    public static PreventEagerInitializationWithReflection getInstance() {
        return INSTANCE;
    }
}

