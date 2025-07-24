package skillbuilder.java8.set1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class RemoveDuplicateElement {
	/**
	 * Question:
	 * How do you remove duplicate elements from a list using Java 8 streams? */
	public static void main(String[] args) {
		List<String> ls = Arrays.asList("pen", "pencil", "keyboard", "Java", "Python", "C#", "Java", "Kotlin",
				"Python");
		removeDuplicate1(ls);
		removeDuplicate2(ls);
		removeDuplicate3(ls);
	}


	public static void removeDuplicate1(List<String> ls) {
		ls.sort(Comparator.naturalOrder());
		System.out.println("Before removing duplicate elements:"+ls);
		System.out.print("After removing duplicate elements:");
		ls.stream().distinct().forEach(i->System.out.print(i+", "));
	}

	private static void removeDuplicate2(List<String> ls) {
		Set<String> distinct = ls.stream().collect(Collectors.toSet());
		System.out.println(distinct);
	}

	private static void removeDuplicate3(List<String> ls) {
	}
}
