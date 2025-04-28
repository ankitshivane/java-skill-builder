package skillbuilder.indepth.record;

public record Point(int x, int y) {
    public double distanceFromOrigin() {
        return Math.sqrt(x * x + y * y);
    }

    public static void main(String[] args) {
        Point p = new Point(2, 2);
        System.out.println(p.distanceFromOrigin()); //2.8284271247461903
    }
}
