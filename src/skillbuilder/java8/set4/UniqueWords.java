package skillbuilder.java8.set4;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class UniqueWords {
    /**
     * Ques: Create a new list that contains only unique words (remove duplicates).
     *
     */
    public static void main(String[] args) {
        List<String> words = Arrays.asList("java", "stream", "api", "java", "lambda", "stream");
        findUnique1(words);
        findUnique2(words);
        /*
        OUTPUT:
        [java, stream, api, lambda]
        [lambda, java, stream, api]
         */
    }

    private static void findUnique1(List<String> words) {
        List<String> unique = words.stream().distinct().toList();
        System.out.println(unique);
    }

    private static void findUnique2(List<String> words) {
        Set<String> unique = words.stream().collect(Collectors.toSet());
        System.out.println(unique);
    }

}
