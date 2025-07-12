package skillbuilder.java8.set4;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ConcatAllStringToASingle {
    /**
     * Ques: Concatenate all the strings in a list into a single string.
     */
    public static void main(String[] args) {
        List<String> words = Arrays.asList("Java", "Stream", "API", "is", "powerful");
        concatStr1(words);
        concatStr2(words);
        /*
        OUTPUT:
JavaStreamAPIispowerful
JavaStreamAPIispowerful
         */
    }

    private static void concatStr1(List<String> words) {
        String concatenatedStr = words.stream().collect(Collectors.joining());
        System.out.println(concatenatedStr);
    }

    private static void concatStr2(List<String> words) {
        Optional<String> concatenatedStr = words.stream()
                .reduce((s1, s2) -> s1 + s2);

        System.out.println(concatenatedStr.orElse(null));
    }

}
