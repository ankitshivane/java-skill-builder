package skillbuilder.java10.programs.ImmutableCollections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListDemo {
    public static void main(String[] args) {
        // Old approach of creating immutable collections
        List<Integer> n1 = new ArrayList<>();
        n1.add(12);
        n1.add(132);
        n1.add(122);
        System.out.println("Mutable collection"+n1);

        List<Integer> unmodifiableList = Collections.unmodifiableList(n1);
        System.out.println("Immutable Collection"+unmodifiableList);
//        unmodifiableList.add(33);  // as this is a unmodifiable list we can not modify the structure of it,
//        uncomment and run the program to see RuntimeException as "java.lang.UnsupportedOperationException"
//        System.out.println(unmodifiableList);

        ////// new Java10 approach of copyOf method
        newApproachForCreatingImmutableCol();
    }

    public static void newApproachForCreatingImmutableCol() {
        List<Integer> n1 = new ArrayList<>();
        n1.add(1);
        n1.add(2);
        n1.add(3);
        System.out.println("Mutable List: "+n1);

        List<Integer> immutableList = List.copyOf(n1);
        System.out.println("Immutable List:"+immutableList);
//        immutableList.add(22); // Invalid if uncomment will get this java.lang.UnsupportedOperationException Exception as this is a immutable list
//        System.out.println(immutableList);

        /*
        OUTPUT:
        Mutable collection[12, 132, 122]
        Immutable Collection[12, 132, 122]
        Mutable List: [1, 2, 3]
        Immutable List:[1, 2, 3]
         */
    }
}
