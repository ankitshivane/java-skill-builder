package skillbuilder.java8.set4;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class RemoveNullFromLst {
    /**
     * Ques: Remove null values from a list using streams.
     */
    public static void main(String[] args) {
        List<String> words = Arrays.asList("java", null, "stream", null, "lambda");
        removeNullFromLst(words);
        removeNullFromLst2(words);
    }

    private static void removeNullFromLst(List<String> words) {
        List<String> collect = words.stream().filter(Objects::nonNull).collect(Collectors.toList());
        System.out.println(collect);
    }

    private static void removeNullFromLst2(List<String> words) {
        List<String> collect = words.stream().filter(s -> s != null && !s.isEmpty()).collect(Collectors.toList());
        System.out.println(collect);
    }
}
