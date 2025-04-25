package skillbuilder.java8.set1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SortDecimalInReverse {
	/* How do you sort the given list of decimals in reverse order? */
	public static void main(String[] args) {
		List<Double> listOfDouble = Arrays.asList(12.2, 22.1d, 22.33, 33.4);
		listOfDouble.stream().sorted(Comparator.reverseOrder()).forEach(i -> System.out.println("Sorted Element by dscending order:" + i));
		listOfDouble.stream().sorted()
				.forEach(i -> System.out.println("Sorted Element by Ascending order approach-1:" + i));
		
		listOfDouble.stream().sorted(Comparator.naturalOrder())
		.forEach(i -> System.out.println("Sorted Element by Ascending order approach-2:" + i));
	}
}
