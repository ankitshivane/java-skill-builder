package skillbuilder.java12.programs;

import java.util.List;
import java.util.stream.Collectors;

public class TeardownCollector {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        var stats = numbers.stream()
                .collect(Collectors.teeing(
                        Collectors.summingInt(i -> i),
                        Collectors.counting(),
                        (sum, count) -> "Average: " + (sum / count)
                ));
        System.out.println(stats); // Average: 3

    }
}
