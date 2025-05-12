package skillbuilder.core.multithreading.sync;

public class DeadlockExample {
    /**
     * Both threads are stuck forever → Deadlock confirmed.
     */
    private static final Object lockA = new Object();
    private static final Object lockB = new Object();

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            synchronized (lockA) {
                System.out.println("Thread-1: Holding lock A...");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                }
                System.out.println("Thread-1: Waiting for lock B...");
                synchronized (lockB) {
                    System.out.println("Thread-1: Acquired lock B!");
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (lockB) {
                System.out.println("Thread-2: Holding lock B...");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                }
                System.out.println("Thread-2: Waiting for lock A...");
                synchronized (lockA) {
                    System.out.println("Thread-2: Acquired lock A!");
                }
            }
        });

        t1.start();
        t2.start();
    }
    /*
    OUTPUT:

Thread-1: Holding lock A...
Thread-2: Holding lock B...
Thread-2: Waiting for lock A...
Thread-1: Waiting for lock B...
     */
}
