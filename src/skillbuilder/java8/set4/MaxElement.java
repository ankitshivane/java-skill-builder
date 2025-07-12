package skillbuilder.java8.set4;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MaxElement {

    public static void main(String[] args) {
        List<Integer> numbers=Arrays.asList(3,23,434,2,424,1,5,3,29);
        findMaxMinOfNumbers1(numbers);
        findMaxMinOfNumbers2(numbers);
        findMaxMinOfNumbers3(numbers);
        findMaxMinOfNumbers4(numbers);
        findMaxMinOfNumbers5(numbers);
        findMaxMinOfNumbers6(numbers);
        /*
        OUTPUT:
Max=434, min=1
Max=434, min=1
Max=434, min=1
Max=434, min=1
Max=434, min=1
Max=434, min=1
         */
    }

    private static void findMaxMinOfNumbers1(List<Integer> numbers) {
        int maxNum = numbers.stream().mapToInt(Integer::intValue).max().getAsInt();
        int min = numbers.stream().mapToInt(Integer::intValue).min().getAsInt();
        System.out.println("Max="+maxNum+", min="+min);
    }

    private static void findMaxMinOfNumbers2(List<Integer> numbers) {

        // here the max() and min() both functions takes Comparator and it sorts the array internally with natural order and picks the required first or last
        int maxNum = numbers.stream().max(Comparator.naturalOrder()).get();
        int min = numbers.stream().min(Comparator.naturalOrder()).get();
        System.out.println("Max="+maxNum+", min="+min);
    }

    private static void findMaxMinOfNumbers3(List<Integer> numbers) {

        int maxNum = numbers.stream().sorted(Comparator.reverseOrder()).limit(1).findFirst().get();
        int min = numbers.stream().sorted().limit(1).findFirst().get();
        System.out.println("Max="+maxNum+", min="+min);
    }

    private static void findMaxMinOfNumbers4(List<Integer> numbers) {
        Integer max = numbers.stream().max(Integer::compareTo).get();
        Integer min = numbers.stream().min(Integer::compareTo).get();
        System.out.println("Max="+max+", min="+min);
    }
    private static void findMaxMinOfNumbers5(List<Integer> numbers) {
        Integer max = numbers.stream().reduce(Integer::max).get();
        Integer min = numbers.stream().reduce(Integer::min).get();
        System.out.println("Max="+max+", min="+min);
    }

    private static void findMaxMinOfNumbers6(List<Integer> numbers) {
        int max = numbers.stream().mapToInt(i -> i).max().getAsInt();
        int min = numbers.stream().mapToInt(i->i).min().getAsInt();
        System.out.println("Max="+max+", min="+min);
    }

}
