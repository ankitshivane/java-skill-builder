package skillbuilder.java8.set1;

import java.util.Map;
import java.util.stream.Collectors;

public class FrequencyOfCharacter {
    /*
     * Question How do you find frequency of each character in a string using Java 8
     * streams?
     */
    public static void main(String[] args) {
        String inputString = "java day".replaceAll("\\s", "").toLowerCase();

//        streamBasedApproach1(inputString);
//        streamBasedApproach2(inputString);

        coreJavaApproach1(inputString);
    }

    private static void coreJavaApproach1(String inputString) {
        int[] freq = new int[26];
        for (char c : inputString.toCharArray()) {
            freq[c - 'a']++;
        }

        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > 0) {
                System.out.println((char) (i + 'a') + "=" + freq[i]);
            }
        }
    }

    private static void streamBasedApproach2(String input) {
        Map<Character, Integer> collect = input.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toMap(
                        c -> c,
                        c -> 1,
                        Integer::sum
                ));
        System.out.println(collect);
        /**
         * Explanation:
         * Creates a map with key = character, value = 1.
         * If a duplicate key occurs, merge using Integer::sum.
         * Pros: Doesn’t require groupingBy().
         * Cons: Slightly less readable
         */
    }

    private static void streamBasedApproach1(String input) {
        Map<Character, Long> collect = input.chars()//gives an IntStream of character codes.
                .mapToObj(i -> (char) i)    //→ converts each code to a Character object.
                .collect(
                        Collectors.groupingBy(i -> i,
                                Collectors.counting())
                );  // → groups by character and counts occurrences.

        collect.entrySet().stream().forEach(i -> {
            System.out.println("Key:" + i.getKey() + "-" + "count:" + i.getValue());
        });
        System.out.println();
        // OR other approach of iterating stream
        collect.forEach((key, value) -> System.out.println("Key:" + key + ", Value:" + value));
        /**Output:
         Key:a-count:3
         Key:d-count:1
         Key:v-count:1
         Key:y-count:1
         Key:j-count:1

         Key:a, Value:3
         Key:d, Value:1
         Key:v, Value:1
         Key:y, Value:1
         Key:j, Value:1
         */
    }
}
