package skillbuilder.core.multithreading;

public class IsAliveExample {

    public static void main(String[] args) {
        // Create a new thread using a lambda for its Runnable task
        Thread myTaskThread = new Thread(() -> {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + ": Thread started. isAlive() should be true now.");
            try {
                // Simulate some work
                for (int i = 0; i < 5; i++) {
                    System.out.println(threadName + ": Working... count " + i);
                    Thread.sleep(500); // Sleep for 500 milliseconds
                }
            } catch (InterruptedException e) {
                System.err.println(threadName + ": Thread was interrupted.");
                Thread.currentThread().interrupt(); // Restore interrupted status
            }
            System.out.println(threadName + ": Thread finishing. isAlive() will be false soon after this.");
        }, "MyWorkerThread");

        // 1. Check isAlive() BEFORE starting the thread
        System.out.println("Main: Before starting myTaskThread. isAlive()? " + myTaskThread.isAlive()); // Expected: false

        // 2. Start the thread
        myTaskThread.start();

        // 3. Check isAlive() shortly AFTER starting the thread
        // There's a tiny race condition here; for illustration, we'll assume it's running.
        // In a real scenario, it might still be false for a microsecond before the OS schedules it.
        System.out.println("Main: Immediately after starting myTaskThread. isAlive()? " + myTaskThread.isAlive()); // Expected: true (usually)

        // Let's give the thread some time to run and check isAlive() periodically
        while (myTaskThread.isAlive()) {
            System.out.println("Main: myTaskThread is still alive. Waiting a bit...");
            try {
                Thread.sleep(1000); // Main thread sleeps for 1 second
            } catch (InterruptedException e) {
                System.err.println("Main: Interrupted while sleeping.");
                Thread.currentThread().interrupt();
            }
        }

        // 4. Check isAlive() AFTER the thread has likely finished
        // This will be true if the loop above exited because myTaskThread is no longer alive.
        System.out.println("Main: After myTaskThread should have finished. isAlive()? " + myTaskThread.isAlive()); // Expected: false

        System.out.println("Main: Main thread finished.");
    }
    /*
    OUTPUT:

Main: Before starting myTaskThread. isAlive()? false
Main: Immediately after starting myTaskThread. isAlive()? true
Main: myTaskThread is still alive. Waiting a bit...
MyWorkerThread: Thread started. isAlive() should be true now.
MyWorkerThread: Working... count 0
MyWorkerThread: Working... count 1
Main: myTaskThread is still alive. Waiting a bit...
MyWorkerThread: Working... count 2
MyWorkerThread: Working... count 3
Main: myTaskThread is still alive. Waiting a bit...
MyWorkerThread: Working... count 4
MyWorkerThread: Thread finishing. isAlive() will be false soon after this.
Main: After myTaskThread should have finished. isAlive()? false
Main: Main thread finished.

     */
}