package skillbuilder.coding.arrays;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.stream.Collectors;

public class LC344ReverseArrStr {
    /**
     * Ques: https://leetcode.com/problems/reverse-string/description/
     * leetcode
     * Pattern: Two Pointer
     * swap in place
     */
    public static void main(String[] args) {
        String[] s ={"h","e","l","l","o"};
        char[] c ={'h','e'};

        reverse1(s);
        reverse2(c);
    }

    private static void reverse2(char[] s) {
        int right=s.length-1;
        for(int left=0;left<s.length/2;left++){
            if(left<right){
                char temp=s[left];
                s[left]=s[right];
                s[right]=temp;
            }
            right--;
        }
        System.out.println(new String(s));
    }

    private static void reverse1(String[] s) {
        int right=s.length-1;
        for(int left=0;left<s.length/2;left++){
            if(left<right){
                String temp=s[left];
                s[left]=s[right];
                s[right]=temp;
            }
            right--;
        }
//        System.out.println(Arrays.stream(s).collect(Collectors.joining()));
        System.out.println(Arrays.toString(s));
    }
}
