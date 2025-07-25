package skillbuilder.java8.set1;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SumOfAllDigit {
	/*
	 * Find sum of all digits of a number in Java 8?
	 */
	public static void main(String[] args) {
		int i = 15623;
		// naive approach
		int sum = Stream.of(String.valueOf(i).split("")).mapToInt(j -> Integer.parseInt(j)).sum();
		System.out.println(sum); // 17

		// approach 2
		Integer sumOfDigits = Stream.of(String.valueOf(i).split("")).collect(Collectors.summingInt(Integer::parseInt));
		System.out.println(sumOfDigits); // 17

		// Core Java approach
		coreJavaApproach1(i); //17
	}


	private static void coreJavaApproach1(int num){
		int sum=0;
		while (num!=0){
			int r=num%10;
			sum=(sum)+r;
			num=num/10;
		}
		System.out.println(sum);
	}
}
