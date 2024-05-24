package skillbuilder.java8;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FrequencyOfCharacter {
	/*
	 * Question How do you find frequency of each character in a string using Java 8
	 * streams?
	 */
	public static void main(String[] args) {
		String inputString = "Java Concept Of The Day";
		Map<Character, Long> collect = inputString.chars().mapToObj(i -> (char) i)
				.collect(Collectors.groupingBy(i->i, Collectors.counting()));
		collect.entrySet().stream().forEach(i -> {
			System.out.println("Key:" + i.getKey() + "-" + "count:" + i.getValue());
		});
	}
}
