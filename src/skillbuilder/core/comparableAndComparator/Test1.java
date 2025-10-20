package skillbuilder.core.comparableAndComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Test1 {
    public static void main(String[] args) {
        List<Integer> l1 = new ArrayList<>();
        l1.add(12);
        l1.add(2);
        l1.add(1);
        l1.add(200);
        l1.add(10);
        l1.add(12);
        System.out.println("Before sorting::" + l1);
        Collections.sort(l1);
        System.out.println("post sorting::" + l1);
        Collections.sort(l1, Comparator.reverseOrder());
        System.out.println("post reversed sorting::" + l1);
        System.out.println("-----------------------------------------");
        List<String> l2 = new ArrayList<>();
        l2.add("");
        l2.add("zoya");
        l2.add("adwitya");
        l2.add("sameer");
        l2.add("ankit");
        l2.add("kanha");
        System.out.println("Before Sorting:->" + l2);
        Collections.sort(l2);
        System.out.println("After Sorting:->" + l2);
        Collections.sort(l2, Comparator.reverseOrder());
        System.out.println("Reversed Sorting:->" + l2);
    }
}
