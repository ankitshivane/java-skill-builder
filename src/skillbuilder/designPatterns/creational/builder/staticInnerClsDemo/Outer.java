package skillbuilder.designPatterns.creational.builder.staticInnerClsDemo;

public class Outer {
    static class Inner {
        int a;
        String str;
        static String s="name";
        public void myInnerMemMethod() {
            System.out.println("static inner class member method, str:" + str);
        }

        public static void myInnerStatMethod() {
            System.out.println("static inner class static method");
        }
    }

    int num;

    public void outMemMeth() {
        System.out.println("outer class member method");
    }

    public static void outStatMeth() {
        System.out.println("outer class static meth");
    }
}
