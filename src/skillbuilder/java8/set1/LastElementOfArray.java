package skillbuilder.java8.set1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class LastElementOfArray {

	/**
	 * How do you get last element of an array?
	 */
	public static void main(String[] args) {
		int[] inputArr = {5, 10, 15, 20, 25};
		List<String> listOfStrings = Arrays.asList("One", "Two", "Three", "Four", "Five", "Six");
		approach1(listOfStrings);


		/**
		 * OUTPUT: Six
		 */
		approach2(inputArr);
		approach4(inputArr);
		// Using IntStream.range() for index-based access
		approach3(inputArr);
		/**
		 * OUTPUT: 25
		 */
	}

	private static void approach2(int[] inputArr) {
		int lastElement2 = Arrays.stream(inputArr).skip(inputArr.length - 1).findFirst().getAsInt();
		System.out.println(lastElement2);
	}

	private static void approach1(List<String> listOfStrings) {
		String lastElement1 = listOfStrings.stream().skip(listOfStrings.size() - 1).findFirst().get();
		System.out.println(lastElement1);
	}

	private static void approach3(int[] inputArr) {
//		Using IntStream.range() for index-based access
		int asInt = Arrays.stream(inputArr).reduce((f, s) -> s).getAsInt();
		System.out.println(asInt);

		/*
		The reduce() method is a terminal operation that repeatedly combines elements of a stream to produce a single result.
		Internally:
		Step 1: reduce(5, 10) → 10

		Step 2: reduce(10, 15) → 15

		Step 3: reduce(15, 20) → 20

		Step 4: reduce(20, 25) → 25

		* You’re always returning the next element, so at the end, the only one that survives is the last: 25.

		* That’s how this trick helps get the last element in the stream.
		 */
	}
	private static void approach4(int[] arr){
		int res = IntStream.range(0, arr.length)
				.map(i -> arr[i])
				.reduce((f, s) -> s).getAsInt();
		System.out.println(res);
	}

}
