package skillbuilder.designPatterns.creational.singleton.cloningBreak;

public class Demo2Fix {
    public static void main(String[] args) throws CloneNotSupportedException {
        Singleton1 s1 = Singleton1.getInstance();
        Singleton1 s2 = (Singleton1) s1.clone();

        System.out.println(s1 == s2); // true , In case:1
        /*
If we throw error in clone method then we will get below output
OUTPUT:

Exception in thread "main" java.lang.CloneNotSupportedException: Cloning not supported
	at skillbuilder.designPatterns.creational.singleton.cloningBreak.Singleton1.clone(Demo2Fix.java:35)
	at skillbuilder.designPatterns.creational.singleton.cloningBreak.Demo2Fix.main(Demo2Fix.java:6)

         */


    }
}

class Singleton1 implements Cloneable {
    private static final Singleton1 INSTANCE = new Singleton1();

    private Singleton1() {
    }

    public static Singleton1 getInstance() {
        return INSTANCE;
    }

    /*@Override
    protected Object clone() throws CloneNotSupportedException {
        // Either return the same instance in clone method
        return INSTANCE;

    }*/

    // OR
    // Throw an error to prevent cloning of singleton class
    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Cloning not supported");
    }


}
