package skillbuilder.java9.programs.StreamAPIImprovements;

import java.util.List;

public class DropWhileDemo {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(2, 4, 4, 6, 5, 9, 7, 8);
        numbers.stream().dropWhile(i -> i % 2 == 0).forEach(i -> System.out.print(i + " "));
        /*
        NOTE: as you can see below output dropWhile ignored all the numbers until the predicate returns true and as soon as the
         condition is false it has returned all the rest of the element without executing the predicate condition.
        OUTPUT:
        5 9 7 8
         */
    }
}
