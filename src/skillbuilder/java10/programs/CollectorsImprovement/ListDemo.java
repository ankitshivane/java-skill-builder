package skillbuilder.java10.programs.CollectorsImprovement;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ListDemo {
    public static void main(String[] args) {
        List<Integer> l = new ArrayList<Integer>();
        l.add(22);
        l.add(23);
        l.add(24);
        System.out.println(l);

        List<Integer> immutableList = l.stream().filter(i -> i % 2 == 0).collect(Collectors.toUnmodifiableList());
        System.out.println(immutableList);
        immutableList.add(34); // Invalid as the list is now immutable and if we try to modify it then we will get below error java.lang.UnsupportedOperationException
        System.out.println(immutableList);
    }
}
