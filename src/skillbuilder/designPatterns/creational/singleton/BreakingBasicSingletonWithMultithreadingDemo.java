package skillbuilder.designPatterns.creational.singleton;

public class BreakingBasicSingletonWithMultithreadingDemo {
    public static void main(String[] args) {
        Thread t1=new Thread(()->{
            BreakingBasicSingletonWithMultithreading instance=BreakingBasicSingletonWithMultithreading.getInstance();
        });
        Thread t2=new Thread(()->{
            BreakingBasicSingletonWithMultithreading instance=BreakingBasicSingletonWithMultithreading.getInstance();
        });
        t1.start();
        t2.start();
    }
}


class BreakingBasicSingletonWithMultithreading{
    private static BreakingBasicSingletonWithMultithreading INSTANCE;
    private BreakingBasicSingletonWithMultithreading(){
        System.out.println("Inside constructor of BreakingBasicSingletonWithMultithreading, Thread:"+Thread.currentThread().getName());
    }

    public static BreakingBasicSingletonWithMultithreading getInstance() {
        if (INSTANCE == null) {
            System.out.println("getInstance() method called by, Thread:"+Thread.currentThread().getName());
            INSTANCE = new BreakingBasicSingletonWithMultithreading();
        }
        return INSTANCE;
    }
}
/**
 *  OUTPUT Explanation: as you can see in below code both threads was able to call the getInstance method and create the instance

 getInstance() method called by, Thread:Thread-0
 Inside constructor of BreakingBasicSingletonWithMultithreading, Thread:Thread-0
 getInstance() method called by, Thread:Thread-1
 Inside constructor of BreakingBasicSingletonWithMultithreading, Thread:Thread-1

 */

