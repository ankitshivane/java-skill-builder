package skillbuilder.core.multithreading;

public class MyThread2 extends Thread {
    public void run() {
        for (int i = 0; i < 1000; i++) {
            /*try {
//                Thread.yield();
                System.out.println("Inside Thread-0");
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }*/
            System.out.println("Inside Thread-0");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyThread2 t1 = new MyThread2();
        t1.start();
//        Thread.sleep(1000);
//        Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
        t1.interrupt();
//        Thread.currentThread().interrupt();
        for (int i = 0; i < 5; i++) {
            Thread.sleep(1000);
            System.out.println("Inside main Thread");
        }
    }
}
