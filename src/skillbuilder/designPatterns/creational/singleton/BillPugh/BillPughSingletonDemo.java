package skillbuilder.designPatterns.creational.singleton.BillPugh;

public class BillPughSingletonDemo {
    public static void main(String[] args) {
        Thread t1 = new Thread(Singleton::getInstance, "Thread-1");
        Thread t2 = new Thread(Singleton::getInstance, "Thread-2");
        t1.start();
        t2.start();
    }
}

class Singleton {

    private Singleton() {
        System.out.println("Constructor called By " + Thread.currentThread().getName());
    }

    static {
        System.out.println("Singleton class loading into memory...");
    }

    private static class Holder {
        static {
            System.out.println("Holder class loaded in memory...");
        }

        private static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance() {
        return Holder.INSTANCE;
//        return null; // if we uncomment this line and comment above line then output will be as "Singleton class loading into memory..."
        // here we can see that if we are not using static inner class so its not getting loaded into the memory.
    }
}
/*
Explanation: as you can see in the given output here first our singleton class got loaded, then as getInstance() method is called
so Holder class is loaded as we have used "Holder.INSTANCE" reference inside it.  then only one object is created even if its called two different threads.

OUTPUT:
Singleton class loading into memory...
Holder class loaded in memory...
Constructor called By Thread-1
 */
