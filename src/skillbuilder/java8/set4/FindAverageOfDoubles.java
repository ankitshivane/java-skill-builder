package skillbuilder.java8.set4;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class FindAverageOfDoubles {
    /**
     * Ques: Find the average of all the numbers in a list of doubles using Streams.
     */
    public static void main(String[] args) {
        List<Double> numbers = Arrays.asList(10.5, 20.0, 30.5, 40.0);
        findAverage1(numbers);
        findAverage2(numbers);
        findAverage3(numbers);
    }

    private static void findAverage1(List<Double> numbers) {
        double average = numbers.stream().mapToDouble(i -> i).average().getAsDouble();
        System.out.println("Average="+average);
    }

    private static void findAverage2(List<Double> numbers) {
        double average = numbers.stream().collect(Collectors.averagingDouble(Double::doubleValue));
        System.out.println("Average="+average);
    }

    private static void findAverage3(List<Double> numbers) {
        double sum = numbers.stream().reduce(0.0,Double::sum);
        double average=sum/numbers.size();
        System.out.println("Average="+average);
    }
}
