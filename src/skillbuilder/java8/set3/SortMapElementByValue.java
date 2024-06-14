package skillbuilder.java8.set3;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class SortMapElementByValue {

	public static void main(String[] args) {
		String input = "aaaakkbbbz";
		Map<Character, Integer> countMap = new LinkedHashMap<>();
		for (char ch : input.toCharArray()) {
			countMap.put(ch, countMap.getOrDefault(ch, 0) + 1);
		}

		System.out.println(countMap);
		//output: {a=4, k=2, b=3, z=1}
		countMap.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(i -> {
			System.out.println("Key=" + i.getKey() + ", value=" + i.getValue());
		});
		/**
		 OUTPUT:
		Key=z, value=1
		Key=k, value=2
		Key=b, value=3
		Key=a, value=4
		 */
	}

}
