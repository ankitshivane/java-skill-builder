package skillbuilder.java11.programs.PredicateNot;

import java.util.function.Predicate;

public class PredicateNotDemo {
    public static void main(String[] args) {
        int num = 23;
        Predicate<Integer> checkIsEven = (number) -> number % 2 == 0;
        System.out.println("does " + num + " is even:" + checkIsEven.test(num));

        // Demo Not Method
        Predicate<Integer> isOdd = Predicate.not(checkIsEven);
        System.out.println("does " + num + " is odd:" + isOdd.test(num));
    }
}
