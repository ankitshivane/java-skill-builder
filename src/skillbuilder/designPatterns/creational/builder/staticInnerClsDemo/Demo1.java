package skillbuilder.designPatterns.creational.builder.staticInnerClsDemo;

public class Demo1 {
    public static void main(String[] args) {
        Outer.Inner ob1 = new Outer.Inner();
        ob1.a = 23;
        ob1.str = "ankit";
        ob1.myInnerMemMethod();
        Outer.Inner.myInnerStatMethod();
        Outer.Inner.s = "ankit";
        System.out.println(Outer.Inner.s);
        System.out.println("------------------------------------");
        Outer o1 = new Outer();
        o1.outMemMeth();
        o1.num = 23;
        Outer.outStatMeth();
    }
}
