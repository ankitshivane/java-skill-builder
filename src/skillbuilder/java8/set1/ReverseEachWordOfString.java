package skillbuilder.java8.set1;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReverseEachWordOfString {
	/* Reverse each word of a string using Java 8 streams? */
	public static void main(String[] args) {
		String str = "Java Concept Of The Day";

		streamBasedApproach1(str);

		reverseEachWordCoreJava(str);	// avaJ tpecnoC fO ehT yaD

	}

	private static void streamBasedApproach1(String str) {
		String reversedWordsStr = Stream.of(str.split(" ")).map(i -> new StringBuilder(i).reverse()).collect(Collectors.joining(" "));
		System.out.println(reversedWordsStr); // avaJ tpecnoC fO ehT yaD
	}

	private static void reverseEachWordCoreJava(String input){
		StringBuilder reversed=new StringBuilder();
		for(String w:input.split(" ")){
			reversed.append(new StringBuilder(w).reverse()).append(" ");
		}
		System.out.println(reversed.toString());
	}

}
