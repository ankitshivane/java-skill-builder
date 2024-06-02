package skillbuilder.java8.set3;

import java.util.stream.IntStream;

public class PrintSumOfNum {
	/**
	 * Write a Java program to display numbers b/w 100-200, whose sum of first and
	 * third digit is equal to the middle. Ex:- 121,132,143,165,176,...
	 */
	public static void main(String[] args) {
		IntStream.rangeClosed(100, 200).filter(PrintSumOfNum::isValidSum)
		.forEach(i -> {
			System.out.println("Num:" + i);
		});
	}

	public static boolean isValidSum(int num) {
		int firstDigit = num / 100;
		int middleDigit = (num / 10) % 10;
		int thirdDigit = num % 10;
		return (firstDigit + thirdDigit) == middleDigit;

	}

}
