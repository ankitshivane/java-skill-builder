package skillbuilder.java9.programs.StreamAPIImprovements;

import java.util.List;

public class TakeWhileDemo {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(2, 4, 4, 6, 5, 9, 7, 8);
        numbers.stream().takeWhile(i -> i % 2 == 0).forEach(System.out::println);
        /*
        NOTE:as you can see that as the condition is false from element 5 so it has discarded all the element onwards it.
        OUTPUT:
        2
        4
        4
        6
         */
    }
}
