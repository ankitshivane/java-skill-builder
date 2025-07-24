package skillbuilder.java8.set4;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class MultipleOfFive {
    public static void main(String[] args) {
        // stream approach
        approach1();
        approach2();
        // core java approach
        approach3();
    }

    private static void approach3() {
        List<Integer> multiple=new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            multiple.add(i*5);
        }
        System.out.println(multiple);
    }

    private static void approach2() {
        List<Integer> list = IntStream.iterate(5, i -> i+ 5)
                .limit(10)
                .boxed()
                .toList();
        System.out.println(list);
    }

    private static void approach1() {
        List<Integer> multipleOfFive = IntStream.range(1, 11)
                .map(m -> m * 5)
                .boxed()
                .toList();
        System.out.println(multipleOfFive);
    }
}
