package skillbuilder.java8;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MergeTwoArray {

	/*
	 * How do you merge two unsorted arrays into single sorted array using Java 8
	 * streams?
	 */
	public static void main(String[] args) {
		int[] a = new int[] { 4, 2, 7, 1 };

		int[] b = new int[] { 8, 3, 9, 5 };
		IntStream.concat(Arrays.stream(a), Arrays.stream(b)).sorted().forEach(i->System.out.print(i+" "));
		/*
		 * output
		 * 1 2 3 4 5 7 8 9
		 */
	}
}
