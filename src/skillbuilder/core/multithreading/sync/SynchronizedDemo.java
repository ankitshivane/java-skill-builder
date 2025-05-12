package skillbuilder.core.multithreading.sync;

public class SynchronizedDemo extends Thread {
    Counter counter;

    public SynchronizedDemo() {

    }

    public SynchronizedDemo(Counter counter) {
        this.counter = counter;
    }

    public static void main(String[] args) throws InterruptedException {
        Counter c = new Counter();
        SynchronizedDemo s1 = new SynchronizedDemo(c);
        SynchronizedDemo s2 = new SynchronizedDemo(c);
        s1.start();
        s2.start();

        s1.join();
        s2.join();

        System.out.println(c.getCount());
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
//            try {
//                Thread.sleep(50);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
            counter.increment();
        }
    }
}
