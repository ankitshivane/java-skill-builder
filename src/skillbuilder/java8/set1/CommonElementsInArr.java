package skillbuilder.java8.set1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CommonElementsInArr {
	/*
	 * How do you find common elements between two arrays?
	 */
	public static void main(String[] args) {
		List<Integer> list1 = Arrays.asList(71, 21, 34, 89, 56, 28);

		List<Integer> list2 = Arrays.asList(12, 56, 17, 21, 94, 34);
		// using lambda expre
		List<Integer> commonElements1 = list1.stream().filter(i -> list2.contains(i)).collect(Collectors.toList());
		System.out.println(commonElements1);

		// using method reference
		List<Integer> commonElements2 = list1.stream().filter(list2::contains).collect(Collectors.toList());
		System.out.println(commonElements2);
		
		/*
		 * output:
		 * [21, 34, 56]
		 * [21, 34, 56]

		 */
	}
}
