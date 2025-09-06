package skillbuilder.coding.slidingWindow;

public class MaxSumOfSubArray {
    /**
     * Ques: Find the max sum of the given subarray
     *
     */

    public static void main(String[] args) {
        int[] arr={2,1,3,9,6,2,7};
        int k=3;
        maxSumOfSubArray(arr,k);
        maxSumOfSubArraySlidingWindow(arr,k);
    }

    /*
   Optimize approach using sliding Window
     */
    private static void maxSumOfSubArraySlidingWindow(int[] arr, int k) {
        int max=Integer.MIN_VALUE;
        int windowSum=0;
        int left=0;
        for (int i = 0; i < arr.length; i++) {
            windowSum+=arr[i];
            if(i >= k-1){
                if(windowSum>=max)
                    max=windowSum;

                windowSum-=arr[left];
                left++;
            }
        }

        System.out.println(max);
    }

    /* Brute force approach O(n^2)*/
    private static void maxSumOfSubArray(int[] arr, int k) {
        int max=Integer.MIN_VALUE;
        for (int i = 0; i <=arr.length-k; i++) {
            int sum=0;
            for (int j = i; j <i+k ; j++) {
                sum=sum+arr[j];
            }
            if(sum>max)
                max=sum;
        }
        System.out.println(max);
    }

}
