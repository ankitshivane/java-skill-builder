package skillbuilder.java8.set4;

import skillbuilder.java8.set2.Employee;
import skillbuilder.java8.set2.EmployeeDB;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.*;

public class CollectorsTutorial {
    public static void main(String[] args) {
        List<String> names= Arrays.asList("Ankit", "Radha", "Adwitya", "Sameer", "Govind", "Shyam");
        // uncomment each line and verify the result
//        toMapTut1(names);
//        toListTut1(names); // this same operation applies to Collectors.toSet()
//        countingTut1(names);
//        collectorSummarizingMethods(names);
//        collectorAveraging(names); //AveragingDouble/Long/Int is a collector that simply returns an average of extracted elements.
//        collectorSumminngDuble(names); //SummingDouble/Long/Int is a collector that simply returns a sum of extracted elements.
//        maxByMinBy(names);
//        collectorTeeing();
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        // CASE 1:
        CollectorsPartitioningBy1(numbers);
        // CASE 2:
//        CollectorsPartitioningBy2(numbers);
    }

    private static void CollectorsPartitioningBy1(List<Integer> numbers) {
        /**
         * partitioningBy() is a special case of groupingBy() where it classify or partition the data into map of true and false as key value
         *
         Partitions the elements into two groups:
         Key true: elements matching the predicate
         Key false: elements that don't match

         OUTPUT type: Map<Boolean, List<T>>
         */

        // get the even and odd
        Map<Boolean,List<Integer>> res= numbers.stream().collect(partitioningBy(n->n%2==0));
        System.out.println(res); //{false=[1, 3, 5], true=[2, 4, 6]}
        // Explanation:so here whichever function satisfied the even condition went to true value key list and rest went to false key,list of values

        // Example 2: Group employees by if they are earning above 25K
        Map<Boolean, List<Employee>> res3 = EmployeeDB.getAllEmployee().stream().collect(
                partitioningBy(e -> e.getSalary() > 25000)
        );
        System.out.println(res3); // here output is very big so not logging

        // Example 3: separate fruits having length > 5
        List<String> words = List.of("apple", "banana", "kiwi", "mango", "grapefruit");
        Map<Boolean,List<String>> res4=words.stream().collect(
                partitioningBy(s->s.length()>5)
        );
        System.out.println(res4); //{false=[apple, kiwi, mango], true=[banana, grapefruit]}

        // Example 4:Partition numbers into prime and non-prime
        Map<Boolean, List<Integer>> result = IntStream.rangeClosed(1, 20)
                .boxed()
                .collect(Collectors.partitioningBy(CollectorsTutorial::isPrime));
        System.out.println(result); // {false=[1, 4, 6, 8, 9, 10, 12, 14, 15, 16, 18, 20], true=[2, 3, 5, 7, 11, 13, 17, 19]}
    }
    static boolean isPrime(int n) {
        return n > 1 && IntStream.rangeClosed(2, (int) Math.sqrt(n)).allMatch(i -> n % i != 0);
    }



    private static void CollectorsPartitioningBy2(List<Integer> numbers) {
        /**
         * it is same as above partitionBy only excep
         * Allows you to apply another collector to the true and false partitions.
         * OUTPUT type: Map<Boolean, D> // D is the result of downstream collector and not always List<T>
         */
//        Example 1: Count of even and odd numbers
        Map<Boolean,Long> res2=numbers.stream().collect(
                partitioningBy(n->n%2==0,
                        counting())
        );
        System.out.println(res2);// {false=3, true=3}

        // Example 2: Group employees by if they are earning above 25K
        // But Partition and then get names instead of full object
        Map<Boolean, List<String>> res3 = EmployeeDB.getAllEmployee().stream().collect(
                partitioningBy(e -> e.getSalary() > 25000,
                        Collectors.mapping(Employee::getName,toList()))
        );
        System.out.println(res3); // {false=[Jiya Brein, Paul Niksui, Martin Theron, Nima Roy, Iqbal Hussain, Amelia Zoe, Jaden Dough, Jasna Kaur, Jyothi Reddy, Nicolus Den, Ali Baig], true=[Murali Gowda, Manu Sharma, Wang Liu, Nitin Joshi, Sanvi Pandey, Anuj Chettiar]}

    }

    private static void collectorTeeing() {
        /**
         Allows you to collect from a stream into two collectors simultaneously, and then merge the results.
         Think of it as: "Split the stream in two different ways and then combine the result".

         Signature:
         public static <T, R1, R2, R>
         Collector<T, ?, R> teeing(
         Collector<? super T, ?, R1> downstream1,
         Collector<? super T, ?, R2> downstream2,
         BiFunction<? super R1, ? super R2, R> merger)
         */

        // Example 1: Get Min and Max element in one pass
        MinMax res = EmployeeDB.getAllEmployee().stream().collect(teeing(
                maxBy(Comparator.comparingDouble(Employee::getSalary)),
                minBy(Comparator.comparingDouble(Employee::getSalary)),
                (max, min) -> new MinMax(min.get().getSalary(), max.get().getSalary())
        ));
        System.out.println(res); // OUTPUT: MinMax[min=10500.0, max=35700.0]

        // Example 2: Average of even and odd separately
        List<Integer> num=List.of(34,44,2,34,5,33,87,88);
        EvenOddAvg res2 = num.stream().collect(teeing(
                filtering(n -> n % 2 == 0, averagingInt(i -> i)),
                filtering(n -> n % 2 != 0, averagingInt(i -> i)),
                EvenOddAvg::new
        ));
        System.out.println(res2); // EvenOddAvg[evenAvg=40.4, oddAvg=41.666666666666664]
        /**
         Internals:
         Internally, teeing holds two collectors.
         Each element is passed to both collectors during the stream traversal.
         Once both collectors complete, their results are merged using the given BiFunction.
         */
    }
    record EvenOddAvg(double evenAvg, double oddAvg) {}

    record MinMax(double min, double max) {}


    private static void maxByMinBy(List<String> names) {
        //Returns a Collector that finds the maximum element of a stream according to a given comparator.
        // It wraps the value in Optional always.
        Optional<String> res1=names.stream().collect(maxBy(Comparator.naturalOrder()));
        res1.ifPresent(System.out::println); // OUTPUT: Shyam
        // So here it basically has sorted the stream in ascending order that is natural for string, and then selected the last element as the max element.

        // Example 2:
        Optional<Employee> maxSal= EmployeeDB.getAllEmployee().stream().collect(maxBy(Comparator.comparingDouble(Employee::getSalary)));
        System.out.println(maxSal.get().getSalary()); // 35700.0

        //Same as maxBy() but for minimum element.
    }

    private static void collectorSumminngDuble(List<String> names) {
        //  We can get the sum of all string lengths by doing:
        Integer res = names.stream().collect(summingInt(String::length));
        System.out.println(res); //OUTPUT: 34
        // OR alternatively can also be done as
        int sum = names.stream().mapToInt(String::length).sum();
        System.out.println(sum); //OUTPUT: 34
    }

    private static void collectorAveraging(List<String> names) {
      //We can get the average string length by doing:
        Double res = names.stream().collect(averagingLong(String::length));
        System.out.println(res);// 5.666666666666667
        /*
        Note:
        * apart from this there is averagingDouble and averagingLong method present
         */
    }

    private static void collectorSummarizingMethods(List<String> names) {
        IntSummaryStatistics res = names.stream().collect(summarizingInt(String::length));
        System.out.println("Max="+res.getMax());
        System.out.println("Avg="+res.getAverage());
        System.out.println("count="+res.getCount());
        System.out.println("Min="+res.getMin());
        System.out.println("Sum="+res.getSum());
   /*
    This summarizingInt method takes ToFunction as input which contains "int applyAsInt(T t);" SAM method, so that is why we should pass such input
    which takes input as any type but return value should be int,
    here the input is string but the return type is int (length of the string)
    */
        /*
        OUTPUT:
        Max=7
        Avg=5.666666666666667
        count=6
        Min=5
        Sum=34
         */

    }

    private static void countingTut1(List<String> names) {
        Long count1=names.stream().collect(Collectors.counting());
        System.out.println(count1); // OUTPUT: 6
        Long count2=names.stream().count();
        System.out.println(count2); // OUTPUT: 6
    }

    private static void toListTut1(List<String> names) {
        // CASE 1: easy as we all know toList();
        List<String> result = names.stream()
                .collect(toList());
        result.add("Arjun");
        System.out.println(result); // OUTPUT: [Ankit, Radha, Adwitya, Sameer, Govind, Shyam, Arjun]

        // CASE 2: toUnmodifiableList();
        List<String> result2 = names.stream()
                .collect(toUnmodifiableList());

        try {
            result2.add("Arjun");
        } catch (UnsupportedOperationException e) {
            System.out.println(e.getMessage()); // OUTPUT: null
            // here while trying to modifying the list we ran into UnsupportedOperationException and the msg was null
        }
        System.out.println(result2);


    }

    private static void toMapTut1(List<String> names) {
        Map<String, Integer> result = names.stream()
                .collect(
                        toMap(
                                Function.identity(), //Function.identity() is just a shortcut for defining a function that accepts and returns the same value, you can also replace with as "n->n"
                                String::length)
                );
        System.out.println(result); // OUTPUT: {Shyam=5, Govind=6, Ankit=5, Radha=5, Adwitya=7, Sameer=6}

        /* Case 2: if you add any duplicate name in the above names input and re-run the program you will get below exception
        -> Duplicate key Ankit (attempted merging values 5 and 5)
        -> toMap() doesn’t even evaluate whether the values are also equal. If it sees duplicate keys, it immediately throws an IllegalStateException.
         */
        List<String> names2= Arrays.asList("Ankit", "Radha", "Adwitya", "Sameer", "Govind", "Shyam","Ankit");
try{
    Map<String, Integer> res = names2.stream().collect(toMap(Function.identity(), String::length));
    System.out.println(res);
}catch(IllegalStateException e){
            System.out.println(e.getMessage()); // OUTPUT: Duplicate key Ankit (attempted merging values 5 and 5)
        }

        // CASE 3: In such cases with key collision, we should use toMap() with another signature:
        Map<String, Integer> result2 = names2.stream()
                .collect(toMap(Function.identity(), String::length, (item, identicalItem) -> item));
        System.out.println(result2); // OUTPUT: {Shyam=5, Govind=6, Ankit=5, Sameer=6, Adwitya=7, Radha=5}
        /*
        The third argument here is a BinaryOperator(), where we can specify how we want to handle collisions.
        In this case, we’ll just pick any of these two colliding values because we know that the same strings will always have the same lengths too.
         */
    }
}
