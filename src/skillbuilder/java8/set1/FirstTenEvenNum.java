package skillbuilder.java8.set1;

import java.util.stream.IntStream;

public class FirstTenEvenNum {

	/**
	 * Print first 10 even numbers
	 */
	public static void main(String[] args) {
//using traditional approach
		int c = 1;
		int start = 1;
		while (c <= 10) {
			if (start % 2 != 0) {
				start++;
				continue;
			}
			System.out.println(start);
			start++;
			c++;
		}

		// using java 8 approach 1
		IntStream.rangeClosed(1, 10).map(i -> i * 2).forEach(i -> System.out.println(i));

		// using java 8 approach 2
		IntStream.iterate(2, i -> i + 2).limit(10).forEach(i -> System.out.print(i + " "));
		/**
		 * Output: 2 4 6 8 10 12 14 16 18 20
		 */
	}
}
