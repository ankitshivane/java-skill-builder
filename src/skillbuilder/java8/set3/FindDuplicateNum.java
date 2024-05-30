package skillbuilder.java8.set3;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindDuplicateNum {

	/**
	 * How to find duplicate elements in a given integers list in java using Stream
	 * functions?
	 * 
	 */
	public static void main(String[] args) {
		List<Integer> myList = Arrays.asList(10, 15, 8, 49, 25, 98, 98, 32, 15);
		Set<Integer> uniqueElemet = new HashSet<>();
		myList.stream().filter(i -> !uniqueElemet.add(i)).forEach(i -> {
			System.out.println(i);
		});
	}

}
