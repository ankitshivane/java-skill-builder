package skillbuilder.java8.set3;

import java.util.*;

public class SortMapWithNullValues {
	/**
	 * Question: for the given map object sort the details based on Values of Map and handle null values in sorting
	 */
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
		map.put("Alice", 30);
		map.put("Bob", null);
		map.put("Charlie", 35);
		map.put("David", null);
		map.put("Eve", 32);

		// Sort by values handling null values
		Map<String, Integer> sortedMap = map.entrySet().stream()
				.sorted(Comparator.comparing(Map.Entry::getValue, Comparator.nullsLast(Integer::compareTo)))
				.collect(LinkedHashMap::new, (map2, entry) -> map2.put(entry.getKey(), entry.getValue()), Map::putAll);

		// Print the sorted map
		System.out.println("Sorted Map by Value (nulls first):");
		sortedMap.forEach((key, value) -> System.out.println(key + " : " + value));
		/*
		 OUTPUT:
		 	Sorted Map by Value (nulls first):
			Alice : 30
			Eve : 32
			Charlie : 35
			Bob : null
			David : null

		 */
	}
}
