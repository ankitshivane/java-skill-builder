package skillbuilder.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SecondLargestNumber {

	/**
	 * Find second largest number in an integer array?
	 */
	public static void main(String[] args) {
		List<Integer> listOfIntegers = Arrays.asList(45, 12, 56, 15, 24, 75, 31, 89);
		// approach 1
		Integer secLargestNum = listOfIntegers.stream().sorted(Comparator.reverseOrder()).skip(1).limit(1).findFirst()
				.get();
		System.out.println("using approach 1:" + secLargestNum);

		Integer secLargestNum2 = listOfIntegers.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
		System.out.println("using approach 2:" + secLargestNum2);
		/**
		 * output: 
		 * using approach 1:75
		 * using approach 2:75
		 */
	}
}
