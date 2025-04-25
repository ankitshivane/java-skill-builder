package skillbuilder.java12.programs;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class CompactNumberFormattingDemo {
    public static void main(String[] args) {
        convertNormalToCompactNum();
        convertNormalToCompactNumInLongForm();
        convertNormalToCompactNumInLongFormToNormalNumber();
        convertNormalToCompactNumInShortFormToNormalNumber();
    }

    private static void convertNormalToCompactNum() {
        System.out.println("Converting value from Normal number to Compact Number in Short form");
        NumberFormat shortForm = NumberFormat.getCompactNumberInstance(Locale.US, NumberFormat.Style.SHORT);
        System.out.println("1000 ----> " + shortForm.format(1000));
        System.out.println("10000 ----> " + shortForm.format(10000));
        System.out.println("100000 ----> " + shortForm.format(100000));
        System.out.println("1000000 ----> " + shortForm.format(1000000));
    }

    private static void convertNormalToCompactNumInLongForm() {
        System.out.println("Converting value from Normal number to Compact Number in Long form");
        NumberFormat shortForm = NumberFormat.getCompactNumberInstance(Locale.US, NumberFormat.Style.LONG);
        System.out.println("1000 ----> " + shortForm.format(1000));
        System.out.println("10000 ----> " + shortForm.format(10000));
        System.out.println("100000 ----> " + shortForm.format(100000));
        System.out.println("1000000 ----> " + shortForm.format(1000000));
    }

    private static void convertNormalToCompactNumInLongFormToNormalNumber() {
        System.out.println("Converting value from Long Form to Normal Number");
        NumberFormat numFormat = NumberFormat.getCompactNumberInstance(Locale.US, NumberFormat.Style.LONG);
        try {
            System.out.println("1 thousand -----> " + numFormat.parse("1 thousand"));
            System.out.println("10 thousand ----> " + numFormat.parse("10 thousand"));
            System.out.println("100 thousand ---> " + numFormat.parse("100 thousand"));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    private static void convertNormalToCompactNumInShortFormToNormalNumber() {
        System.out.println("Converting value in Short Form to Normal Number");
        NumberFormat numFmt = NumberFormat.getCompactNumberInstance
                (new Locale("en", "US"), NumberFormat.Style.SHORT);
        try {
            System.out.println("1k -----> " + numFmt.parse("1k"));
            System.out.println("10k ----> " + numFmt.parse("10k"));
            System.out.println("100k ---> " + numFmt.parse("100k"));

        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
    /*
    OUTPUT:
Converting value from Normal number to Compact Number in Short form
1000 ----> 1K
10000 ----> 10K
100000 ----> 100K
1000000 ----> 1M
Converting value from Normal number to Compact Number in Long form
1000 ----> 1 thousand
10000 ----> 10 thousand
100000 ----> 100 thousand
1000000 ----> 1 million
Converting value from Long Form to Normal Number
1 thousand -----> 1000
10 thousand ----> 10000
100 thousand ---> 100000
Converting value in Short Form to Normal Number
1k -----> 1
10k ----> 10
100k ---> 100

     */
}
