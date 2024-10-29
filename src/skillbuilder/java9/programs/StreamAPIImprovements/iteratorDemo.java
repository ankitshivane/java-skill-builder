package skillbuilder.java9.programs.StreamAPIImprovements;

import java.util.stream.Stream;

public class iteratorDemo {
    public static void main(String[] args) {
        // below one is the old iterate() method as you can see if you removed limit() intermediate method then it will generate
        // an infinite numbers and wont stop so here with limit(10) we are saying to print only 10 numbers
        Stream.iterate(1, x -> x + 5).limit(10).forEach(System.out::println);

        // and here due to improvement and new method we can specify the condition to print the numbers
        Stream.iterate(1, x -> x <= 5, x -> x + 1).forEach(System.out::println);
        /*
        NOTE: as you can see it has initialized with 1 and then incremented every time until condition is false
        OUTPUT:
        1
        2
        3
        4
        5
         */
    }
}
