package skillbuilder.java8.set1;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class Practice {
    public static void main(String[] args) {
     String s="ankit";
        System.out.println(s.length()/2);
        int right=s.length()-1;
        boolean isPal=true;
        for (int left=0;left<s.length()/2;left++){
            if(s.charAt(left)!=s.charAt(right)){
                System.out.println("String is not palindrome");
                isPal=false;
                break;
            }
            right--;
        }
        if(isPal)
            System.out.println("String is palindrome");
    }
}
