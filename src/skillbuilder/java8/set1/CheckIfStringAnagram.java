package skillbuilder.java8.set1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CheckIfStringAnagram {

    public static void main(String[] args) {

        /*
         * Java 8 program to check if two strings are anagrams or not?
         */
        String s1 = "RaceCkar";
        String s2 = "CarRace";
        approach1(s1, s2);
        System.out.println(areAnagrams(s1, s2));//false // core java approach
    }

    private static void approach1(String s1, String s2) {
        //get sorted string using approach 1
        String s1Modified = s1.chars().mapToObj(i -> (char) i).sorted(Comparator.naturalOrder()).map(String::valueOf)
                .collect(Collectors.joining());
        System.out.println("S1 after sorting:" + s1Modified);
        //get sorted string using approach 2
        String s2Approach2 = Stream.of(s2.split("")).sorted().peek(i -> System.out.print(i))
                .collect(Collectors.joining());
        System.out.println();
        if (s1Modified.equalsIgnoreCase(s2Approach2)) {
            System.out.println("Both are anagram of each other");
        } else {
            System.out.println("Not an anagram");
        }
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
    }

}
