package skillbuilder.coding.slidingWindow;

import java.util.ArrayList;

public class KSizedMaxSumSubArray {
    /**
     * Platform: GFG
     * K Sized Subarray Maximum
     * https://www.geeksforgeeks.org/problems/maximum-of-all-subarrays-of-size-k3101/1
     * Pattern: Sliding Window
     */
    public static void main(String[] args) {
        int[] arr={1, 2, 3, 1, 4};
        int k=3;
        ArrayList<Integer> result1 = findMaxSumSubarray1(arr, k);
        System.out.println(result1);
        System.out.println(arr.length-3);
    }

    // brute force solution O(n^2)
    private static ArrayList<Integer> findMaxSumSubarray1(int[] arr, int k) {
        ArrayList<Integer> al=new ArrayList<>();
        for (int i = 0; i <= arr.length-k ; i++) {
            int max=Integer.MIN_VALUE;
            for (int j = i; j < i+k ; j++) {
                if(arr[j]>max)
                {
                    max=arr[j];
                }
            }
            al.add(max);
        }
        return al;
    }

}
