package skillbuilder.indepth.sealed_classes;

public class SealedClsDemo1 {
    public static void main(String[] args) {
        Shape s = new Shape();
        Shape circle = new Circle();
        Shape semiC = new SemiCircle();
        s.printShape();
        circle.printShape();
        semiC.printShape();
    }
}

sealed class Shape permits Circle {
    public void printShape() {
        System.out.println("default");
    }
}

non-sealed class Circle extends Shape {
    @Override
    public void printShape() {
        System.out.println("Circle");
    }
}

class SemiCircle extends Circle {
    @Override
    public void printShape() {
        System.out.println("SemiCircle");
    }
}
