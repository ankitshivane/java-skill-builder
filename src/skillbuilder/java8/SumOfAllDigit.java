package skillbuilder.java8;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SumOfAllDigit {
	/*
	 * Find sum of all digits of a number in Java 8?
	 */
	public static void main(String[] args) {
		int i = 15623;
		// naive approach
		int sum = Stream.of(String.valueOf(i).split("")).mapToInt(j -> Integer.parseInt(j)).sum();
		System.out.println(sum);

		// approach 2
		Integer sumOfDigits = Stream.of(String.valueOf(i).split("")).collect(Collectors.summingInt(Integer::parseInt));
		System.out.println(sumOfDigits);
		
	}
}
