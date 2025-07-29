package skillbuilder.coding.sorting;

import java.util.Arrays;

public class BubbleSortAlgorithm {
    public static void main(String[] args) {
        int[] arr={5, 3, 8, 4, 2};
        bubbleSort1(arr);
    }

    /**
     * Bubble Sort Algorithm
     * Purpose: Sort an array in ascending order by repeatedly comparing
     * adjacent elements and swapping them if they're in wrong order
     *
     * @param arr - the array to be sorted
     */
    private static void bubbleSort1(int[] arr) {
        int n=arr.length; // Get the size of array

        // Outer loop: Controls the number of passes We need (n-1) passes because after each pass,
        // one element reaches its correct position
        for (int i=0;i<n-1;i++){

            // Flag to check if any swapping happened in this pass
            // This helps us optimize - if no swaps occur, array is already sorted
            boolean swapped=false;

            // Inner loop: Compare adjacent elements in current pass
            // (n - i - 1) because after each pass, the largest element
            // moves to the end, so we don't need to check it again
            for (int j=0;j<n-i-1;j++){

            if(arr[j]>arr[j+1]){
                int temp=arr[j+1];
                arr[j+1]=arr[j];
                arr[j]=temp;
                swapped=true;
            }
            }
            // Optimization: If no swapping occurred in this entire pass,
            // it means the array is already sorted, so we can stop early
            if(!swapped) break;
        }

        System.out.println(Arrays.toString(arr));
    }
}
