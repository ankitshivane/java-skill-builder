package skillbuilder.coding.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReverseInt {
    public static void main(String[] args) {
        int num = 12345;
        List<Integer> digits = new ArrayList<>();
        List<Integer> digits1 = reverseInt(num, digits);
        int[] arr=new int[digits1.size()];

        for (int i = 0; i < digits1.size(); i++) {
        arr[i]=digits1.get(i);
        }
        System.out.println(Arrays.toString(arr));
    }

    private static List<Integer> reverseInt(int num,List<Integer> digits) {
        int reversed = 0;
        while (num != 0) {
            int remainder = num % 10;
            reversed = reversed * 10 + remainder;
            num = num / 10;
        }
        while (reversed != 0) {
            int remainder = reversed % 10;
            digits.add(remainder);
            reversed = reversed / 10;
        }
        return digits;
    }
}
