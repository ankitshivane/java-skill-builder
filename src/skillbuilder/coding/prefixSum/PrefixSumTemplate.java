package skillbuilder.coding.prefixSum;

import java.util.Arrays;

public class PrefixSumTemplate {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        int n = arr.length;
        System.out.println(Arrays.toString(prefixSum(arr, n)));
    }

    private static int[] prefixSum(int[] arr, int n) {
        int[] sumArr = new int[n];
        sumArr[0] = arr[0];
        for (int i = 1; i < n; i++) {
            sumArr[i] = arr[i] + sumArr[i - 1];
        }
        return sumArr;
    }
}
