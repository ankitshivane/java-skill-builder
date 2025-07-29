package skillbuilder.java8.set4;

import java.util.Arrays;
import java.util.List;

public class Tricky1 {
    public static void main(String[] args) {
        List<String> s= Arrays.asList("mango","grape","banana","apple","blueberry");
        List<String> output = s.stream().limit(2).sorted().toList();
        System.out.println(output);

        /**
         * OUTPUT
         [grape, mango]

         * Explanation: here limit will send only mango and grape 2 allowed elements and then it will get sort and
         * grape will come first followed by mango.
         */
    }
}
