package skillbuilder.designPatterns.creational.singleton;

public class DoubleCheckSingletonWorkingInMultiThreading {
    public static void main(String[] args) {
        Thread t1 = new Thread(DoubleCheckSingletonDemo1::getInstance, "Thread-1");
        Thread t2 = new Thread(DoubleCheckSingletonDemo1::getInstance, "Thread-2");
        t1.start();
        t2.start();
    }
}

class DoubleCheckSingletonDemo1 {
    private static volatile DoubleCheckSingletonDemo1 instance;

    private DoubleCheckSingletonDemo1() {
        System.out.println("Inside constructor called by " + Thread.currentThread().getName() + " thread");
    }

    public static DoubleCheckSingletonDemo1 getInstance() {
        System.out.println("getInstance method called by " + Thread.currentThread().getName());
        if (instance == null) {
            System.out.println("Inside First Check " + Thread.currentThread().getName());
            synchronized (DoubleCheckSingletonDemo1.class) {
                System.out.println("Inside synchronized block, acquiring lock " + Thread.currentThread().getName());
                // Double check
                if (instance == null) {
                    System.out.println("Inside double check creating instance " + Thread.currentThread().getName());
                    instance = new DoubleCheckSingletonDemo1();
                }
            }
        }
        return instance;
    }
}
/*
OUTPUT:

getInstance method called by Thread-1
Inside First Check Thread-1
getInstance method called by Thread-2
Inside synchronized block, acquiring lock Thread-1
Inside First Check Thread-2
Inside double check creating instance Thread-1
Inside constructor called by Thread-1 thread
Inside synchronized block, acquiring lock Thread-2
 */