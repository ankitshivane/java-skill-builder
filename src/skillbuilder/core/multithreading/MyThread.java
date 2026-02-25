package skillbuilder.core.multithreading;

public class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 4; i++) {
            try {
                System.out.println("Inside "+Thread.currentThread().getName()+", Before pausing The Thread:" + Thread.currentThread().getState());
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Starting Main Thread");
        MyThread thread = new MyThread();
        System.out.println(thread.getName()+" state:"+thread.getState()); // NEW state
        thread.start();
        System.out.println(thread.getName()+" state:"+thread.getState()); // RUNNABLE state
        System.out.println("---------------------------------------");
        for (int i = 0; i < 10; i++) {
            Thread.sleep(1000);
            System.out.println("state: "+thread.getState()+", main thread state:"+Thread.currentThread().getState());
        }
        thread.join();
        System.out.println("Post Main Thread ended " + thread.getState()); // TERMINATED state
    }
}
