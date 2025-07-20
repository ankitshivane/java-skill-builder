package skillbuilder.java8.set4;

import java.util.List;
import java.util.stream.Collectors;

public class JoiningMethodTutorial {
    /**
     * This program represents the code examples of Collectors.joining() method
     * study link: https://medium.com/@AlexanderObregon/javas-collectors-joining-method-explained-a4adb120b785
     */
    public static void main(String[] args) {
        List<String> fruits=List.of("apple","mango","orange","banana");
        example1(fruits);
        example2(fruits);
        example3(fruits);
        List<Integer> in=List.of(3,23,3,245,6);
    }

    private static void example1(List<String> fruits) {
        String result=fruits.stream().collect(Collectors.joining());
        System.out.println(result); //applemangoorangebanana
    }

    private static void example2(List<String> fruits) {
        String res = fruits.stream().collect(Collectors.joining(", "));
        System.out.println(res); //apple, mango, orange, banana
    }
    private static void example3(List<String> fruits) {
        String res=fruits.stream().collect(Collectors.joining(", ","[","]"));
        System.out.println(res); // [apple, mango, orange, banana]
    }
}
