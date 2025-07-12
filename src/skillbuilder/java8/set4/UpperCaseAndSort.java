package skillbuilder.java8.set4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UpperCaseAndSort {
    /**
     * Ques: Convert each string to uppercase and then sort them in alphabetical order.
     *
     */
    public static void main(String[] args) {
        List<String> words = Arrays.asList("banana", "Apple", "cherry", "date");
        convertAndSort1(words);
        convertAndSort2(words);
    }

    private static void convertAndSort1(List<String> words) {
        List<String> output=words.stream()
                .map(s->s.toUpperCase()) //map() → transforms each string to uppercase
                .sorted() //sorted() → natural alphabetical order (case-insensitive now)
                .toList();
        System.out.println(output);
    }

    private static void convertAndSort2(List<String> words){
        //If you want to sort ignoring case but preserve original case
        List<String> result = words.stream()
                .sorted(String.CASE_INSENSITIVE_ORDER)
                .collect(Collectors.toList());
        System.out.println(result);
    }
}
