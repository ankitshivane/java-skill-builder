package skillbuilder.java8.set4;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LengthOfLongestStr {
    /**
     * Use Stream API to find the length of the longest name in the list.
     */
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Eva");
        longestLenOfStr1(names);
        longestLenOfStr2(names);
        longestLenOfStr3(names);
        longestLenOfStr4(names);
        longestLenOfStrCoreJava(names
        );
    }

    private static void longestLenOfStr1(List<String> names) {
        int maxLen = names.stream().mapToInt(String::length).max().getAsInt();
        System.out.println(maxLen); //output: 7
    }
    private static void longestLenOfStr2(List<String> names) {
        int maxLen = names.stream().map(String::length).max(Integer::compareTo).get();
        System.out.println(maxLen); //output: 7
    }

    private static void longestLenOfStr3(List<String> names) {
        int maxLen = names.stream().map(String::length).reduce(Integer::max).get();
        System.out.println(maxLen); //output: 7
    }


    private static void longestLenOfStr4(List<String> names) {
        String  maxLen = names.stream().collect(Collectors.maxBy(Comparator.comparing(String::length))).get();
        System.out.println(maxLen.length()); //output: 7
    }
    private static void longestLenOfStrCoreJava(List<String> names) {
        int maxLen=0;
        for (String name:names){
            if(name.length()>maxLen)
                maxLen=name.length();
        }
        System.out.println(maxLen);
    }

}
