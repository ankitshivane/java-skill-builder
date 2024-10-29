package skillbuilder.java9.programs.StreamAPIImprovements;

import java.util.stream.Stream;

public class OfNullable {
    public static void main(String[] args) {
        Stream<Object> objectStream = Stream.ofNullable(null);
        objectStream.forEach(System.out::println); // The output is empty/nothing and also error.
    }
}
