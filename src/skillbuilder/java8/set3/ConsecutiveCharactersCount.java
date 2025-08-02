package skillbuilder.java8.set3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ConsecutiveCharactersCount {
	public static void main(String[] args) {
		String input = "aaabbdbccdddda";

		String result = IntStream.range(0, input.length())
				.mapToObj(i -> new int[] { input.charAt(i), i == 0 || input.charAt(i) != input.charAt(i - 1) ? 1 : 0 })
				.collect(ArrayList<int[]>::new, (list, arr) -> {
					if (!list.isEmpty() && arr[1] == 0) {
						list.get(list.size() - 1)[1]++;
					} else {
						list.add(arr);
					}
//				}, ArrayList::addAll).stream().map(arr -> (char) arr[0] + String.valueOf(arr[1])).collect(Collectors.toList());
				}, ArrayList::addAll).stream().map(arr -> new StringBuilder().append((char)arr[0]).append(arr[1]).toString()).collect(Collectors.joining());


//		result.forEach(System.out::println);
		System.out.println(result);
	}
}
