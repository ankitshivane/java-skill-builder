package skillbuilder.coding.slidingWindow;

import java.util.ArrayList;
import java.util.List;

public class AvgOfEverySubarray {
    /**
     * Average of Every Subarray of Size k
     */
    public static void main(String[] args) {
        int[] arr={2, 1, 5, 1, 3, 2};
//        int[] arr={-1};
        int k=1;
        avgOfSubarray(arr,k);
        avgOfSubarray2(arr,k);
    }

    private static void avgOfSubarray2(int[] nums, int k) {
        int left=0;
        List<Integer> avgs=new ArrayList<>();
        int sum=0;
        for (int right = 0; right < nums.length; right++) {
            sum+=nums[right];
            if(right>=k){
                // shrink left
                sum-=nums[left];
                left++;
            }
            if(right>=k-1){
                avgs.add(sum/k);
            }
        }
        System.out.println(avgs);
    }



    private static void avgOfSubarray(int[] nums, int k) {
        ArrayList<Double> avg=new ArrayList<>();
        int windowSum=0;
        int left=0;
        double maxAvg=Integer.MIN_VALUE;
        for (int right = 0; right < nums.length; right++) {
            windowSum+=nums[right];
            if(right>=k-1){
                double avgs = (double) windowSum / (double) k;
                avg.add(avgs);
                if (avgs>maxAvg)
                    maxAvg=avgs;
                windowSum-=nums[left];
                left++;
            }
        }
        System.out.println(avg+", Max Avg="+maxAvg);
    }
}
