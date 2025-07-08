package skillbuilder.core.interfaceTut;

public class Demo1 implements interf1, interf2 {
    public static void main(String[] args) {
        System.out.println(interf2.x);
    }

    public void method1() {
        System.out.println("this is method 1");
    }

    public int method1(int y) {
        return 0;
    }
}
