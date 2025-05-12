package skillbuilder.core.multithreading.InterThreadComm.demo2;

public class SumDemo extends Thread {
    int sum = 0;

    @Override
    public void run() {
        synchronized (this) {
            for (int i = 1; i <= 100; i++) {
                sum += i;
            }
            Thread.currentThread().notify(); // OR this.notify();
            System.out.println("Task Finished...");
        }
    }
}
