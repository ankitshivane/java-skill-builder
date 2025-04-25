package skillbuilder.java11.programs.CollectionsToArray;

import java.util.List;
import java.util.function.IntFunction;

public class ToArrayExample {
    public static void main(String[] args) {
        List<String> names = List.of("Alice", "Bob", "Charlie");

        // Old way (unsafe)
        Object[] arr1 = names.toArray();

        // Java 11 way (safe and clean)
        String[] arr2 = names.toArray(String[]::new);

        /*
        Its equivalent to saying
        names.toArray(size -> new String[size]);

        But using method reference (String[]::new) is cleaner and more readable.
        OR
        IntFunction<String[]> aak = size -> new String[size];
        names.toArray(aak);
         */

        for (String name : arr2) {
            System.out.println(name);
        }
        /**
         * OUTPUT:
         Alice
         Bob
         Charlie
         */
    }
}
