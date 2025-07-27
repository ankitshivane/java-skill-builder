package skillbuilder.coding.strings_programs;

import java.util.Arrays;

public class ReverseStringGFG {
    /**
     * Que:
     * https://www.geeksforgeeks.org/problems/reverse-a-string/1
     * Pattern: Two Pointer
     * we reverse a string in place
     */
    public static void main(String[] args) {
        String s = "Geeks";
        System.out.println(reverseAStringApproach1(s)); // Accepted at GFG site
        System.out.println(reverseStringBruteForce1(s));
        /*
        OUTPUT
        skeeG
        skeeG
         */
    }

    private static String reverseAStringApproach1(String s) {
        int right=s.length()-1;
        char[] chars=s.toCharArray();
        for(int left=0;left<chars.length/2;left++){
            if(left<right){
                char temp=chars[left];
                chars[left]=chars[right];
                chars[right]=temp;
            }
            right--;
        }
        return new String(chars);
    }

    public static String reverseStringBruteForce1(String s){
        String rev="";
        for(int i=s.length()-1;i>=0;i--){
            rev+=s.charAt(i);
        }
        return rev;
    }
}
