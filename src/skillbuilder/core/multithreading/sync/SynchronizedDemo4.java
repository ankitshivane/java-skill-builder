package skillbuilder.core.multithreading.sync;

public class SynchronizedDemo4 {
    /**
     * @param args
     * Proves: Static synchronized method does not block instance-level or non-synchronized methods.
     */
    public static void main(String[] args) {
        MyClass obj1 = new MyClass();

        Thread t1 = new Thread(() -> MyClass.staticSyncMethod(), "Thread-1");
        Thread t2 = new Thread(() -> obj1.instanceSyncMethod(), "Thread-2");
        Thread t3 = new Thread(() -> obj1.normalMethod(), "Thread-3");
        Thread t4 = new Thread(() -> MyClass.normalStaticMethod(), "Thread-4");

        t1.start(); // locks class
        t2.start(); // can run independently (object lock)
        t3.start(); // can run independently (no lock)
        t4.start(); // can run independently (no lock)
    }
    /*
    OUTPUT:
Thread-3 - Entered normalMethod
Thread-1 - Entered staticSyncMethod
Thread-2 - Entered instanceSyncMethod
Thread-4 - Entered normalStaticMethod
Thread-2 - Exiting instanceSyncMethod
Thread-1 - Exiting staticSyncMethod
     */
}

class MyClass {

    // 1. Static synchronized method (Class-level lock)
    public static synchronized void staticSyncMethod() {
        System.out.println(Thread.currentThread().getName() + " - Entered staticSyncMethod");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ignored) {
        }
        System.out.println(Thread.currentThread().getName() + " - Exiting staticSyncMethod");
    }

    // 2. Instance synchronized method (Object-level lock)
    public synchronized void instanceSyncMethod() {
        System.out.println(Thread.currentThread().getName() + " - Entered instanceSyncMethod");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ignored) {
        }
        System.out.println(Thread.currentThread().getName() + " - Exiting instanceSyncMethod");
    }

    // 3. Non-synchronized instance method
    public void normalMethod() {
        System.out.println(Thread.currentThread().getName() + " - Entered normalMethod");
    }

    // 4. Static non-synchronized method
    public static void normalStaticMethod() {
        System.out.println(Thread.currentThread().getName() + " - Entered normalStaticMethod");
    }
}
