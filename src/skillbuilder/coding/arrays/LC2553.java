package skillbuilder.coding.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC2553 {
    public static void main(String[] args) {
        int[] nums = {13, 25, 83, 77};
        System.out.println(Arrays.toString(separateDigit(nums)));
    }

    private static int[] separateDigit(int[] nums) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String s = String.valueOf(nums[i]);
            for (int j = 0; j < s.length(); j++) {
                list.add(Integer.parseInt(s.charAt(j) + ""));
            }
        }
        int[] arr = new int[list.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }
}
