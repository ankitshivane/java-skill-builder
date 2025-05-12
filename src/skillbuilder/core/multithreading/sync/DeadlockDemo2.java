package skillbuilder.core.multithreading.sync;

public class DeadlockDemo2 {
    /**
     * Note : If we remove atleast one syncronized keywoed then we won't get
     * DeadLOck.Hence syncronized keyword in the only reason for DeadLock due to this
     * while using syncronized keyword we have to handling carefully.
     */
    public static void main(String[] args) {
        new Deadlock();//main thread
    }
}

class A {
    public synchronized void foo(B b) {
        System.out.println("Thread-0 starts execution of foo() method.");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Thread-0 trying to call B class b.last() method.");
        b.last();
    }

    public synchronized void last() {
        System.out.println("Inside A, this is last() method...");
    }

    public void normalMethodOfA() {
        System.out.println("Inside A class, normal method..");
    }

    public static synchronized void normalStaticMethodOfA() {
        System.out.println("Inside A class, normal static method..");
    }
}

class B {
    public synchronized void bar(A a) {
        System.out.println("Thread-1 starts execution of bar() method");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
        System.out.println("Thread-1 trying to call A class a.last() method");
        a.last();
    }

    public synchronized void last() {
        System.out.println("Inside B, this is last() method...");
    }
}

class Deadlock implements Runnable {
    B b = new B();
    A a = new A();

    public Deadlock() {
        Thread t = new Thread(this);
        t.start();
        a.foo(b);//main thread
        a.normalMethodOfA();
        A.normalStaticMethodOfA();
    }

    @Override
    public void run() {
        b.bar(a);//child thread
    }
}
/*
OUTPUT:
Thread-0 starts execution of foo() method.
Thread-1 starts execution of bar() method
Thread-0 trying to call B class b.last() method.
Thread-1 trying to call A class a.last() method
 */