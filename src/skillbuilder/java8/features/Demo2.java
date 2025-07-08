package skillbuilder.java8.features;

public class Demo2 {
    public static void main(String[] args) {
        Child c = new Child();
        c.m1();
    }
}

interface Interf3 {
    default void m1() {
        System.out.println("Base class m1 method");
    }
}

class Base {
    public void m1() {
        System.out.println("Base class m1 method");
    }
}

class Child extends Base implements Interf3 {

}
