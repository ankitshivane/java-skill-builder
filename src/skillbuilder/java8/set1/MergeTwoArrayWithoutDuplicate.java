package skillbuilder.java8.set1;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MergeTwoArrayWithoutDuplicate {
	/*
	 * How do you merge two unsorted arrays into single sorted array without
	 * duplicates?
	 */
	public static void main(String[] args) {
		int[] a = new int[] { 4, 2, 5, 1 };

		int[] b = new int[] { 8, 1, 9, 5 };

		IntStream.concat(Arrays.stream(a), Arrays.stream(b))
		.sorted()
		.distinct().forEach(k -> System.out.println(k));
		/*
		 * output
		 * 1 2 3 4 5 7 8 9 
		 * */
	}
}
