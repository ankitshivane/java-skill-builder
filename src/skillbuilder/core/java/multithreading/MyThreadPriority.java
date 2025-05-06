package skillbuilder.core.java.multithreading;

public class MyThreadPriority extends Thread {
    public MyThreadPriority(String threadName) {
        super(threadName);
    }

    @Override
    public void run() {
        String st = "";
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + ", Priority is " + Thread.currentThread().getPriority());
            for (int j = 0; j < 6000; j++) {
                st += "test";
            }
        }
    }

    public static void main(String[] args) {
        MyThreadPriority t1 = new MyThreadPriority("Low priority thread");
        t1.setPriority(Thread.MIN_PRIORITY);
        MyThreadPriority t2 = new MyThreadPriority("Medium priority thread");
        t2.setPriority(Thread.NORM_PRIORITY);
        MyThreadPriority t3 = new MyThreadPriority("High priority thread");
        t3.setPriority(Thread.MAX_PRIORITY);

        t1.start();
        t2.start();
        t3.start();
    }
}
