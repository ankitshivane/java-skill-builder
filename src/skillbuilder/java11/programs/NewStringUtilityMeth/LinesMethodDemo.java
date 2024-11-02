package skillbuilder.java11.programs.NewStringUtilityMeth;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LinesMethodDemo {
    public static void main(String[] args) {
        testLineMethod1();
        testLineMethod2();
        testLineMethod3();
    }

    private static void testLineMethod3() {
        String str = new String("Durga\r\nSoftware\r\nSolutions");
        Stream<String> s = str.lines();
        List<String> l = s.collect(Collectors.toList());
        System.out.println(l);// Output: [Durga, Software, Solutions]
    }

    private static void testLineMethod2() {
        String str = new String("Durga\rSoftware\rSolutions");
        Stream<String> s = str.lines();
        List<String> l = s.collect(Collectors.toList());
        System.out.println(l);// Output: [Durga, Software, Solutions]
    }

    private static void testLineMethod1() {
        String str = new String("Durga\nSoftware\nSolutions");
        Stream<String> s = str.lines();
        List<String> l = s.collect(Collectors.toList());
        System.out.println(l); // Output: [Durga, Software, Solutions]
    }
}
