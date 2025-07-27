package skillbuilder.java8.set4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class StartsWithADigit {
    /**
     * Given a list of integers which may contain null values,
     * your task is to fetch all numbers that starts with digit 1.
     */
    public static void main(String[] args) {
        List<Integer> list= Arrays.asList(10,15,8,49,null,98,132);
        List<Integer> result = list.stream().filter(Objects::nonNull)
                .filter(n -> n.toString().startsWith("1"))
                .collect(Collectors.toList());
        System.out.println(result);
        /*
        OUTPUT
        [10, 15, 132]
         */
    }
}
