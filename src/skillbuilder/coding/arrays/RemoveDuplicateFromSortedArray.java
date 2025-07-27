package skillbuilder.coding.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicateFromSortedArray {
    /**
     * Remove duplicate from sorted array
     */
    public static void main(String[] args) {
        int[] arr={2,2,2,2,2};
        // approach 1 and approach 2 both are brute force
        System.out.println(Arrays.toString(removeDup1(arr)));
        removeDup2(arr);

        System.out.println(removeDuplicates(arr)); // GFG //https://www.geeksforgeeks.org/dsa/remove-duplicates-sorted-array/
        // two-pointer optimize
        removeDup3(arr); //https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
        /**
         OUTPUT:
         [2]
         [2]
         [2]
         [2, 2, 2, 2, 2]
         */
    }

    public static int[] removeDup1(int[] arr){
    int count=1; // count is created to know how many unique elements present in the input array so with those count the new array should be created
        // of that size
      for(int i=1;i<arr.length;i++){
          if(arr[i]!=arr[i-1])
              count++;
      }
      int[] n=new int[count];
      n[0]=arr[0];
      int pointer=1; // because at index 0 we already have our first unique element
        for(int i=1;i<arr.length;i++){
            if(arr[i]!=arr[i-1] && pointer<n.length){
                n[pointer]=arr[i];
                pointer++;
            }
        }
        return n;
    }
    public static void removeDup2(int[] arr){
        Set<Integer> unique=new HashSet<>();
        for (int i:arr){
            unique.add(i);
        }
        arr = unique.stream().mapToInt(i -> i).toArray();
        System.out.println(Arrays.toString(arr));
    }

    private static void removeDup3(int[] arr) {
    int pointer=1;
    for (int i=1;i<arr.length;i++){
        if(arr[i]!=arr[i-1]){
            arr[pointer]=arr[i];
            pointer++;
        }
    }
        System.out.println(Arrays.toString(arr));
    }
    static ArrayList<Integer> removeDuplicates(int[] arr) {
        // code here
        int count=1; // count is created to know how many unique elements present in the input array so with those count the new array should be created
        // of that size
        for(int i=1;i<arr.length;i++){
            if(arr[i]!=arr[i-1])
                count++;
        }
        int[] n=new int[count];
        ArrayList<Integer> out=new ArrayList<>();
        n[0]=arr[0];
        out.add(n[0]);
        int pointer=1; // because at index 0 we already have our first unique element
        for(int i=1;i<arr.length;i++){
            if(arr[i]!=arr[i-1] && pointer<n.length){
                n[pointer]=arr[i];
                pointer++;
                out.add(arr[i]);
            }
        }
        return out;
    }
}
