package skillbuilder.java8.set4;

import java.util.Arrays;
import java.util.List;

public class AllStartsWithUppercase {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("Java", "Stream", "API");
        boolean allUpper=words.stream().allMatch(i->Character.isUpperCase(i.charAt(0)));
        System.out.println(allUpper); //true
    }
}
