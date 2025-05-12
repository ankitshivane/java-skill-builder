package skillbuilder.core.multithreading.sync;

public class SynchronizedDemo3 {
    /**
     * Notes:
     * 1. If we are not declaring wish() method as synchronized then both Threads will be executed simultaneously and we will get irregular output.
     * 2. If we declare wish() method as synchronized then the Threads will be executed one by one that is until completing the 1st Thread the 2nd
     * Thread will wait in this case we will get regular output which is nothing but, check the output of case:2
     */
    public static void main(String[] args) {
        // CASE: 1
        DisplayName dn = new DisplayName();
        MyThread t1 = new MyThread(dn, "Dhoni");
        MyThread t2 = new MyThread(dn, "yuvraj");

        // CASE: 2
//        DisplayName dn2 = new DisplayName();
//        MyThread t2 = new MyThread(dn2, "yuvraj");
        t1.start();
        t2.start();
    }
}

class DisplayName {
    public synchronized void wish(String name) {
        for (int i = 0; i < 5; i++) {
            System.out.print("Good Morning: ");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(name);
        }
    }
}

class MyThread extends Thread {
    DisplayName displayName;
    String name;

    public MyThread(DisplayName displayName, String name) {
        this.displayName = displayName;
        this.name = name;
    }

    @Override
    public void run() {
        displayName.wish(name);
    }
}