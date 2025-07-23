package skillbuilder.java8.set1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstRepeatedCharacter {

	/**
	 * Find first repeated character in a string?
	 */
	public static void main(String[] args) {
		String inputString = "Java Concept Of The Day".replaceAll("\\s+", "").toLowerCase();
		Set<String> storeDupliData = new HashSet<>();
		String repeatedData = Arrays.stream(inputString.split("")).filter(i -> !storeDupliData.add(i)).findFirst()
				.get();
		System.out.println(repeatedData); // a

		// approach 2
		LinkedHashMap<String, Long> mapOfData = Arrays.stream(inputString.split(""))
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
		Entry<String, Long> entry = mapOfData.entrySet().stream().filter(i -> i.getValue() > 1).findFirst().get();
		System.out.println("First repeated character in string is:" + entry.getKey() + ",count:" + entry.getValue());
		// output: First repeated character in string is:a,count:3

	}

}
