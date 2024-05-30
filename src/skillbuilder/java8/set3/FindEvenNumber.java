package skillbuilder.java8.set3;

import java.util.Arrays;
import java.util.List;

public class FindEvenNumber {

	/**
	 * Given a list of integers, find out all the even numbers that exist in the
	 * list using Stream functions?
	 * 
	 */
	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(10, 15, 8, 49, 25, 98, 32);
		list.stream().filter(i -> i % 2 == 0).forEach(System.out::println);
	}

}
