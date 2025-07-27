package skillbuilder.coding.arrays;

import java.util.Arrays;

public class LCTwoSum2 {
    /**
     * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/
     * Pattern: Two-Pointer
     */
    public static void main(String[] args) {
        int[] a={1,2,3,4,4,9,56,90};
        int target=8;
        System.out.println(Arrays.toString(twoSum(a,target))); // Accepted solution
        System.out.println(Arrays.toString(twoSumBruteForce(a,target))); // brute force but didnt worked time limit exceeded
        /*
        OUTPUT
        [4, 5]
        [4, 5]
         */
    }
    public static int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            int left=i;
            int right=i+1;
            while (left<right && right<numbers.length){
                if(numbers[left]+numbers[right]==target){
                    left++;
                    right++;
                    return new int[]{left,right};
                }
                right++;
            }
        }
        return new int[]{-1,-1};
    }

    // Below brute force solution is working but time limit is exceeding.
    public static int[] twoSumBruteForce(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j=1;j<numbers.length;j++){
                if(i!=j && numbers[i]+numbers[j]==target){
                    j++;
                    i++;
                    return new int[]{i,j};
                }
            }

        }
        return new int[]{-1,-1};
    }
}
