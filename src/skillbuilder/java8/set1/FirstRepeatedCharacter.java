package skillbuilder.java8.set1;

import java.util.*;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstRepeatedCharacter {

    /**
     * Find first repeated character in a string?
     */
    public static void main(String[] args) {
        String input = "Java Concept Of The Day".replaceAll("\\s+", "").toLowerCase();

        System.out.println("===== Java 8 Stream Approach 1 =====");
        streamApproach1(input);

        System.out.println("===== Java 8 Stream Approach 2 =====");
        streamApproach2(input);


        System.out.println("\n===== Core Java Approach 1 =====");
        coreJavaApproach1(input);

    }

    private static void streamApproach1(String input) {
        Map<Character, Long> counter =
                input.chars()
                        .mapToObj(c -> (char) c)
                        .collect(
                                Collectors.groupingBy(Function.identity(),
                                        LinkedHashMap::new,
                                        Collectors.counting())
                        );

        counter.entrySet()
                .stream()
                .filter(x -> x.getValue() > 1)
                .limit(1)
                .forEach(x -> System.out.println("First repeated character = " + x.getKey()));
    }

    private static void streamApproach2(String input) {

        Set<String> storeDupliData = new HashSet<>();
        String repeatedData = Arrays.stream(input.split("")).filter(i -> !storeDupliData.add(i)).findFirst()
                .get();
        System.out.println("First repeated character = " + repeatedData);
    }

    private static void coreJavaApproach1(String input) {
        int[] freq = new int[256];
        for (char c : input.toCharArray()) {
            freq[c]++;
        }

        for (char c : input.toCharArray()) {
            if (freq[c] > 1) {
                System.out.println("First repeated character = " + c);
                break;
            }
        }

    }
}
