package skillbuilder.coding.strings;

import java.util.HashSet;
import java.util.Set;

public class RemoveDupCharFromStr {
    /**
     * Remove Duplicate Character from string
     */
    public static void main(String[] args) {
        String in="bananas";
        Set<Character> unique=new HashSet<>();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<in.length();i++){
            // here add() method of set return false if it is a duplicate element in Set and don't try to add it.
            // add() returns true if it an unique element
            if(unique.add(in.charAt(i))){
                sb.append(in.charAt(i));
            }
        }
        System.out.println(sb.toString());
    }
}
