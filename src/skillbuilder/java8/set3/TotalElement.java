package skillbuilder.java8.set3;

import java.util.Arrays;
import java.util.List;

public class TotalElement {

	/**
	 * Given a list of integers, find the total number of elements present in the
	 * list using Stream functions?
	 * 
	 * 
	 */
	public static void main(String[] args) {
		List<Integer> myList = Arrays.asList(10,15,8,49,25,98,98,32,15);
		long count = myList.stream().count();
		System.out.println(count);
	}

}
