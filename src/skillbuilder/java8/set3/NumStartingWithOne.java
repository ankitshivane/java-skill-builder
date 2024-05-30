package skillbuilder.java8.set3;

import java.util.Arrays;
import java.util.List;

public class NumStartingWithOne {

	/**
	 * Given a list of integers, find out all the numbers starting with 1 using
	 * Stream functions?
	 */
	public static void main(String[] args) {
		List<Integer> myList = Arrays.asList(10, 15, 8, 49, 25, 98, 32, 12, 114);
		myList.stream().filter(i -> i / 10 == 1).forEach(System.out::println);
		System.out.println("------------------------------");
		//approach 2
		myList.stream().map(String::valueOf).filter(i -> i.startsWith("1")).forEach(System.out::println);
	}

}
