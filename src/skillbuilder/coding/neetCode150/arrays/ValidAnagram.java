package skillbuilder.coding.neetCode150.arrays;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class ValidAnagram {
    public static void main(String[] args) {
        String s = "bbcc";
        String t = "ccbc";
        System.out.println(isAnagram(s, t));
        System.out.println(isAnagram1(s, t));
    }

    public static boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        Map<Character,Integer> mp=new LinkedHashMap<>();
        for(char c:s.toCharArray()){
            mp.put(c,mp.getOrDefault(c,0)+1);
        }

        for(char c:t.toCharArray()){
            if(mp.containsKey(c) && mp.get(c)>0){
                mp.put(c,mp.get(c)-1);
            }else{
                return false;
            }
        }
        return true;
    }

    public static boolean isAnagram1(String s, String t) {
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        Arrays.sort(sArr);
        Arrays.sort(tArr);
        return Arrays.equals(sArr, tArr);
    }

    public static boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> mp = new LinkedHashMap<>();
        for (char c : s.toCharArray()) {
            if (mp.containsKey(c)) {
                mp.put(c, mp.get(c) + 1);
            } else {
                mp.put(c, 1);
            }

        }
        for (char c : t.toCharArray()) {
            if (mp.containsKey(c) && mp.get(c) > 0) {
                mp.put(c, mp.get(c) - 1);
            } else {
                return false;
            }
        }


        return true;
    }
}