package skillbuilder.java8.set1;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstNonRepeatedCharacter {

	/**
	 * Find first non-repeated character in a string?
	 */
	public static void main(String[] args) {
		String inputString = "stress".replaceAll("\\s+", "").toLowerCase();
		// approach using stream
		approach1(inputString);

		//approach using core java
		coreJavaApproach1(inputString);
		coreJavaApproach2(inputString);
		/**
		 * OUTPUT: First Non repeated character is:j,count:1
		 */

	}

	private static void approach1(String inputString) {
		LinkedHashMap<String, Long> characterWithCount = Arrays.stream(inputString.split(""))
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
		Entry<String, Long> entry = characterWithCount.entrySet().stream().filter(i -> i.getValue() == 1).findFirst()
				.get();
		System.out.println("First Non repeated character is:" + entry.getKey());
	}

	private static void coreJavaApproach1(String s){
		s=s.replaceAll("\\s","").toLowerCase().trim();
		Character nonReap=s.charAt(0);
		char[] chars=s.toCharArray();
		for(int i=0;i<s.length();i++){
			for (int j=i+1;j<chars.length;j++){
				if(nonReap==chars[j]){
					nonReap=s.charAt(i+1);
					break;
				}
			}
		}
		System.out.println("First non repeated approach 1="+nonReap);
	}

	private static void coreJavaApproach2(String s){
		Map<Character,Integer> counter=new LinkedHashMap<>();
		for(char c:s.toCharArray()) {
			counter.put(c, counter.getOrDefault(c, 0) + 1);
		}
			for(Map.Entry<Character,Integer> mp:counter.entrySet()){
				if(mp.getValue()==1){
					System.out.println("First non repeated approach 2="+mp.getKey());
					break;
				}
			}
	}

}
