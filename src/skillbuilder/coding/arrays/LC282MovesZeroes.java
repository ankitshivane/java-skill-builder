package skillbuilder.coding.arrays;

import java.lang.reflect.Array;
import java.util.Arrays;

public class LC282MovesZeroes {
    /**
     * Ques: Leetcode 282 moves zeroes to the left
     * Pattern: Two Pointer
     * @param args
     */
    public static void main(String[] args) {
        int[] nums= {0,1,0,3,4};
        LCAcceptedApproach1(nums);
        LCAcceptedApproach2(nums);
        LCAcceptedApproach3(nums);
        /*
        OUTPUT
        [1, 3, 4, 0, 0]
        [1, 3, 4, 0, 0]
        [1, 3, 4, 0, 0]
         */
    }

    private static void LCAcceptedApproach1(int[] nums) {
        int pointer=0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]!=0){
                nums[pointer]= nums[i];
//                nums[i]=0;
                pointer++;
            }
        }
        while(pointer< nums.length){
            nums[pointer]=0;
            pointer++;
        }
        System.out.println(Arrays.toString(nums));
    }

    private static void LCAcceptedApproach2(int[] nums) {
        int pointer=0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]!=0){
                nums[pointer]=nums[i];
                if(pointer!=i){
                    nums[i]=0;
                }
                pointer++;
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    private static void LCAcceptedApproach3(int[] nums) {
        int pointer=0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]!=0){
                int temp=nums[pointer];
                nums[pointer]=nums[i];
                nums[i]=temp;
                pointer++;
            }
        }
        System.out.println(Arrays.toString(nums));
    }
}