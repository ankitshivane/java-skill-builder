package skillbuilder.java8.set4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SumOfEvenNumbers {
    /**
     * Ques: Find the sum of all even numbers in a list of integers.
     */
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(23, 2, 1, 44, 88, 68, 98, 4, 5, 33, 57, 99, 19);
        int sumOfEvenNumbers = sumOfEvenNumbers1(numbers);
        System.out.println("Approach 1 output:"+sumOfEvenNumbers); //output:304
        sumOfEvenNumbers2(numbers);
        sumOfEvenNumbers3(numbers);
        /*
        output:
        Approach 1 output:304
        Approach 2 output:304
        Approach 3 output:304
         */

    }

    public static int sumOfEvenNumbers1(List<Integer> numbers) {
        // here post filtering the even numbers using mapToInt() function to convert every input to a integer and
        // instead of producing Stream<Integer>, producing IntStream as output which provides the necessary inbuilt functions
        int sum = numbers.stream().filter(n -> n % 2 == 0).mapToInt(Integer::intValue).sum();
        return sum;
    }

    public static void sumOfEvenNumbers2(List<Integer> numbers) {
        int sum = numbers.stream().filter(n -> n % 2 == 0).reduce(0, Integer::sum);
        System.out.println("Approach 2 output:" + sum);
    }

    public static void sumOfEvenNumbers3(List<Integer> numbers) {
        int sum = numbers.stream().filter(n -> n % 2 == 0).collect(Collectors.summingInt(Integer::intValue));
        System.out.println("Approach 3 output:" + sum);
    }


}
