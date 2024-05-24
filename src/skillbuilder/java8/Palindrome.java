package skillbuilder.java8;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class Palindrome {

	/*
	 * Question: Palindrome program using Java 8 streams
	 */
	public static void main(String[] args) {
		String str = "rotator";
		// here the regex ensure the given string will only have alphabets and numbers
		// apart from this everything else willbe replace with the empty space and give
		// an continuous string without space. in string it will replace
		// considering , or * or % etc.
		String normalizedStr = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
		boolean isItPalindrome = IntStream.range(0, normalizedStr.length() / 2)
				.noneMatch(i -> normalizedStr.charAt(i) != normalizedStr.charAt(normalizedStr.length() - i - 1));

		if (isItPalindrome) {
			System.out.println(normalizedStr + " is a palindrome");
		} else {
			System.out.println(normalizedStr + " is not a palindrome");
		}

		/**
		 * OUTPUT: rotator is a palindrome
		 * 
		 * Explanation: IntStream.range(0, normalizedStr.length() / 2): Generates an
		 * IntStream of indices from 0 to half the length of the string. allMatch(i ->
		 * noneMatch(i -> normalizedStr.charAt(i) !=
		 * normalizedStr.charAt(normalizedStr.length() - i - 1));: he method returns
		 * true if all the elements in the stream don’t match the provided Predicate.
		 */

	}

}
