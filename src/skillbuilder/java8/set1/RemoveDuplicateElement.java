package skillbuilder.java8.set1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class RemoveDuplicateElement {
	public static void main(String[] args) {
		List<String> ls = Arrays.asList("pen", "pencil", "keyboard", "Java", "Python", "C#", "Java", "Kotlin",
				"Python");
//		Map<String, Long> collect = ls.stream()
//				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
//		collect.entrySet().stream()
//				.forEach(i -> System.out.println("Key:" + i.getKey() + "-" + "count:" + i.getValue()));
		removeDuplicate(ls);
	}

	/* 
	 * Question:
	 * How do you remove duplicate elements from a list using Java 8 streams? */
	public static void removeDuplicate(List<String> ls) {
		ls.sort(Comparator.naturalOrder());
		System.out.println("Before removing duplicate elements:"+ls);
		System.out.print("After removing duplicate elements:");
		ls.stream().distinct().forEach(i->System.out.print(i+", "));
	}
}
