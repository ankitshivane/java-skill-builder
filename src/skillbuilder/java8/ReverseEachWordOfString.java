package skillbuilder.java8;

import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReverseEachWordOfString {
	/* Reverse each word of a string using Java 8 streams? */
	public static void main(String[] args) {
		String str = "Java Concept Of The Day";
//		String output = Stream.of(str.split(" ")).sorted(Comparator.reverseOrder()).collect(Collectors.joining(" "));
//		System.out.println(output);

		String reversedWordsStr = Stream.of(str.split(" ")).map(i -> new StringBuilder(i).reverse()).collect(Collectors.joining(" "));
		System.out.println(reversedWordsStr);

	}

}
