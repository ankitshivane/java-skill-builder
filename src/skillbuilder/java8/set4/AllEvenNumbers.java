package skillbuilder.java8.set4;

import java.util.Arrays;
import java.util.List;

public class AllEvenNumbers {
    /**
     * Ques: Check if all elements in a List satisfy a given condition using streams.
     * for example if all are even numbers or not
     */
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(2, 4, 6, 8);
        allEven1(numbers);//true
        allEven2(numbers);//true
    }

    private static void allEven1(List<Integer> numbers) {
        boolean even=numbers.stream().allMatch(i->i%2==0);
        System.out.println(even);
    }

    private static void allEven2(List<Integer> numbers) {
        boolean even=numbers.stream().filter(i->i%2 !=0).count()==0;
        System.out.println(even);
    }
}
