package skillbuilder.java8.set1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CommonElementsInArr {
    /*
     * How do you find common elements between two arrays?
     */
    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(71, 21, 34, 89, 56, 28);

        List<Integer> list2 = Arrays.asList(12, 56, 17, 21, 94, 34);
        approach1(list1, list2);

        int[] arr1 = new int[]{71, 21, 34, 89, 56, 28};

        int[] arr2 = new int[]{12, 56, 17, 21, 94, 34};
        approach2(arr1, arr2);
        approach3(arr1, arr2);
        approach4(list1, list2);
        //Core Java / DSA Approaches
        approach5(arr1, arr2);
        /*
         * output:
         * [21, 34, 56]
         * [21, 34, 56]

         */
    }

    private static void approach1(List<Integer> list1, List<Integer> list2) {
        // using lambda expre
        List<Integer> commonElements1 = list1.stream().filter(i -> list2.contains(i)).collect(Collectors.toList());
        System.out.println(commonElements1);

        // using method reference
        List<Integer> commonElements2 = list1.stream().filter(list2::contains).collect(Collectors.toList());
        System.out.println(commonElements2);
    }

    private static void approach2(int[] a1, int[] a2) {
        List<Integer> op = Arrays.stream(a1)
                .filter(x -> Arrays.stream(a2).anyMatch(y -> x == y))
                .boxed()
                .toList();
        System.out.println("Approach 2:->" + op);
        /**
         Explanation:
         Arrays.stream(arr1) → IntStream of elements
         .filter(x -> Arrays.stream(arr2).anyMatch(y -> y == x)) → keeps only those in arr2
         .boxed() → converts to Stream<Integer>
         .collect() → collects into a list

         Pros: Short and declarative
         Cons: O(n²) because anyMatch() iterates through arr2 for each element in arr1.
         */
    }

    private static void approach3(int[] a1, int[] a2) {
        Set<Integer> uniqueA2 = Arrays.stream(a2).boxed().collect(Collectors.toSet());
        List<Integer> op = Arrays.stream(a1).filter(uniqueA2::contains).boxed().toList();
        System.out.println("Approach 3:->" + op);
        /**
         Explanation:
         Set lookups are O(1), so this is O(n).
         Much faster than nested iteration.

         Pros: Efficient, simple
         Cons: Creates an extra set (O(n) memory)
         */
    }

    private static void approach4(List<Integer> list1, List<Integer> list2) {

        List<Integer> common = new ArrayList<>(list1);
        common.retainAll(list2);
        System.out.println("Approach 4:->" + common);
        /**
         retainAll() keeps only the elements that are also contained in the other list.
         */
    }

    private static void approach5(int[] a1, int[] a2) {
        List<Integer> op = new ArrayList<>();
        for (int i = 0; i < a1.length; i++) {
            for (int j = 0; j < a2.length; j++) {
                if (a1[i] == a2[j]) {
                    op.add(a1[i]);
                }
            }
        }
        System.out.println("Approach 5:->" + op);
        /**
         Complexity:
         Time: O(n²)
         Space: O(1)

         Pros: Very easy to understand
         Cons: Not efficient for large arrays
         */
    }

}
