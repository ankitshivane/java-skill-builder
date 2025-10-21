package skillbuilder.java8.set1;

import java.util.*;
import java.util.function.DoubleToIntFunction;
import java.util.stream.Collectors;

public class ExtractDuplicateElement {

    /*
     * How do you extract duplicate elements from an array?
     */

    public static void main(String[] args) {

        int[] arr = {111, 222, 333, 111, 555, 333, 111, 111, 777, 222};
        // Below solutions are based on java streams
        approach1(arr);
        approach2(arr);
        approach3(arr);
        // Below sollution is using core or DSA
        approach4(arr);
        /**
         output:[333, 222, 111]
         output:[333, 222, 111]
         Output:[111, 222, 333]
         */

    }

    private static void approach1(int[] arr) {
        Set<Integer> uniqueElement = new HashSet<>();
        Set<Integer> duplicatedElement = Arrays.stream(arr)
                .filter(i -> !uniqueElement.add(i))// add returns false if already present
                .boxed()
                .collect(Collectors.toSet());
        System.out.println("output:" + duplicatedElement);
        /**
         * Note:
         * When add() returns false, it means element was already present → duplicate.
         */
    }

    /**
     * Group elements by their value, count occurrences, and filter those with count > 1.
     *
     * @param arr
     */
    private static void approach2(int[] arr) {
        List<Integer> duplicatedElement = Arrays.stream(arr).boxed()
                .collect(Collectors.groupingBy(i -> i, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(i -> i.getValue() > 1)
//                .mapToInt(i -> i.getKey().intValue()).boxed().toList() // YOU CAN USE THIS OR BELOW SOL.
                .map(Map.Entry::getKey) // IF you use this line then this directly returns the Stream<Integer> and not int so it eliminates the need to use .boxed() as shown above
                .toList();
        System.out.println("output:" + duplicatedElement);
    }

    private static void approach3(int[] arr) {
        List<Integer> list = Arrays.stream(arr).boxed().toList();
        List<Integer> op = Arrays.stream(arr)
                .filter(x -> Collections.frequency(list, x) > 1)
                .distinct()
                .boxed()
                .toList();
        System.out.println("Output:" + op);
        /**
         * Collections.frequency(list, i) returns number of occurrences of i.
         * We filter those > 1 and call distinct() to remove repeats.
         *
         * Pros: Simple, readable
         * Cons: O(n²) — not suitable for large data sets.
         */
    }

    private static void approach4(int[] arr) {
        Arrays.sort(arr);
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < arr.length; i++) {
//            if (arr[i] == arr[i - 1] && !list.contains(arr[i])) { // Use this simple solution .contains() method or if its not allowed to use then use below programming based
            if (arr[i] == arr[i - 1] && (list.isEmpty() || list.get(list.size() - 1) != arr[i])) // here list also start from 0 index so by doing size-1 we get the recently added element
                list.add(arr[i]);
        }
        System.out.println("Output:" + list);
    }
}

