package skillbuilder.java8.set4;


import skillbuilder.java8.set2.Employee;
import skillbuilder.java8.set2.EmployeeDB;

import java.util.*;
import java.util.stream.Collectors;

public class CollectorsGroupingByTutorial {
    /**
     * This article describe the tutorial for Collectors.groupingBy();
     1. groupingBy(Function<? super T, ? extends K> classifier)
        --> When you just want to group elements by a key, and collect them into List by default.

     2. groupingBy(Function<? super T, ? extends K> classifier,
     Collector<? super T, A, D> downstream)
        --> When you want to customize what you collect in each group instead of the default List.

     3. groupingBy(Function<? super T, ? extends K> classifier,
     Supplier<M> mapFactory,
     Collector<? super T, A, D> downstream)
        --> You want to control the type of Map returned (e.g., TreeMap, LinkedHashMap).
        --> Also, want to customize the downstream collector (what’s inside each group).
     Internal Behavior:
     You pass:
     A key classifier
     A Map constructor (Supplier): controls Map<K, V> type
     A downstream Collector: what to do inside each group
     */
    public static void main(String[] args) {
        // first grouping by
//        example1();

        List<String> names = List.of("Ankit", "Amit", "Neha", "Nikita");
       // second grouping by
        example2(names); // output: {A=[Ankit, Amit], N=[Neha, Nikita]}
        example3(names); // output: {A=2, N=2}
        example4(names); // output: {A=[5, 4], N=[4, 6]}
        example5();

        // third grouping by method -> 3. groupingBy(classifier, mapFactory, downstream)
        example6();
        example7(names); // OUTPUT: {A=2, N=2}
        example8(names);

    }

    private static void example8(List<String> names) {
//        Custom grouping: Group by length → Unique sorted names
        Map<Integer, TreeSet<String>> res = names.stream()
                .collect(
                        Collectors.groupingBy(String::length,
                                Collectors.toCollection(TreeSet::new))
                );
        System.out.println(res); // OUTPUT: {4=[Amit, Neha], 5=[Ankit], 6=[Nikita]}
    }

    private static void example1() {
        Map<Integer, List<Employee>> res = EmployeeDB.getAllEmployee().stream().collect(Collectors.groupingBy(Employee::getAge));
        System.out.println(res); // here it groups the element by the employee age, and group them into a list of Employee
    }
    private static void example2(List<String> names) {
        // group all elements by the first letter of the names
        Map<Character,List<String>> res=
        names.stream().collect(Collectors.groupingBy(name->name.charAt(0)));
        System.out.println(res);
    }
    private static void example3(List<String> names) {
//     Count the number of items per group by their first letter

        Map<Character, Long> res = names.stream().collect(Collectors.groupingBy(name -> name.charAt(0), Collectors.counting()));
        System.out.println(res);
    }
    private static void example4(List<String> names) {
        //Group by first letter → then get name lengths
        Map<Character, List<Integer>> res = names.stream()
                .collect(Collectors.groupingBy(name -> name.charAt(0), // here it creates a map with the key as first letter of every word
                Collectors.mapping(String::length, Collectors.toList()))); // here to the value we group them with every letter lengths and creates a list
        // for example for Ankit ->'A' as key we put it into map and in value as list we add its length
        // then laterfor Amit-> 'A' as a key we put the mutable reduction operation where inside the list we update with the length of Amit
        // So on..
        System.out.println(res);
    }
    private static void example5() {
        // Example 1
        // here instead of using by default list collection we used overloaded method of groupingBy() method and collecting as toSet()
        Map<Integer, Set<Employee>> res = EmployeeDB.getAllEmployee().stream().collect(Collectors.groupingBy(Employee::getAge, Collectors.toSet()));
        System.out.println(res);
        // Example 2
        Map<Integer, Set<String>> res2 = EmployeeDB.getAllEmployee().stream().collect(Collectors.groupingBy(Employee::getAge,
                Collectors.mapping(Employee::getDepartment, Collectors.toSet())));
        System.out.println(res2);
        /* Output:
        {32=[HR], 35=[Account And Finance], 38=[Security And Transport], 23=[Infrastructure], 24=[Sales And Marketing], 25=[Product Development, Sales And Marketing], 26=[Product Development], 43=[Security And Transport], 27=[Infrastructure, HR, Account And Finance], 28=[Product Development], 29=[Infrastructure], 31=[Product Development]}
         */
    }

    private static void example6() {
        TreeMap<Integer, List<String>> res = EmployeeDB.getAllEmployee()
                .stream()
                .collect(
                        Collectors.groupingBy(
                                Employee::getAge,
                                TreeMap::new,
                                Collectors.mapping(Employee::getDepartment, Collectors.toList())
                        )
                );
        System.out.println("Example 6: "+"\n"+res);
        /* here if you can compare the output of example 2 from example5() above method you can find that the output is
         not sorted by the age but in this case the output is sorted         */
        /**
         OUTPUT:
         {23=[Infrastructure], 24=[Sales And Marketing, Sales And Marketing], 25=[Sales And Marketing, Product Development], 26=[Product Development], 27=[HR, Infrastructure, Account And Finance], 28=[Product Development], 29=[Infrastructure], 31=[Product Development, Product Development], 32=[HR], 35=[Account And Finance], 38=[Security And Transport], 43=[Security And Transport]}
         */
    }

    private static void example7(List<String> names) {
        // Count of names per starting character using LinkedHashMap

        LinkedHashMap<Character, Long> res = names.stream()
                .collect(Collectors.groupingBy(
                        name -> name.charAt(0),
                        LinkedHashMap::new,
                        Collectors.counting()
                ));
        System.out.println(res); //{A=2, N=2}
    }
}
