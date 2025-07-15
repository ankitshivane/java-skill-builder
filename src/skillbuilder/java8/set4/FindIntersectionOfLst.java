package skillbuilder.java8.set4;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FindIntersectionOfLst {
    /**
     * Find Intersection of Two Lists
     * Find elements that are common to both lists.
     */
    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> list2 = Arrays.asList(3, 4, 5, 6, 7);
        Set<Integer> commonElement = list1.stream().distinct().filter(list2::contains).collect(Collectors.toSet());
        System.out.println(commonElement); // OUTPUT: [3, 4, 5]
    }
}
