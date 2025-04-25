package skillbuilder.java8.set1;

import java.util.Arrays;
import java.util.List;

public class LastElementOfArray {

	/**
	 * How do you get last element of an array?
	 */
	public static void main(String[] args) {
		List<String> listOfStrings = Arrays.asList("One", "Two", "Three", "Four", "Five", "Six");
		String lastElement1 = listOfStrings.stream().skip(listOfStrings.size() - 1).findFirst().get();
		System.out.println(lastElement1);

		/**
		 * OUTPUT: Six
		 */
		int[] inputArr = new int[] { 1, 2, 3, 4, 5, 6 };
		int lastElement2 = Arrays.stream(inputArr).skip(inputArr.length - 1).findFirst().getAsInt();
		System.out.println(lastElement2);

		/**
		 * OUTPUT: 6
		 */
	}

}
