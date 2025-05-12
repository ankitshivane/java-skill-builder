package skillbuilder.core.multithreading.InterThreadComm.demo2;

public class Main {
    public static void main(String[] args) throws InterruptedException {
//        new Main().demoInterThreadCommunication1();
        SumDemo sd = new SumDemo();
        sd.start();
//        sd.join();
        synchronized (sd) {
            sd.wait();
            System.out.println("Is main thread pause for SumDemo Thread to finish??");
            System.out.println(sd.sum);
        }
        System.out.println("this is the end of main...,");
    }

    private synchronized void demoInterThreadCommunication1() throws InterruptedException {
        SumDemo sd = new SumDemo();
        sd.start();
//        sd.join();
        sd.wait();
        System.out.println("Is main thread pause for SumDemo Thread to finish??");
        System.out.println(sd.sum);
    }
}
