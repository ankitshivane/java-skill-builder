package skillbuilder.coding.arrays;

import java.util.HashMap;
import java.util.Map;

public class TwoSumLC {
    /**
     * Leetcode questopm easy
     * https://leetcode.com/problems/two-sum/description/
     */
    public static void main(String[] args) {
        int[] nums={3,3};
        int target=6;
        TwoSumLC ob=new TwoSumLC();
//        int[] ans=ob.twoSum(nums,target);
        int[] ans=twoSumOptimize(nums,target);
        for(int i: ans ){
            System.out.print(i+" ");
        }
    }
    // Brute force
    public  int[] twoSum(int[] nums, int target) {
        for(int i=0;i<nums.length;i++){
            for(int j=(i+1);j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{-1,-1};
    }

    // optimize approach
    public static int[] twoSumOptimize(int[] nums,int target){
        Map<Integer,Integer> mp=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int x=target=nums[i];
            if(mp.containsKey(x)){
                return new int[]{mp.get(x),i};
            }
            mp.put(nums[i],i);
        }
        return new int[]{-1,-1};
    }
}
