package skillbuilder.designPatterns.creational.singleton;

public class LayInitDrawbackDemo {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            LazyInitSingCls instance = LazyInitSingCls.getInstance();
//            LazyInitSingCls instanceSync = LazyInitSingCls.getInstanceSync(); // Uncomment this line and comment above line to know how Lazy singleton pattern works in multi thread environment
        });

        Thread t2 = new Thread(() -> {
            LazyInitSingCls instance = LazyInitSingCls.getInstance();
//            LazyInitSingCls instanceSync = LazyInitSingCls.getInstanceSync(); // Uncomment this line and comment above line to know how Lazy singleton pattern works in multi thread environment
        });

        t1.start();
        t2.start();
    }
}

class LazyInitSingCls {
    private static LazyInitSingCls instance;

    private LazyInitSingCls() {
        System.out.println("Constructor called by " + Thread.currentThread().getName() + " thread.");
    }

    public static LazyInitSingCls getInstance() {
        System.out.println("Inside getInstance method called by " + Thread.currentThread().getName());
        if (instance == null) {
            instance = new LazyInitSingCls();
        }
        return instance;
    }

    // Version:2 of getInstance method with synchronized keyword.
    public static synchronized LazyInitSingCls getInstanceSync() {
        System.out.println("Inside getInstance method called by " + Thread.currentThread().getName());
        if (instance == null) {
            instance = new LazyInitSingCls();
        }
        return instance;
    }
}
/**
 * as You can see here without use of synchronized keyword two threads got access to the getInstance method where
 * the object is not created yet so both the threads created the Java Objects.
 * Two times constructor got called, means multiple Threads multiple objects creation breaking the singleton.
 * <p>
 * Output:
 * <p>
 * Inside getInstance method called by Thread-0
 * Inside getInstance method called by Thread-1
 * Constructor called by Thread-0 thread.
 * Constructor called by Thread-1 thread.
 */

/// /
/*
With synchronized keyword
as you can see below with synchronized keyword you can see constructor got called only one time.
getInstanceSync method called 2 times but only one object created.
OUTPUT:

Inside getInstance method called by Thread-1
Constructor called by Thread-1 thread.
Inside getInstance method called by Thread-0
 */