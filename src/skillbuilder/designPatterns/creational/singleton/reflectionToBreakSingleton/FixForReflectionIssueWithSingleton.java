package skillbuilder.designPatterns.creational.singleton.reflectionToBreakSingleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class FixForReflectionIssueWithSingleton {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
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
}
