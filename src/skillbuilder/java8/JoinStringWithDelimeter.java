package skillbuilder.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class JoinStringWithDelimeter {
	/*
	 * Given a list of strings, join the strings with ‘[‘ as prefix, ‘]’ as suffix
	 * and ‘,’ as delimiter?
	 * 
	 */
	public static void main(String[] args) {
		List<String> listOfStrings = Arrays.asList("Facebook", "Twitter", "YouTube", "WhatsApp", "LinkedIn");
		// joining each element of a string with delimeter, suffix and prefix
		String collect = listOfStrings.stream().collect(Collectors.joining(",", "[", "]"));
		System.out.println(collect);

		// joining each element of a string with each other
		String collect2 = listOfStrings.stream().collect(Collectors.joining());
		System.out.println(collect2);

		// joining each element of a string with delimeter
		String collect3 = listOfStrings.stream().collect(Collectors.joining(","));
		System.out.println(collect3);

		// sample output
		/*
		 * [Facebook,Twitter,YouTube,WhatsApp,LinkedIn]
		 * FacebookTwitterYouTubeWhatsAppLinkedIn
		 * Facebook,Twitter,YouTube,WhatsApp,LinkedIn
		 * 
		 * 
		 */

	}

}
