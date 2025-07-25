package skillbuilder.java8.set1;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SeperateEvenOdd {
	/*
	 * Question Given a list of integers, separate odd and even numbers?
	 */
	public static void main(String[] args) {
		List<Integer> listOfIntegers = Arrays.asList(71, 18, 42, 21, 67, 32, 95, 14, 56, 87);
		Map<Boolean, List<Integer>> collect = listOfIntegers.stream()
				.collect(Collectors.partitioningBy(i -> i % 2 == 0));

		collect.entrySet().stream().forEach(i -> {
			if (i.getKey()) {
				System.out.println("Even Number:" + i.getValue());
			} else {
				System.out.println("Odd Number:" + i.getValue());
			}
		});
		/*
		OUTPUT:
		Odd Number:[71, 21, 67, 95, 87]
		Even Number:[18, 42, 32, 14, 56]
		 */
	}
}
