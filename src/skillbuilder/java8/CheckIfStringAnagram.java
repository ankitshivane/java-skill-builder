package skillbuilder.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CheckIfStringAnagram {

	public static void main(String[] args) {
//		Map<String, String> hm=new HashMap<>();
////		new ArrayList<>();
//		Map<ArrayList, String> hm2=new HashMap<>();
//		ArrayList<String> l=new ArrayList<>();
//		l.add("ss");
//		hm2.put(l, "d");
//		System.out.println(hm2);

		/*
		 * Java 8 program to check if two strings are anagrams or not?
		 */
		String d="hgbdcysa";
		String s1 = "RaceCkar";
		String s2 = "CarRace";
		//get sorted string using approach 1
		String s1Modified = s1.chars().mapToObj(i -> (char) i).sorted(Comparator.naturalOrder()).map(String::valueOf)
				.collect(Collectors.joining());
		System.out.println("S1 after sorting:"+s1Modified);
		//get sorted string using approach 2
		String s2Approach2 = Stream.of(s2.split("")).sorted().peek(i -> System.out.print(i))
				.collect(Collectors.joining());
		System.out.println();
		if(s1Modified.equalsIgnoreCase(s2Approach2)) {
			System.out.println("Both are anagram of each other");
		}else {
			System.out.println("Not an anagram");
		}
//		System.out.println(s2Approach2);
		
//		char[] arr=d.toCharArray();
//		Arrays.sort(arr);
//		System.out.print("sorting using char array:");
//		for(Character c:arr) {
//			System.out.print(c);	
//		}
//		System.out.println();
//		System.out.println(new StringBuffer(s1).reverse());
		
	}

}
