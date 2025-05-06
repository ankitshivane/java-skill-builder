package skillbuilder.core.multithreading;

public class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 4; i++) {
            System.out.println(Thread.currentThread().getName());
            try {
                System.out.println("Before pausing The Thread:" + Thread.currentThread().getState());
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Starting Main Thread");
        MyThread thread = new MyThread();
        System.out.println(thread.getState()); // NEW state
        thread.start();
        System.out.println(thread.getState()); // RUNNABLE state
        for (int i = 0; i < 10; i++) {
//            System.out.println(Thread.currentThread().getName());
            Thread.sleep(1000);
            System.out.println(thread.getState());
        }
        thread.join();
        System.out.println("Post Main Thread ended " + thread.getState()); // TERMINATED state
    }
}
