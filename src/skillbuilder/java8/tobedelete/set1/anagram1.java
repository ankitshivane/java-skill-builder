package skillbuilder.java8.tobedelete.set1;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class anagram1 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 2, 4, 1, 5, 2};
        int max = Arrays.stream(arr).max().getAsInt();
        int[] freq = new int[max + 1];

        for (int n : arr) freq[n]++;
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(freq));
    }
}
