package skillbuilder.java8;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class First10OddNumbers {

	/**
	 * First 10 odd numbers
	 */
	public static void main(String[] args) {
		List<Integer> oddNumbers = IntStream.iterate(1, i -> i + 1).filter(i -> i % 2 != 0).limit(10).boxed()
				.collect(Collectors.toList());
		System.out.println(oddNumbers);
		/**
		 * OUTPUT: [1, 3, 5, 7, 9, 11, 13, 15, 17, 19]
		 */
	}

}
