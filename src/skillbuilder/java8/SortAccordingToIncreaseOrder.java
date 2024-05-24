package skillbuilder.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SortAccordingToIncreaseOrder {

	/**
	 * Given a list of strings, sort them according to increasing order of their
	 * length?
	 */
	public static void main(String[] args) {
		List<String> listOfStrings = Arrays.asList("Java", "Python", "C#", "HTML", "Kotlin", "C++", "COBOL", "C");
		List<String> result1 = listOfStrings.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());
		System.out.println(result1);
	}

}
