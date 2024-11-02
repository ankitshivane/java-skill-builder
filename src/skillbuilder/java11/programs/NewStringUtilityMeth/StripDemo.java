package skillbuilder.java11.programs.NewStringUtilityMeth;

public class StripDemo {
    public static void main(String[] args) {
        String str = " Java is Cool ";
        System.out.println("Before using strip:" + str);
        String output = str.strip();
        System.out.println("After using strip:" + output);
        /*
        OUTPUT:
        Before using strip: Java is Cool
        After using strip:Java is Cool
         */

        testStripLeading();
        testStripTrailing();
    }

    private static void testStripTrailing() {
        String str = new String("   Durga Software Solutions   ");
        String str1 = str.stripTrailing();
        System.out.println("Test stripTrailing():"+str1); // output: Test stripTrailing():   Durga Software Solutions
    }

    public static void testStripLeading() {
        String str = new String("   Durga Software Solutions   ");
        String str1 = str.stripLeading();
        System.out.println(str1);
        //OUTPUT: Durga Software Solutions
        // here it has removed the leading spaces and kept the trailing spaces as it is.
    }
}
