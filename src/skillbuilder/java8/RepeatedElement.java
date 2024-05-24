package skillbuilder.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class RepeatedElement {

	/**
	 * How do you find the most repeated element in an array?
	 */

	public static void main(String[] args) {

		List<String> listOfStrings = Arrays.asList("Pen", "Eraser", "Note Book", "Pen", "Pencil", "Pen", "Note Book",
				"Pencil");
		Map<String, Long> groupOfStrByCount = listOfStrings.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		groupOfStrByCount.entrySet().stream().forEach(i -> {
			if (i.getValue() > 1) {
				System.out.println("Repeated Elements are:" + i.getKey() + " count:" + i.getValue());
			}
		});
	}

}
