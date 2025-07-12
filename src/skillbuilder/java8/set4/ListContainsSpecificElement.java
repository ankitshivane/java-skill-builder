package skillbuilder.java8.set4;

import java.util.Arrays;
import java.util.List;

public class ListContainsSpecificElement {
    /**
     * Ques: Check if a list contains a specific element using streams. for example a list of integers contains 9
     */
    public static void main(String[] args) {
        List<Integer> numbers= Arrays.asList(34,2,3,5,2,4,9);
        checkIfContains1(numbers); //true
        checkIfContains2(numbers); //true
    }
    private static void checkIfContains1(List<Integer> numbers){
        boolean result=numbers.stream().anyMatch(i->numbers.contains(i));
        System.out.println(result);
    }

    private static void checkIfContains2(List<Integer> numbers){
        boolean result=numbers.stream().filter(i->numbers.contains(9)).findAny().isPresent();
        System.out.println(result);
    }
}
