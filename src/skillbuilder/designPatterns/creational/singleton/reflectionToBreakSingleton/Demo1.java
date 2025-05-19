package skillbuilder.designPatterns.creational.singleton.reflectionToBreakSingleton;

import skillbuilder.designPatterns.creational.singleton.EagerInitializationDemo;
import skillbuilder.designPatterns.creational.singleton.LazyInitializationDemo1;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Demo1 {
    public static void main(String[] args) throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        // Uncomment each line to see each case separately

        // CASE:1
//        breakEagerInitilizationOfSingleton();
        // CASE:2
//        breakLazyInitializationSingleton();

        // CASE:3
        preventEagerInitializationOfSingletonFromReflection();
    }

    private static void preventEagerInitializationOfSingletonFromReflection() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        PreventEagerInitializationWithReflection instance1 = PreventEagerInitializationWithReflection.getInstance();
        System.out.println("First instance hashCode:" + instance1.hashCode());
        Constructor<PreventEagerInitializationWithReflection> constructor = PreventEagerInitializationWithReflection.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        PreventEagerInitializationWithReflection instance2 = constructor.newInstance();
        System.out.println("Second instance hashCode:" + instance2.hashCode());

        /*
Explanation: As you can see here after printing the hashCode of first instance using getInstance() method, when we tried calling a constructor
using reflection API it throw an Runtime exception and didnt allowed to create a object.

OUTPUT:

First instance hashCode:455659002
Exception in thread "main" java.lang.reflect.InvocationTargetException
	at java.base/jdk.internal.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)
	at java.base/jdk.internal.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:77)
	at java.base/jdk.internal.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)
	at java.base/java.lang.reflect.Constructor.newInstanceWithCaller(Constructor.java:499)
	at java.base/java.lang.reflect.Constructor.newInstance(Constructor.java:480)
	at skillbuilder.designPatterns.creational.singleton.reflectionToBreakSingleton.Demo1.preventEagerInitializationOfSingletonFromReflection(Demo1.java:21)
	at skillbuilder.designPatterns.creational.singleton.reflectionToBreakSingleton.Demo1.main(Demo1.java:13)
Caused by: java.lang.RuntimeException: Use getInstance() only
	at skillbuilder.designPatterns.creational.singleton.reflectionToBreakSingleton.PreventEagerInitializationWithReflection.<init>(PreventEagerInitializationWithReflection.java:8)
         */
    }

    private static void breakLazyInitializationSingleton() throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        LazyInitializationDemo1 instance1 = LazyInitializationDemo1.getInstance2();
        LazyInitializationDemo1 instance2 = LazyInitializationDemo1.getInstance();
        Constructor<LazyInitializationDemo1> constructor = LazyInitializationDemo1.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        LazyInitializationDemo1 instance3 = constructor.newInstance();
        System.out.println("First instance hashCode:" + instance1.hashCode());
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

