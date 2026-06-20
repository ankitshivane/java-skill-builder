package skillbuilder.coding.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveDuplicate {
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 3, 4, 4, 5, 6, 6, 6};
        System.out.println(Arrays.toString(removeDuplicates1(arr)));
        System.out.println(Arrays.toString(solution2(arr, arr.length)));
        System.out.println(Arrays.toString(solution3(arr, arr.length)));
    }

    // without any extra space
    private static int[] solution3(int[] arr, int n) {
        int i=0;
        for (int j = 1; j < n; j++) {
            if(arr[i]!=arr[j]){
                i++;
                arr[i]=arr[j];
            }
        }
        return arr;
    }
    // optimized solution with extra space
    private static int[] solution2(int[] arr, int n) {

        if (arr == null) {
            return arr;
        }
        List<Integer> result = new ArrayList<>();
        result.add(arr[0]);


        for (int i = 1; i < n; i++) {
            if (arr[i] != arr[i - 1]) {
                result.add(arr[i]);
            }
        }

        int[] res = new int[result.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = result.get(i);
        }
        return res;
    }

// brute force solution with extra space
    private static int[] removeDuplicates1(int[] arr) {
        int n = arr.length;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            res.add(arr[i]);
            for (int j = i + 1; j < n; j++) {
                if (arr[i] == arr[j]) {
                    continue;
                } else {
                    i = j - 1;
                    break;
                }
            }
        }

        int[] result = new int[res.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = res.get(i);
        }
        return result;
    }

}
