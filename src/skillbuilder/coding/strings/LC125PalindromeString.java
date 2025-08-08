package skillbuilder.coding.strings;

public class LC125PalindromeString {
    /**
     * Leedcode ques:125
     * https://leetcode.com/problems/valid-palindrome/description/
     * Pattern: Two pointer
     */
    public static void main(String[] args) {
        String s = "madam";
        System.out.println(isValidPalindrome1(s));
    }
    public static boolean isValidPalindrome1(String s) {

        s=s.toLowerCase().replaceAll("[^a-zA-Z0-9]","").trim();
        int right=s.length()-1;
        for (int left = 0; left < s.length()/2; left++) {
            if(left<right && s.charAt(left)!=s.charAt(right)){
                return false;
            }
            right--;
        }
        return true;
    }
}
