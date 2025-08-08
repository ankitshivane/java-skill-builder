package skillbuilder.java8.set1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortAccordingToIncreaseOrder {

	/**
	 * Given a list of strings, sort them according to increasing order of their length?
	 */
	public static void main(String[] args) {
		List<String> listOfStrings = Arrays.asList("Java","matplotlib", "Python", "C#", "HTML", "Kotlin", "C++", "COBOL", "C");
		List<String> result1 = listOfStrings.stream().sorted(Comparator.comparing(String::length)).collect(Collectors.toList());
		System.out.println(result1);
		/**
		 OUTPUT:
		 [C, C#, C++, Java, HTML, COBOL, Python, Kotlin, matplotlib]
		 */
	}

}
