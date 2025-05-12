package skillbuilder.core.multithreading.sync;

public class SynchronizedDemo5 {
    public static void main(String[] args) {
        LockTest obj = new LockTest();

        Thread t1 = new Thread(() -> LockTest.staticMethod(), "Thread-A"); // class lock
        Thread t2 = new Thread(() -> obj.instanceMethod(), "Thread-B");    // object lock

        t1.start();
        t2.start();
    }
    /*
    OUTPUT:
Thread-B - Acquired OBJECT lock
Thread-A - Acquired CLASS lock
Thread-B - Released OBJECT lock
Thread-A - Released CLASS lock
     */
}

class LockTest {

    public static synchronized void staticMethod() {
        System.out.println(Thread.currentThread().getName() + " - Acquired CLASS lock");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ignored) {
        }
        System.out.println(Thread.currentThread().getName() + " - Released CLASS lock");
    }

    public synchronized void instanceMethod() {
        System.out.println(Thread.currentThread().getName() + " - Acquired OBJECT lock");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ignored) {
        }
        System.out.println(Thread.currentThread().getName() + " - Released OBJECT lock");
    }
}
