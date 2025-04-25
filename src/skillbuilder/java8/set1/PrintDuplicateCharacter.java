package skillbuilder.java8.set1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class PrintDuplicateCharacter {

	/**
	 * Print duplicate characters in a string?
	 */

	public static void main(String[] args) {
		String inputString = "Java Concept Of The Day";
		String onlyAlphabetsStr = inputString.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
		Set<String> duplicateCharacters = new HashSet<>();
		Set<String> output = Arrays.stream(onlyAlphabetsStr.split("")).filter(i -> !duplicateCharacters.add(i))
				.collect(Collectors.toSet());
		System.out.println(output);
		/**
		 * output:
		 * [a, c, t, e, o]
		 */

		// approach 2
		Map<Character, Long> duplicateElementMap = onlyAlphabetsStr.chars().mapToObj(i -> (char) i)
				.collect(Collectors.groupingBy(i -> i, Collectors.counting()));
		duplicateElementMap.entrySet().stream().forEach(i -> {
			if (i.getValue() > 1) {
				System.out.println("Duplicate characters are:" + i.getKey() + ",Count:" + i.getValue());
			}
		});
		/**
		 * output: 
		 *  Duplicate characters are:a,Count:3
			Duplicate characters are:c,Count:2
			Duplicate characters are:t,Count:2
			Duplicate characters are:e,Count:2
			Duplicate characters are:o,Count:2
		 */

	}
}
