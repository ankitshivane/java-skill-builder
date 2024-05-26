package skillbuilder.java8;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstNonRepeatedCharacter {

	/**
	 * Find first non-repeated character in a string?
	 */
	public static void main(String[] args) {
		String inputString = "Java Concept Of The Day".replaceAll("\\s+", "").toLowerCase();
		LinkedHashMap<String, Long> characterWithCount = Arrays.stream(inputString.split(""))
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
		Entry<String, Long> entry = characterWithCount.entrySet().stream().filter(i -> i.getValue() == 1).findFirst()
				.get();
		System.out.println("First Non repeated character is:" + entry.getKey() + ",count:" + entry.getValue());
		/**
		 * OUTPUT: First Non repeated character is:j,count:1
		 */

	}

}
