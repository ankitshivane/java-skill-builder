package skillbuilder.coding.strings;

import java.util.HashMap;
import java.util.Map;

public class OccurrenceOfChar {
    /**
     * Ques: Count the occurrence of a character in string
     */
    public static void main(String[] args) {
        String s="java is dynamic";
        char target='a';
        countOcc1(s,target);
        countOcc2(s,target);
    }
    public static void countOcc1(String input, char target){
        int count=0;
        /*for (int i = 0; i < input.length(); i++) {
         if(input.charAt(i)==target)
             count++;
        }*/
        for (char c:input.toCharArray()){
            if(c==target)
                count++;
        }
        System.out.println(count);
    }
    public static void countOcc2(String input,char target){
        String out=input.replaceAll(String.valueOf(target),"");
        int countOfOcc = input.length() - out.length();
        System.out.println(countOfOcc);
    }
}
