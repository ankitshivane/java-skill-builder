package skillbuilder.java8.set1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ReverseAnIntArray {
	/*
	 * Reverse an integer array
	 */
	public static void main(String[] args) {
		int[] array = new int[] { 5, 1, 7, 3, 9, 6 };
		approach1(array);
		approach2(array);
		approach3(array);
		coreJavaApproach1(array);
	}

	private static void approach1(int[] array){
		List<Integer> reversed = Arrays.stream(array)
				.boxed()
				.collect(Collectors.toCollection(ArrayList::new));

		Collections.reverse(reversed);
		System.out.println(reversed);
	}
	private static void approach2(int[] array) {
		int[] reversedArray = IntStream.rangeClosed(1, array.length).map(i -> array[array.length - i]).toArray();
		System.out.println(Arrays.toString(reversedArray));
	}

	private static void approach3(int[] array) {
		List<Integer> list = IntStream.range(0, array.length)
				.mapToObj(i -> (Integer) array[array.length-i-1])
				.toList();
		System.out.println(list);
	}
	private static void coreJavaApproach1(int[] array1){
		int[] array=array1;
		for (int i = 0; i < array.length / 2; i++) {
			int temp = array[i];
			array[i] = array[array.length - 1 - i];
			array[array.length - 1 - i] = temp;
		}

		System.out.println(Arrays.toString(array));

	}
}