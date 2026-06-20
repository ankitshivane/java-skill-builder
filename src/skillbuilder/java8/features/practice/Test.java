package skillbuilder.java8.features.practice;

import com.sun.source.tree.YieldTree;

public class Test {

    public static void main(String[] args) {
        String s = "leetcode";

        System.out.println(test1(s));
    }


    private static String test1(String s) {
        StringBuilder sb = new StringBuilder(s);
        int l = 0;
        int r = s.length() - 1;
        String vow = "aeiouAEIOU";
        while (l < r) {
            if (vow.contains(sb.charAt(l) + "") && vow.contains(sb.charAt(r) + "")) {
                char temp = sb.charAt(l);
                sb.setCharAt(l, sb.charAt(r));
                sb.setCharAt(r, temp);
                l++;
                r--;
            } else if (!vow.contains(sb.charAt(l) + "")) {
                l++;
            } else if (!vow.contains(sb.charAt(r) + "")) {
                r--;
            }
        }

        return sb.toString();
    }
}
