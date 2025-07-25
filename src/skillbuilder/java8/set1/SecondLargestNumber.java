package skillbuilder.java8.set1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;

public class SecondLargestNumber {

	/**
	 * Find second largest number in an integer array?
	 */
	public static void main(String[] args) {
		List<Integer> listOfIntegers = Arrays.asList(45, 12, 56, 15, 24, 75, 31, 89);
		// using streams
		approach1(listOfIntegers);

		// core java
		secondLargUsingCoreJava(listOfIntegers);
		secondLargUsingCoreJava2(listOfIntegers);
		/**
		 * output: 
		 * using approach 1:75
		 * using approach 2:75
		 */
	}

	private static void approach1(List<Integer> listOfIntegers) {
		Integer secLargestNum = listOfIntegers.stream().sorted(Comparator.reverseOrder()).skip(1).limit(1).findFirst()
				.get();
		System.out.println("using approach 1:" + secLargestNum);

		Integer secLargestNum2 = listOfIntegers.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
		System.out.println("using approach 2:" + secLargestNum2);
	}
	// Below is brute force approach with O(N^2) TC
	private static void secondLargUsingCoreJava(List<Integer> list){
		int max=Integer.MIN_VALUE;
		int sec=Integer.MIN_VALUE;
		int[] arr=list.stream().mapToInt(i->i.intValue()).toArray();


		for (int i = 0; i < arr.length; i++) {
			if(arr[i]>max)
				max=arr[i];
		}

		System.out.println("Max element:"+max);

		for (int i=0;i<arr.length;i++){
			if(arr[i]!=max && arr[i]<max && arr[i]>sec){
				sec=arr[i];
			}
		}

		System.out.println("Second largest element:"+sec);
		/*
		OUTPUT:
		Max element:89
		Second largest element:75
		 */
	}

	// below is optimize approach with O(n) approach in single loop only we are finishing the execution
	private static void secondLargUsingCoreJava2(List<Integer> list){
		int max=Integer.MIN_VALUE;
		int sec=Integer.MIN_VALUE;
		int[] arr=list.stream().mapToInt(i->i.intValue()).toArray();

		for (int num:arr){
			if(num>max){
				sec=max;
				max=num;
			} else if(num != max && num > sec) {
				sec = num;
			}
		}
		System.out.println("Second largest element:"+sec);
		//Second largest element:75
	}

}
