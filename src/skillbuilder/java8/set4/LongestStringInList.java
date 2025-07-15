package skillbuilder.java8.set4;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class LongestStringInList {
    /**
     * Find the longest string in a list using streams.
     */
    public static void main(String[] args) {
        List<String> words = Arrays.asList("java", "stream", "lambda", "API", "functionalinterface");
        findLongestStr1(words); //functionalinterface
        findLongestStr2(words);
        findLongestStr3(words);
    }

    private static void findLongestStr1(List<String> words) {
//        finds the maximum element according to the comparator — in this case, the longest string.
//        Comparator tells the stream to compare strings based on their length
        Optional<String> longest = words.stream()
                .max(Comparator.comparingInt(String::length));
        longest.ifPresent(System.out::println);
    }
    private static void findLongestStr2(List<String> words) {
        /*
        If s1 is longer or equal to s2, keep s1 else, keep s2
        1st compare "java" vs "stream" → keep "stream"
        then "stream" vs "lambda" → same length → keep "stream"
        and so on...
         */
        Optional<String> longestStr = words.stream().reduce((s1, s2) -> s1.length() >= s2.length() ? s1 : s2);
        longestStr.ifPresent(System.out::println);
    }

    private static void findLongestStr3(List<String> words) {
        String longest = words.stream()
                .collect(Collectors.collectingAndThen(
                        Collectors.maxBy(Comparator.comparingInt(String::length)),
                        optional -> optional.orElse("")
                ));
        System.out.println(longest);
    }

}
