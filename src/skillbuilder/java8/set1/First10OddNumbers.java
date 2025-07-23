package skillbuilder.java8.set1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static skillbuilder.java8.set1.ExtractDuplicateElement.approach2;

public class First10OddNumbers {

	/**
	 * First 10 odd numbers
	 */
	public static void main(String[] args) {
		// solution using Java Stream approach
		approach1();
		approach2();
		approach3();
		// Solution using Core Java approach
		coreJavaApproach1();
		coreJavaApproach2();
		/**
		 * OUTPUT: [1, 3, 5, 7, 9, 11, 13, 15, 17, 19]
		 */
	}

	private static void approach1() {
//		IntStream.iterate(start, next) generates an infinite stream.
//		limit(10) ensures only 10 numbers are taken.
//		boxed() converts int to Integer. from IntStream to Stream<Integer> so we can use toList() function otherwise the toList() method is not available in IntStream
		List<Integer> oddNumbers = IntStream.iterate(1, i -> i + 1).filter(i -> i % 2 != 0).limit(10).boxed()
				.collect(Collectors.toList());
		System.out.println(oddNumbers);
	}

	private static void approach2() {
		List<Integer> oddNumbers = IntStream.iterate(1, n -> n + 2).limit(10).boxed().toList();
		System.out.println(oddNumbers);
	}
	private static void approach3() {
		List<Integer> oddNumbers = IntStream.range(1,100).filter(n->n%2!=0).limit(10).boxed().toList();
		System.out.println(oddNumbers);
	}

	private static void coreJavaApproach1(){
		int count=1;
		List<Integer> odd=new ArrayList<>();
		int num=1;
		while (count<=10){
			if(num%2!=0){
				count++;
				odd.add(num);
			}
			num++;
		}
		System.out.println(odd);
	}
	private static void coreJavaApproach2(){
		List<Integer> oddNumbers=new ArrayList<>();
		int num=1;
		for(int i=0;i<10;i++){
			oddNumbers.add(num);
			num=num+2;
		}
		System.out.println(oddNumbers);
	}
}
