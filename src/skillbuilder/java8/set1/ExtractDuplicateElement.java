package skillbuilder.java8.set1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ExtractDuplicateElement {

	/*
	 * How do you extract duplicate elements from an array?
	 */

	public static void main(String[] args) {
		List<Integer> listOfIntegers = Arrays.asList(111, 222, 333, 111, 555, 333, 777, 222);
		approach1(listOfIntegers);
		approach2(listOfIntegers);
		/**
		 * output:[333, 222, 111]
		 */

	}

	private static void approach1(List<Integer> listOfIntegers) {
		Set<Integer> uniqueElement = new HashSet<>();
		Set<Integer> duplicatedElement = listOfIntegers.stream().filter(i -> !uniqueElement.add(i))// add returns false if already present
				.collect(Collectors.toSet());
		System.out.println("output:" + duplicatedElement);
	}

	static void approach2(List<Integer> listOfIntegers) {
		List<Integer> duplicatedElement = listOfIntegers.stream()
				.collect(Collectors.groupingBy(i -> i, Collectors.counting()))
				.entrySet().stream().filter(i -> i.getValue() > 1).mapToInt(i -> i.getKey().intValue()).
				boxed().toList();
		System.out.println("output:" + duplicatedElement);
	}

}
