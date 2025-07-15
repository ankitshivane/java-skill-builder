package skillbuilder.java8.set4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ConcatFirstTwoWords {
    /**
     * find the concatenation of the first two words that have even lengths.
     */
    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "cherry", "date", "elderberry");
        concatEvenLen1(words); //bananacherry
        concatEvenLen2(words); //bananacherry
        concatEvenLen3(words); //bananacherry
        concatEvenLenCoreJava(words);
    }

    private static void concatEvenLen1(List<String> words) {
        String result = words.stream()
                .filter(word -> word.length() % 2 == 0)
                .limit(2)
                .collect(Collectors.joining());
        System.out.println(result);
    }
    private static void concatEvenLen2(List<String> words) {
        String result = words.stream()
                .filter(w -> w.length() % 2 == 0)
                .limit(2)
                .reduce("", (a, b) -> a + b);
        System.out.println(result);
    }
    private static void concatEvenLen3(List<String> words) {
        String result = words.stream()
                .filter(w -> w.length() % 2 == 0)
                .limit(2)
                .collect(Collectors.collectingAndThen(
                        Collectors.toList(),
                        list -> String.join("", list)
                ));

        System.out.println(result);
    }
    private static void concatEvenLenCoreJava(List<String> words) {
        StringBuilder sb = new StringBuilder();
        int count = 0;

        for (String word : words) {
            if (word.length() % 2 == 0) {
                sb.append(word);
                count++;
                if (count == 2) break;
            }
        }

        String result = sb.toString();
        System.out.println(result); // Output: bananacherry
    }
}
