package skillbuilder.designPatterns.creational.singleton.reflectionToBreakSingleton;

import skillbuilder.designPatterns.creational.singleton.EagerInitializationDemo;
import skillbuilder.designPatterns.creational.singleton.LazyInit.LazyInitializationThreadSafe;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Demo1 {
    public static void main(String[] args) throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        // Uncomment each line to see each case separately

        // CASE:1
//        breakEagerInitilizationOfSingleton();
        // CASE:2
//        breakLazyInitializationSingleton();

    }

    private static void breakLazyInitializationSingleton() throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        LazyInitializationThreadSafe instance2 = LazyInitializationThreadSafe.getInstance();
        Constructor<LazyInitializationThreadSafe> constructor = LazyInitializationThreadSafe.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        LazyInitializationThreadSafe instance3 = constructor.newInstance();
//        System.out.println("First instance hashCode:" + instance1.hashCode());
        System.out.println("Second instance hashCode:" + instance2.hashCode());
        System.out.println("Third instance hashCode:" + instance3.hashCode());
        /*
Explanation: as you can see here hashCode of first and second instance is same, but when we used Reflection to break the pattern even
LazyInitialization approach of singleton is breaking and creating multiple different objects as a proof we can see hashCode is different of third instance below.

OUTPUT:

First instance hashCode:455659002
Second instance hashCode:455659002
Third instance hashCode:1149319664
         */
    }

    private static void breakEagerInitilizationOfSingleton() throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        EagerInitializationDemo instance = EagerInitializationDemo.getInstance();
        EagerInitializationDemo instance2 = null;
        Constructor<EagerInitializationDemo> constructor = EagerInitializationDemo.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        instance2 = constructor.newInstance();
        System.out.println("First instance hashCode:" + instance.hashCode());
        System.out.println("Second instance hashCode:" + instance2.hashCode());
    }
    /*
Explanation: as you can see here both the hasCode of instance 1 and instance 2 are different, this means with reflection we are able to create two different instances of singleton class.
OUTPUT:
First instance hashCode:455659002
Second instance hashCode:1149319664
         */
}

