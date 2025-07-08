package skillbuilder.core.interfaceTut;

public class Child1 extends Parent1 {
    public Child1() {
        System.out.println("Child1 constructor called..");
    }

    public static void main(String[] args) {
        Child1 c1 = new Child1();
        System.out.println(c1.p1);
    }
}

class Parent1 {
    int p1;

    public Parent1() {
        System.out.println("Parent1 constructor called..");
    }
}
