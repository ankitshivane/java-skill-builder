package skillbuilder.designPatterns.creational.singleton.serializationBreak;

import java.io.*;

public class SerDemo1 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        EagerSingleton instance1 = EagerSingleton.getInstance();
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("data.obj"));
        out.writeObject(instance1);

        ObjectInputStream in = new ObjectInputStream(new FileInputStream("data.obj"));
        EagerSingleton instance2 = (EagerSingleton) in.readObject(); // new object created!
        System.out.println("instance1 == instance2 : ? " + (instance1 == instance2));
        /*
        Explanation: as we can see here the comparison of both serialized and desialized object is false it means while deserializing a new object
        got created which breaks singleton in serialization.
        OUTPUT:
        instance1 == instance2 : ? false
         */
    }
}
