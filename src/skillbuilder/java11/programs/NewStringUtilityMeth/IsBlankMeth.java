package skillbuilder.java11.programs.NewStringUtilityMeth;

public class IsBlankMeth {
    public static void main(String[] args) {
        String st = "";
        String str = "   ";
        System.out.println(st.isBlank()); //true
        System.out.println(str.isBlank()); //true

        String st1 = null;
        try {
            System.out.println(st1.isBlank()); //java.lang.NullPointerException: Cannot invoke "String.isBlank()" because "st1" is null
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        System.out.println("Java".isBlank()); //false

    }
}
