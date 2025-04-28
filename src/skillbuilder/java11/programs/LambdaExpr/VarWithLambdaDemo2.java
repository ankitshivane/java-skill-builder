package skillbuilder.java11.programs.LambdaExpr;

interface FuncInterface2 {
    void printName(String name);
}

interface FuncInterface3 {
    void printNumber(int num);
}

public class VarWithLambdaDemo2 {
    public static void main(String[] args) {
        FuncInterface2 fi = (var name) -> System.out.println(name);
        fi.printName("Ankit");
        FuncInterface3 fi2 = (var i) -> System.out.println(i);
        fi2.printNumber(29);
        /*
        OUTPUT:
        Ankit
        29
         */
    }
}
