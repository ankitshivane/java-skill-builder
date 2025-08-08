package skillbuilder.coding.strings;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Stack;

public class ReverseEachWordInStr {
    /**
     * Ques:  Reverse each word in string
     */
    public static void main(String[] args) {
        String input=" Reverse each word in string".trim();
        reverse1(input);
        reverse2(input);
        reverse3(input);
        reverse4(input);
    }

    private static void reverse4(String input) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (char ch : input.toCharArray()) {
            if (ch != ' ') {
                stack.push(ch);
            } else {
                while (!stack.isEmpty()) {
                    result.append(stack.pop());
                }
                result.append(" ");
            }
        }

        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        System.out.println(result.toString());
    }

    private static void reverse1(String input) {
        String[] arr = input.split("\\s");
        StringBuffer sb=new StringBuffer();

        for (String s:arr){
            char[] c=s.toCharArray();
            int right=s.length()-1;
            for (int left=0;left<right;left++){
                char temp=c[right];
                c[right]=c[left];
                c[left]=temp;
                right--;
            }

            /*for (int left = 0, right = c.length - 1; left < right; left++, right--) {
                char temp = c[right];
                c[right] = c[left];
                c[left] = temp;
            }*/
            sb.append(c).append(" ");
        }
        System.out.println(sb.toString());
    }

    private static void reverse2(String input) {
        StringBuffer sb=new StringBuffer();
        for (String s:input.split(" ")){
            sb.append(new StringBuffer(s).reverse()).append(" ");
        }
        System.out.println(sb.toString());
    }

    private static void reverse3(String input) {
        String[] arr=input.split(" ");
        StringBuffer sb=new StringBuffer();
        for (String s:arr){
            for (int i = s.length()-1; i >=0 ; i--) {
                sb.append(s.charAt(i));
            }
            sb.append(" ");
        }
        System.out.println(sb.toString());
    }

}
