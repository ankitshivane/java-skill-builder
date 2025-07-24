package skillbuilder.java8.set1;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;

public class RepeatedElement {

	/**
	 * How do you find the most repeated element in an array?
	 */

	public static void main(String[] args) {

		List<String> listOfStrings = Arrays.asList("Pen", "Eraser", "Note Book", "Pen", "Pencil", "Pen", "Note Book",
				"Pencil", "Sharpner", "Pencil");
		approach1(listOfStrings); // Output: Pen
		approach2(listOfStrings);
	}

	private static void approach2(List<String> listOfStrings) {
		Map<String, Long> groupOfStrByCount = listOfStrings.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		groupOfStrByCount.entrySet().stream().forEach(i -> {
			if (i.getValue() > 1) {
				System.out.println("Repeated Elements are:" + i.getKey() + " count:" + i.getValue());
			}
		});

		Entry<String, Long> mostFrequentElement = groupOfStrByCount.entrySet().stream()
				.max(Entry.comparingByValue()).get();

		System.out.println("Most Frequent Element : " + mostFrequentElement.getKey());

		System.out.println("its Count : " + mostFrequentElement.getValue());

		/**
		 * OUTPUT:
		 *
Repeated Elements are:Pen count:3
Repeated Elements are:Pencil count:3
Repeated Elements are:Note Book count:2
Most Frequent Element : Pen
its Count : 3

		 */}

	private static void approach1(List<String> listOfStrings) {
		String key = listOfStrings.stream().collect(Collectors.groupingBy(
				Function.identity(),
				counting()
		)).entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey();
		System.out.println(key);
	}
}
