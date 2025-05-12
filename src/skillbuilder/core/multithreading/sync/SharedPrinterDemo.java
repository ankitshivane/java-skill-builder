package skillbuilder.core.multithreading.sync;

public class SharedPrinterDemo {
    public static void main(String[] args) {
        SharedPrinter sp = new SharedPrinter();
        Runnable task = () -> sp.print();
        Thread t1 = new Thread(task, "T1");
        Thread t2 = new Thread(task, "T2");
        t1.start();
        t2.start();
    }
}

class SharedPrinter {
    public synchronized void print() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Print by " + Thread.currentThread().getName() + ", time:" + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
/*
OUTPUT: without synchronized keyword, as you can see below both threads are operating on the same object simultaneously.
Print by T2, time:1
Print by T1, time:1
Print by T2, time:2
Print by T1, time:2
Print by T2, time:3
Print by T1, time:3
Print by T1, time:4
Print by T2, time:4
Print by T1, time:5
Print by T2, time:5
 */

/*
OUTPUT: after using synchronized keyword, you can see that one thread is getting chance to operate on the shared object one at a time

Print by T1, time:1
Print by T1, time:2
Print by T1, time:3
Print by T1, time:4
Print by T1, time:5
Print by T2, time:1
Print by T2, time:2
Print by T2, time:3
Print by T2, time:4
Print by T2, time:5
 */