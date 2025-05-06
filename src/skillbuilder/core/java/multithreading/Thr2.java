package skillbuilder.core.java.multithreading;

public class Thr2 extends Thread {
    // Allowing child thread Th2 to wait until main thread finish
    private static Thread thread;

    public void run() {
        for (int i = 0; i < 7; i++) {
            try {
                thread.join();
                System.out.println("Inside Thread-0");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        thread = Thread.currentThread();
        Thr2 t1 = new Thr2();
        t1.start();
//        Thread t2 = new Thread(t1);
//        t2.start();
//        t2.join(3000);
        for (int i = 0; i < 5; i++) {
            System.out.println("Inside main thread");
            Thread.sleep(1000);
        }
    }

    private static void joinDemo1() {
        Thr2 t1 = new Thr2();
        t1.start();

    }

    private static void exceptionHandlingMetho() {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
            }
        });

        Thread t2 = new Thread(() -> {
            throw new RuntimeException("Throwing an intentional error...");
        });
        t2.setUncaughtExceptionHandler((p1, p2) -> {
            System.out.println("Handled uncaught error::" + p2.getMessage());
        });
        t2.start();
        System.out.println(Thread.currentThread().getName() + " finished.");
        /*
        OUTPUT:
main finished.
Handled uncaught error::Throwing an intentional error...
         */
    }
}
