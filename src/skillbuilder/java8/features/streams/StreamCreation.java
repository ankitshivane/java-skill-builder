package skillbuilder.java8.features.streams;

import java.util.Arrays;
import java.util.stream.Stream;

public class StreamCreation {
    public static void main(String[] args) {
        Stream<Integer> iterate = Stream.iterate(1, n -> n <= 2000, n -> n * 2);

    }
}
