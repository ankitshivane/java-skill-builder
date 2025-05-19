package skillbuilder.designPatterns.creational.singleton.serializationBreak;

import java.io.Serializable;

public class EagerSingleton implements Serializable {
    private static final EagerSingleton INSTNACE = new EagerSingleton();

    private EagerSingleton() {
    }

    public static EagerSingleton getInstance() {
        return INSTNACE;
    }
}