package skillbuilder.java8.set1;

import java.util.stream.IntStream;

public class SumOfFirst10Num {

	/*
	 * How do you find sum of first 10 natural numbers?
	 */
	public static void main(String[] args) {
		int sum = IntStream.range(1, 11).sum();
		System.out.println(sum);
		
		/*
		 * output:
		 * 55
		 * *
		 */
	}
}
