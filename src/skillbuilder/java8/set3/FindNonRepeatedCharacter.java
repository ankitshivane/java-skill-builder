package skillbuilder.java8.set3;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindNonRepeatedCharacter {

	/*
	 * Que: Given a String, find the first non-repeated character in it using Stream
	 * functions?
	 */
	public static void main(String[] args) {
		String input = "This is the java practice";
		String str = input.replaceAll(" ", "").toLowerCase();
		Set<String> setOfUniqueString = new HashSet<>();
		Arrays.stream(str.split(""))
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
				.entrySet().stream().filter(entry -> entry.getValue() == 1L).map(entry -> entry.getKey()).findFirst()
				.ifPresent(i -> System.out.println(i));
	}
}
