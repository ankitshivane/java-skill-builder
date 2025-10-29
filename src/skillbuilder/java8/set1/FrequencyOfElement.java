package skillbuilder.java8.set1;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FrequencyOfElement {
    /*
     * How do you find frequency of each element in an array or a list?
     *
     */
    public static void main(String[] args) {
        List<String> stationeryList = Arrays.asList("Pen", "Eraser", "Note Book", "Pen", "Pencil", "Stapler",
                "Note Book", "Pencil");

        streamApproach1(stationeryList);
        streamApproach2(stationeryList);

        coreJavaApproach1(stationeryList);
        coreJavaApproach2(stationeryList);
//        Map<String, Long> collect = stationeryList.stream()
//                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
//        collect.entrySet().stream().forEach(i -> {
//            System.out.println("Key:" + i.getKey() + "->" + "count:" + i.getValue());
//        });
        /**
         * OUTPUT:
         Key:Pen->count:2
         Key:Stapler->count:1
         Key:Pencil->count:2
         Key:Note Book->count:2
         Key:Eraser->count:1
         */
    }

    private static void streamApproach1(List<String> stationeryList) {
        Map<String, Long> groupedStationary = stationeryList.stream().collect(
                Collectors.groupingBy(c -> c, Collectors.counting())
        );
        groupedStationary.forEach((key, value) -> System.out.println("Key:" + key + ", count:" + value));
    }

    private static void streamApproach2(List<String> stationeryList) {
        Map<String, Integer> groupedStationary = stationeryList.stream().collect(
                Collectors.toMap(k -> k,
                        v -> 1,  // value = 1 (each occurrence adds one)
                        Integer::sum)  // merge function = sum the counts
        );
        groupedStationary.forEach((key, value) -> System.out.println("Key:" + key + ", count:" + value));
        /**
         Explanation:
         - Each number initially maps to 1.
         - If duplicate key occurs, merge with Integer::sum (i.e., count++).
         Pros: Compact, shows deeper understanding of collectors.
         Cons: Doesn’t preserve order by default.
         */
    }

    private static void coreJavaApproach1(List<String> stationeryList) {
        Map<String, Integer> counter = new LinkedHashMap<>();
        for (String s : stationeryList) {
            counter.put(s, counter.getOrDefault(s, 0) + 1);
        }
        for (Map.Entry<String, Integer> entry : counter.entrySet()) {
            System.out.println("Key:" + entry.getKey() + ", Count:" + entry.getValue());
        }
        /**
         * OUTPUT:
         Key:Pen, Count:2
         Key:Eraser, Count:1
         Key:Note Book, Count:2
         Key:Pencil, Count:2
         Key:Stapler, Count:1
         */
    }

    private static void coreJavaApproach2(List<String> stationeryList) {
        Map<String, Integer> counter = new LinkedHashMap<>(); // LinkedHashMap if you want to preserve order
        for (String s : stationeryList) {
            counter.put(s, Collections.frequency(stationeryList, s));
        }
        stationeryList.stream().map(v -> Collections.frequency(stationeryList, v));
        for (Map.Entry<String, Integer> entry : counter.entrySet()) {
            System.out.println("Key:" + entry.getKey() + ", Count:" + entry.getValue());
        }
        /**
         * OUTPUT:
         Key:Pen, Count:2
         Key:Eraser, Count:1
         Key:Note Book, Count:2
         Key:Pencil, Count:2
         Key:Stapler, Count:1
         */
    }
}
