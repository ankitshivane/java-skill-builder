package skillbuilder.java8.set1;

import skillbuilder.indepth.sealed_classes.subpkg1.Account;

import java.sql.Struct;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CheckIfStringAnagram {

    public static void main(String[] args) {

        /**
         * Java 8 program to check if two strings are anagrams or not?
         * Concept: Two strings are anagrams if they contain the same characters with the same frequency, regardless of order.
         * Example:
         * listen → silent ✅
         * triangle → integral ✅
         * apple → papel ✅
         * rat → car ❌
         */
        String s1 = "listen";
        String s2 = "silent";
        /**
         * Below three solutions are based on java stream
         */
        System.out.println("Approach 1:->" + isAnagram(s1, s2));
        System.out.println("Approach 2:->" + isAnagramApproach2(s1, s2));
        System.out.println("Approach 3:->" + isAnagramApproach3(s1, s2));

        // Core Java approach
        System.out.println("Approach 4:->" + areAnagrams(s1, s2));//false // core java approach
        System.out.println("Approach 5:->" + approach5(s1, s2));//false // core java approach
        /** OUTPUT
         Approach 1:->true
         Approach 2:->true
         Approach 3:->true
         Approach 4:->true
         Approach 5:->true

         */
    }

    public static boolean areAnagrams(String str1, String str2) {
        // Null or empty string handling
        if (str1 == null || str2 == null) {
            return false;
        }

        // Remove whitespace and convert to lowercase for case-insensitive comparison
        String s1 = str1.replaceAll("\\s", "").toLowerCase();
        String s2 = str2.replaceAll("\\s", "").toLowerCase();

        // If lengths are different, they cannot be anagrams
        if (s1.length() != s2.length()) {
            return false;
        }

        // Convert strings to character arrays
        char[] charArray1 = s1.toCharArray();
        char[] charArray2 = s2.toCharArray();

        // Sort the character arrays
        Arrays.sort(charArray1);
        Arrays.sort(charArray2);
        // Compare the sorted arrays
        return Arrays.equals(charArray1, charArray2);
        /*
        Time Complexity: O(n log n)
        Space: O(n)
         */
    }

    static boolean isAnagram(String s1, String s2) {
        return normalize(s1).equals(normalize(s2));
//         Internal Working:
//        chars() → IntStream of Unicode values
//        sorted() → sorts them
//        mapToObj() → converts back to String
//        joining() → merges into single String
//
//        Pros: Clean and expressive
//        Cons: O(n log n) due to sorting
    }

    private static String normalize(String s) {
        return s.toLowerCase().replaceAll("\\s+", "")
                .chars()
                .sorted()
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.joining());
    }

    static boolean isAnagramApproach2(String s1, String s2) {
        return getFreqCount(s1).equals(getFreqCount(s2));
//        Pros: No sorting (O(n))
//        Cons: Slight overhead of map creation
    }

    //
    private static Map<Character, Long> getFreqCount(String s1) {
        return s1.toLowerCase().replaceAll("\\s+", "")
                .chars()
                .mapToObj(i -> (char) i)
                .collect(Collectors.groupingBy(Function.identity(),
                        Collectors.counting()));
    }

    private static boolean isAnagramApproach3(String s1, String s2) {
        return Arrays.equals(
                getSortedArray(s1),
                getSortedArray(s2)
        );
    }

    private static int[] getSortedArray(String s1) {
        return s1.toLowerCase().replaceAll("\\s+", "")
                .chars()
                .sorted()
                .toArray();
    }

    private static boolean approach5(String s1, String s2) {
        Map<Character, Integer> counter = new LinkedHashMap<>();
        for (char c : s1.toCharArray()) {
            counter.put(c, counter.getOrDefault(c, 0) + 1);
        }
        for (char c : s2.toCharArray()) {
            if (!counter.containsKey(c)) {
                return false;
            }

            counter.put(c, counter.get(c) - 1);
            if (counter.get(c) == 0) {
                counter.remove(c);
            }
        }
        return true;

    }
}
