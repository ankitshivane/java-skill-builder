package skillbuilder.java8.set4;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SecondLargestElement {
    /**
     *  find second largest element in list of number
     */
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 20, 30, 50, 40, 50, 30);
        findSecondLargestElement1(numbers);
    }

    private static void findSecondLargestElement1(List<Integer> numbers) {
        Integer secLarNum = numbers.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())//sorts in descending order: 50, 40, 30, ...
                .skip(1)//skips the first (largest) element.
                .findFirst().get();//gets the second largest.;
        System.out.println(secLarNum);
    }
}
