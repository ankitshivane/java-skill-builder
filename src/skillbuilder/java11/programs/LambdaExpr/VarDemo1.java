package skillbuilder.java11.programs.LambdaExpr;

public class VarDemo1 {
    public static void main(String[] args) {
        // CASE:1 valid
        Calculator c1 = (var i, var j) -> i + j;
        System.out.println(c1.add(10, 20));

        //CASE:2 invalid declaration 1, we will get compilation type error
        /*
        Calculator c2=(var i, int j) -> i+j;
        */
        // Invalid declaration 2, we will get compilation type error
//        Calculator c3 = (var i, j) -> i + j;
    }
}
