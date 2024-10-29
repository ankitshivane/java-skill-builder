package skillbuilder.java9.programs.CollectionFactoryMethods;

import java.util.Map;

public class MapDemo {
    public static void main(String[] args) {
        // CASE:1 creating empty immutable object
        Map<Integer, String> mp1 = Map.of();

        // CASE:2 creating non-empty map object
        Map<Integer, String> mp = Map.of(1, "key-1", 2, "key-2", 3, "key-3");
        System.out.println(mp); //Output: {1=key-1, 2=key-2, 3=key-3}
        //NOTE: the key should be unique if we try to add any duplicate element key entry to this obj we will get runtime exception as java.lang.IllegalArgumentException: duplicate key: 2
    }
}
