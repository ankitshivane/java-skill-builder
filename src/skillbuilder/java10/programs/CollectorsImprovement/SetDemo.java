package skillbuilder.java10.programs.CollectorsImprovement;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class SetDemo {
    public static void main(String[] args) {
        Set<Integer> l = new HashSet<>();
        l.add(22);
        l.add(23);
        l.add(24);
        System.out.println(l);

        Set<Integer> immutableList = l.stream().filter(i -> i % 2 == 0).collect(Collectors.toUnmodifiableSet());
        System.out.println(immutableList);
        immutableList.add(34); // Invalid as the set is now immutable and if we try to modify it then we will get below error java.lang.UnsupportedOperationException
        System.out.println(immutableList);
    }
}
