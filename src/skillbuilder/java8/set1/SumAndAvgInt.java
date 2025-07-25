package skillbuilder.java8.set1;

import java.util.Arrays;

public class SumAndAvgInt {
/*
 *Given an integer array, find sum and average of all elements? 
 */
	public static void main(String[] args) {
		int[] a = new int[] {45, 12, 56, 15, 24, 75, 31, 89};
		int sum = Arrays.stream(a).sum();
		double asDouble = Arrays.stream(a).average().getAsDouble();
		System.out.println("Sum:"+sum);
		System.out.println("Average:"+asDouble);
		/*
		OUTPUT:
		Sum:347
		Average:43.375
		 */
	}
}
