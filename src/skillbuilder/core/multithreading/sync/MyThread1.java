package skillbuilder.core.multithreading.sync;

import skillbuilder.core.multithreading.MyThread2;

public class MyThread1 {
    public void display() {
//        for (int i = 0; i < 21; i++) {
            System.out.println("Inside display");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
//        }
    }

    public static void main(String[] args) {
        MyThread1 obj = new MyThread1();
        Thread t1=new Thread(obj::display);
//        t1.display();
        t1.start();
        Thread t2=new Thread(obj::display);
//        t1.display();
        t2.start();

    }
}
