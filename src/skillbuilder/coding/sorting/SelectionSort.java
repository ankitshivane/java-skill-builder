package skillbuilder.coding.sorting;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr={13,46,24,52,24,20,9};
        selectionSort(arr);
    }

    private static void selectionSort(int[] arr) {
        int n=arr.length;
        for (int i = 0; i <= n-2 ; i++) {
            int min=i;
            for (int j = i; j <= n-1 ; j++) {
                if(arr[j]<arr[min]){
                    min=j;
                }
            }
            swap(arr,min,i);
        }
        System.out.println(Arrays.toString(arr));
    }

    private static void swap(int[] arr, int min, int i) {
        int temp=arr[min];
        arr[min]=arr[i];
        arr[i]=temp;
    }
}
