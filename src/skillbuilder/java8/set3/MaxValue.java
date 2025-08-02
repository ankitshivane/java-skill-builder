package skillbuilder.java8.set3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MaxValue {

	/**
	 * Given a list of integers, find the maximum value element present in it using
	 * Stream functions?
	 * 
	 */
	public static void main(String[] args) {
		List<Integer> myList = Arrays.asList(10, 15, 8, 49, 25, 98, 98, 32, 15);
		Integer integer = myList.stream().max(Comparator.naturalOrder()).get();
		System.out.println(integer);	// 98
		
		

		Integer integer2 = myList.stream().max((a, b) -> a - b).get();
		System.out.println(integer2); // 98

	}

}
