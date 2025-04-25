package skillbuilder.java8.set1;

import java.util.stream.IntStream;

public class ReverseAnIntArray {
	/*
	 * Reverse an integer array
	 */
	public static void main(String[] args) {
		int[] array = new int[] { 5, 1, 7, 3, 9, 6 };
		int[] reversedArray = IntStream.rangeClosed(1, array.length).map(i -> array[array.length - i]).toArray();
		for (int a : reversedArray)
			System.out.println(a);
	}
}
