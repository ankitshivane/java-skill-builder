package skillbuilder.java8.set4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import static java.util.stream.Collectors.*;

public class CollectorsTutorial {
    public static void main(String[] args) {
        List<String> names= Arrays.asList("Ankit", "Radha", "Adwitya", "Sameer", "Govind", "Shyam");
//        toMapTut1(names);
        toListTut1(names);
    }

    private static void toListTut1(List<String> names) {
        // CASE 1: easy as we all know toList();
        List<String> result = names.stream()
                .collect(toList());
        result.add("Arjun");
        System.out.println(result); // OUTPUT: [Ankit, Radha, Adwitya, Sameer, Govind, Shyam, Arjun]

        // CASE 2: toUnmodifiableList();
        List<String> result2 = names.stream()
                .collect(toUnmodifiableList());

//        result2.add("Arjun");
        try {
            result2.add("Arjun");
        } catch (UnsupportedOperationException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(result2);

    }

    private static void toMapTut1(List<String> names) {
        Map<String, Integer> result = names.stream()
                .collect(
                        toMap(
                                Function.identity(), //Function.identity() is just a shortcut for defining a function that accepts and returns the same value, you can also replace with as "n->n"
                                String::length)
                );
        System.out.println(result); // OUTPUT: {Shyam=5, Govind=6, Ankit=5, Radha=5, Adwitya=7, Sameer=6}

        /* Case 2: if you add any duplicate name in the above names input and re-run the program you will get below exception
        -> Duplicate key Ankit (attempted merging values 5 and 5)
        -> toMap() doesn’t even evaluate whether the values are also equal. If it sees duplicate keys, it immediately throws an IllegalStateException.
         */
        List<String> names2= Arrays.asList("Ankit", "Radha", "Adwitya", "Sameer", "Govind", "Shyam","Ankit");
try{
    Map<String, Integer> res = names2.stream().collect(toMap(Function.identity(), String::length));
    System.out.println(res);
}catch(IllegalStateException e){
            System.out.println(e.getMessage()); // OUTPUT: Duplicate key Ankit (attempted merging values 5 and 5)
        }

        // CASE 3: In such cases with key collision, we should use toMap() with another signature:
        Map<String, Integer> result2 = names2.stream()
                .collect(toMap(Function.identity(), String::length, (item, identicalItem) -> item));
        System.out.println(result2); // OUTPUT: {Shyam=5, Govind=6, Ankit=5, Sameer=6, Adwitya=7, Radha=5}
        /*
        The third argument here is a BinaryOperator(), where we can specify how we want to handle collisions.
        In this case, we’ll just pick any of these two colliding values because we know that the same strings will always have the same lengths too.
         */
    }
}
