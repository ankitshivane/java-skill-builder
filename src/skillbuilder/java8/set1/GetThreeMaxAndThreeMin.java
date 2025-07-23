package skillbuilder.java8.set1;

import java.util.*;
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

		// Core Java Approach
		coreJavaApproach1(listOfIntegers);

		/*
		 * output: Three Minimum num:[12, 15, 24]
		 *  Three maximum num:[89, 75, 56]
		 * 
		 */
	}

	private static void coreJavaApproach1(List<Integer> listOfIntegers) {
		Collections.sort(listOfIntegers,Comparator.reverseOrder());
		System.out.println("Three Minimum num:"+listOfIntegers.subList(0,3));

		Collections.sort(listOfIntegers,Comparator.naturalOrder());
		System.out.println("Three maximum num:"+listOfIntegers.subList(0,3));
	}

}
