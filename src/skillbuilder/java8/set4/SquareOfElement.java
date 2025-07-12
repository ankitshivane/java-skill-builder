package skillbuilder.java8.set4;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class SquareOfElement {
    /**
     * Ques: Implement a function that takes a list of integers as input and returns
     * a new list containing the square of each element.
     */
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(23, 2, 1, 44, 88, 68, 98, 4, 5, 33, 57, 99, 19);
        squareOfEveryElement1(numbers);
        squareOfEveryElement2(numbers);
    }

    private static void squareOfEveryElement1(List<Integer> numbers) {
        List<Integer> output = numbers.stream().map(n -> n * n).collect(Collectors.toList());
        System.out.println(output);
    }

    private static void squareOfEveryElement2(List<Integer> numbers) {
        List<Integer> output = numbers.stream()
                .mapToInt(n -> n * n)// here it produces the IntStream
                .boxed() // Converts IntStream to Stream<Integer> so we can use .collect() function, in IntStream we can not use .collect() function
                .collect(Collectors.toList());
        System.out.println(output);
    }
}
