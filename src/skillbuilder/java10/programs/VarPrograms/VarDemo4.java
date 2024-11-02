package skillbuilder.java10.programs.VarPrograms;

import java.util.function.Function;
import java.util.function.Predicate;

public class VarDemo4 {
    public static void main(String[] args) {
        // Up to Java9 version
        Predicate<Integer> p = n -> n < 10;
        System.out.println(p.test(5));
        System.out.println(p.test(15));
        //CASE: 1
        // Java 10 version
        // var p1 = n -> n < 10; //--->Error this is not allowed


        // CASE:2
        Function<Integer, Integer> f = n -> {
            var k = n * n;
            return k;
        };

        System.out.println(f.apply(4));

        // CASE: 3
        var();
    }

    public static void var() {
        System.out.println("this is var name method");
    }

    //CASE: 4
    {
        var k = 23;
    }

    static {
        var l = 24;
    }
}
