package skillbuilder.java11.programs.LambdaExpr;

public class VarDemo1 {
    public static void main(String[] args) {
        Calculator c1 = (var i, var j) -> i + j;
        System.out.println(c1.add(10, 20));
    }
}
