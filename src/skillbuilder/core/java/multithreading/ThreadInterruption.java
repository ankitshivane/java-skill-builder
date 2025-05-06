package skillbuilder.core.java.multithreading;

public class ThreadInterruption implements Runnable {
    public static void main(String[] args) {
        ThreadInterruption threadInterruption = new ThreadInterruption();
        Thread t1 = new Thread(threadInterruption);
        t1.start();
//        t1.interrupt();

        ThreadInterruption threadInterruption2 = new ThreadInterruption();
        Thread t2 = new Thread(threadInterruption2);
        t2.start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Inside " + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
//        Thread.yield();
    }
}
