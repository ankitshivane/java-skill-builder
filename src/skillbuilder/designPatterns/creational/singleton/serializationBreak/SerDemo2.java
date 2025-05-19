package skillbuilder.designPatterns.creational.singleton.serializationBreak;

import java.io.*;

public class SerDemo2 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        EagerSingleton2 instance1 = EagerSingleton2.getInstance();
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("data.obj"));
        out.writeObject(instance1);

        ObjectInputStream in = new ObjectInputStream(new FileInputStream("data.obj"));
        EagerSingleton2 instance2 = (EagerSingleton2) in.readObject(); // new object created!
        System.out.println("instance1 == instance2 : ? " + (instance1 == instance2));
        /*
        OUTPUT:
        instance1 == instance2 : ? true
         */
    }
}

class EagerSingleton2 implements Serializable {
    private static final EagerSingleton2 INSTNACE = new EagerSingleton2();

    private EagerSingleton2() {
    }

    public static EagerSingleton2 getInstance() {
        return INSTNACE;
    }

    public Object readResolve() {
        return INSTNACE;
    }
}