package skillbuilder.designPatterns.creational.singleton;

public class DoubleCheckSingletonWorkingInMultiThreading {
    public static void main(String[] args) {
        Thread t1 = new Thread(DoubleCheckSingletonDemo1::getInstance, "Thread-1");
        Thread t2 = new Thread(()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            DoubleCheckSingletonDemo1.getInstance();
        }, "Thread-2");
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
        if (instance == null) { // First check (without lock)
            System.out.println("Inside First Check by " + Thread.currentThread().getName());

            synchronized (DoubleCheckSingletonDemo1.class) {
                System.out.println("Inside synchronized block, acquiring lock: " + Thread.currentThread().getName());

                // Double check
                if (instance == null) { // Second check (with lock)
                    System.out.println("Instance is null, creating now: " + Thread.currentThread().getName());
                    instance = new DoubleCheckSingletonDemo1();
                }
            }
        }
        return instance;
    }
}
/*
OUTPUT: Explanation:as you can see here only one thread is able to call constructor and create a Object,
 also as you can see another thread didnt acquired the lock and went to synchronized block.


getInstance method called by Thread-1
Inside First Check by Thread-1
Inside synchronized block, acquiring lock: Thread-1
Instance is null, creating now: Thread-1
Inside constructor called by Thread-1 thread
getInstance method called by Thread-2
 */