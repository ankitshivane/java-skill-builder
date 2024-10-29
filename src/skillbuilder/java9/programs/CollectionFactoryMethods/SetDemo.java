package skillbuilder.java9.programs.CollectionFactoryMethods;

import java.util.Set;

public class SetDemo {
    public static void main(String[] args) {
        //CASE-1: empty set
        Set<Integer> s=Set.of();
//        s.add(2); // as we have created immutable/un-modifiable set object if we un-comment this line we will get exception as java.lang.UnsupportedOperationException
        System.out.println(s);

        //CASE-2: creating non-empty set object now
        Set<Integer> ne=Set.of(1,2,3,4,5,6,7,8);
        System.out.println(ne); // it will work fine and give the output as [8, 7, 6, 5, 4, 3, 2, 1]

        //CASE-2: adding duplicate element to the set while creating which is not allowed as it is a immutable object hence if
        // we try to add any duplicate element to this object then it will internally try to modify the set so hence it will throw runtime exception
        Set<Integer> set=Set.of(1,2,3,4,5,6,5);
        System.out.println(set); //output: java.lang.IllegalArgumentException: duplicate element: 5

    }
}
