package skillbuilder.java8.set1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class GetThreeMaxAndThreeMin {

	/*
	 * How do you get three maximum numbers and three minimum numbers from the given
	 * list of integers?
	 */

	public static void main(String[] args) {
		List<Integer> listOfIntegers = Arrays.asList(45, 12, 56, 15, 24, 75, 31, 89);
		List<Integer> threeMinNum = listOfIntegers.stream().sorted(Comparator.naturalOrder()).limit(3)
				.collect(Collectors.toList());
		System.out.println("Three Minimum num:" + threeMinNum);

		List<Integer> threeMaxNum = listOfIntegers.stream().sorted(Comparator.reverseOrder()).limit(3)
				.collect(Collectors.toList());
		System.out.println("Three maximum num:" + threeMaxNum);

		/*
		 * output: Three Minimum num:[12, 15, 24]
		 *  Three maximum num:[89, 75, 56]
		 * 
		 */

	}

}
