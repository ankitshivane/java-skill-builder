package skillbuilder.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MaxAndMinOfNum {
	/*
	 * Given a list of integers, find maximum and minimum of those numbers?
	 */
	public static void main(String[] args) {
		List<Integer> listOfIntegers = Arrays.asList(45, 12, 56, 15, 24, 75, 31, 89);
		Integer min = listOfIntegers.stream().min(Comparator.naturalOrder()).get();
		System.out.println("Minimum number by approach2:" + min);

		Integer min2 = listOfIntegers.stream().sorted(Comparator.naturalOrder()).limit(1).findFirst().get();
		System.out.println("Minimum number by approach2:" + min2);

		Integer max = listOfIntegers.stream().max(Comparator.naturalOrder()).get();
		System.out.println("Max:" + max);
	}
}
