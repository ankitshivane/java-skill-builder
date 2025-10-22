package skillbuilder.java8.set1;

import java.util.*;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Problem: Find the first non-repeated character in a string.
 * <p>
 * Demonstrates:
 * - Stream-based approach using groupingBy and LinkedHashMap
 * - Two Core Java (imperative) approaches
 * <p>
 * Example:
 * Input  : "stress"
 * Output : First non-repeated character = t
 */
public class FirstNonRepeatedCharacter {

    public static void main(String[] args) {
        String inputString = "aabbc".replaceAll("\\s+", "").toLowerCase();

        System.out.println("===== Java 8 Stream Approach 1 =====");
        streamApproach(inputString);

        System.out.println("===== Java 8 Stream Approach 2 =====");
        streamApproach2(inputString);

        System.out.println("\n===== Core Java Approach 1 (Nested Loop) =====");
        coreJavaApproach1(inputString);

        System.out.println("\n===== Core Java Approach 2 (LinkedHashMap Counter) =====");
        coreJavaApproach2(inputString);

        System.out.println("\n===== Core Java Approach 3 (int array freq counter) =====");
        coreJavaApproach3(inputString);

        /** OUTPUT:
         ===== Java 8 Stream Approach 1 =====
         First non-repeated (stream) = c
         ===== Java 8 Stream Approach 2 =====
         First non-repeated (stream) = c

         ===== Core Java Approach 1 (Nested Loop) =====
         First non-repeated (core approach 1) = c

         ===== Core Java Approach 2 (LinkedHashMap Counter) =====
         First non-repeated (core approach 2) = c

         ===== Core Java Approach 3 (int array freq counter) =====
         First non-repeated (core approach 3) = c
         */
    }

    /**
     * Approach 1: Using Java 8 Streams
     * - Uses groupingBy(Function.identity()) to count characters
     * - LinkedHashMap preserves insertion order
     */
    private static void streamApproach(String input) {
        LinkedHashMap<String, Long> characterCountMap = Arrays.stream(input.split(""))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));

        characterCountMap.entrySet().stream()
                .filter(entry -> entry.getValue() == 1)
                .findFirst()
                .ifPresentOrElse(
                        entry -> System.out.println("First non-repeated (stream) = " + entry.getKey()),
                        () -> System.out.println("No non-repeated character found.")
                );
    }

    private static void streamApproach2(String input) {
        List<Character> chars = input.chars()
                .mapToObj(c -> (char) c)
                .toList();

        chars.stream()
                .filter(x -> Collections.frequency(chars, x) == 1)
                .findFirst()
                .ifPresentOrElse(c -> System.out.println("First non-repeated (stream) = " + c),
                        () -> System.out.println("No non-repeated character found.")
                );
    }

    /**
     * Approach 2: Core Java (Nested Loop)
     * - Checks each character against all others
     * - Time complexity: O(n²)
     */
    private static void coreJavaApproach1(String input) {
        char[] chars = input.toCharArray();
        boolean found = false;

        for (int i = 0; i < chars.length; i++) {
            boolean repeated = false;
            for (int j = 0; j < chars.length; j++) {
                if (i != j && chars[i] == chars[j]) {
                    repeated = true;
                    break;
                }
            }
            if (!repeated) {
                System.out.println("First non-repeated (core approach 1) = " + chars[i]);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("No non-repeated character found.");
        }
    }

    /**
     * Approach 3: Core Java (LinkedHashMap Counter)
     * - Counts frequency of each character
     * - Preserves order of insertion using LinkedHashMap
     * - Time complexity: O(n)
     */
    private static void coreJavaApproach2(String input) {
        Map<Character, Integer> counter = new LinkedHashMap<>();

        for (char c : input.toCharArray()) {
            counter.put(c, counter.getOrDefault(c, 0) + 1);
        }

        for (Entry<Character, Integer> entry : counter.entrySet()) {
            if (entry.getValue() == 1) {
                System.out.println("First non-repeated (core approach 2) = " + entry.getKey());
                return;
            }
        }

        System.out.println("No non-repeated character found.");
    }

    private static void coreJavaApproach3(String input) {
        int[] freq = new int[256];// ASCII characters
        for (char c : input.toCharArray()) {
            freq[c]++;
        }
        for (char c : input.toCharArray()) {
            if (freq[c] == 1) {
                System.out.println("First non-repeated (core approach 3) = " + c);
            }
        }
        /**
         * Very fast (pure O(n)), minimal overhead.
         * Cons: Works only for limited character sets (ASCII).
         */
    }
}
