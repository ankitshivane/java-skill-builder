package skillbuilder.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StrStarsWithNumber {

	/*
	 * Given a list of strings, find out those strings which start with a number?
	 */
	public static void main(String[] args) {
		List<String> listOfStrings = Arrays.asList("One", "2wo", "3hree", "Four", "5ive", "Six");
		List<String> output = listOfStrings.stream().filter(i -> Character.isDigit(i.charAt(0)))
				.collect(Collectors.toList());
		System.out.println("output:" + output);
		
		/**
		 * output:[2wo, 3hree, 5ive]
		 */
	}

}
