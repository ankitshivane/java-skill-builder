package skillbuilder.indepth.sealed_classes;

public class SealedInterfaceDemo {
    public static void main(String[] args) {
        MyInterface1 i = new MyChildCls1();
        i.addNum(23, 22);
    }
}

sealed interface MyInterface1 permits MyChildCls1 {
    void addNum(int n1, int n2);
}

non-sealed class MyChildCls1 implements MyInterface1 {
    @Override
    public void addNum(int n1, int n2) {
        System.out.println("Addition:" + (n1 + n2));
    }
}