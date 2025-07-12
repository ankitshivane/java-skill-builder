package skillbuilder.java8.set4;

import java.util.List;
import java.util.stream.Collectors;

public class CountOfString {
    /**
     * Ques: Find and print the count of strings that have length greater than 5.
     */
    public static void main(String[] args) {
        List<String> lang = List.of("java home", "data science", "cpp", "automation", "c#");
        findCountOfLenOfStr1(lang);//3
        findCountOfLenOfStr2(lang);
        findCountOfLenOfStr3(lang);
    }

    private static void findCountOfLenOfStr1(List<String> lang) {
        long count = lang.stream().filter(str -> str.length() > 5).count();
        System.out.println(count);
    }

    private static void findCountOfLenOfStr2(List<String> lang) {
        long count = lang.stream().filter(str -> str.length() > 5).collect(Collectors.counting());
        System.out.println(count);
    }

    private static void findCountOfLenOfStr3(List<String> lang) {
        long count = lang.stream().mapToInt(s -> s.length() > 5 ? 1 : 0).sum();
        System.out.println(count);
    }


}
