package skillbuilder.java8.set3;

import java.util.Arrays;
import java.util.List;

public class FirstElement {
	/**
	 * Given the list of integers, find the first element of the list using Stream
	 * functions?
	 * 
	 */
	public static void main(String[] args) {
		List<Integer> myList = Arrays.asList(10, 15, 8, 49, 25, 98, 98, 32, 15);
		Integer firstElement = myList.stream().findFirst().get();
		System.out.println(firstElement);
	}

}
