package skillbuilder.java8.features;

public class DemoInterf  {
    public static void main(String[] args) {
        C c=new C();
        c.show();
    }
}

interface A {
    default void show() {
        System.out.println("A's show");
    }
}

interface B {
    default void show() {
        System.out.println("B's show");
    }
}

class C implements A, B {
    @Override
    public void show() {
        System.out.println("C's show");
        A.super.show(); // Call A's version
        B.super.show(); // Call B's version
    }
}
