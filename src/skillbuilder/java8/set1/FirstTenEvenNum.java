package skillbuilder.java8.set1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class FirstTenEvenNum {

    /**
     * Print first 10 even numbers
     */
    public static void main(String[] args) {
//using traditional approach
        coreJavaApproach1();
        coreJavaApproach2();
        coreJavaApproach3();

        // using java 8 approach 1
        List<Integer> op1 = IntStream.rangeClosed(1, 10).map(i -> i * 2).boxed().toList();
        System.out.println(op1);

        // using java 8 approach 2
        List<Integer> op2 = IntStream.iterate(2, i -> i + 2).limit(10).boxed().toList();
        System.out.println(op2);
        /**
         * Output:
         [2, 4, 6, 8, 10, 12, 14, 16, 18, 20]
         [2, 4, 6, 8, 10, 12, 14, 16, 18, 20]
         [2, 4, 6, 8, 10, 12, 14, 16, 18, 20]
         [2, 4, 6, 8, 10, 12, 14, 16, 18, 20]
         */
    }

    private static void coreJavaApproach1() {
        // this is brute force approach
        int c = 1;
        int start = 1;
        List<Integer> ls1 = new ArrayList<>();
        while (c <= 10) {
            if (start % 2 != 0) {
                start++;
                continue;
            }
            ls1.add(start);
            start++;
            c++;
        }
        System.out.println(ls1);

        // above program can be slightly optimize
        // here using below solutions the number of iterations will be reduce by doing n=n+2
        int count = 0;
        int num = 2;
        List<Integer> ls = new ArrayList<>();
        while (count < 10) {
            ls.add(num);
            count++;
            num += 2;
        }
        System.out.println(ls);
    }

    private static void coreJavaApproach2() {
        int[] evenNum = new int[10];
        for (int i = 0; i < evenNum.length; i++) {
            evenNum[i] = (i + 1) * 2;
        }
        System.out.println(Arrays.toString(evenNum));
    }

    private static void coreJavaApproach3() {
        List<Integer> ls = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            ls.add(i * 2);
        }
        System.out.println(ls);
    }

}
