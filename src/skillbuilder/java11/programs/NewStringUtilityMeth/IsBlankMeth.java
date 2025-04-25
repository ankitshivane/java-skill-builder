package skillbuilder.java11.programs.NewStringUtilityMeth;

public class IsBlankMeth {
    /*
    Whitespace in programming (especially in Java) refers to characters used for spacing that don’t produce visible marks or symbols, but
     are used to separate tokens (like words or values) or format code.
     */
    public static void main(String[] args) {
        // CASE:1
        String st = "";
        String str = "   ";
        System.out.println(st.isBlank()); //true
        System.out.println(str.isBlank()); //true

        // CASE:2
        String st1 = null;
        try {
            System.out.println(st1.isBlank()); //java.lang.NullPointerException: Cannot invoke "String.isBlank()" because "st1" is null
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        // CASE:3
        System.out.println("Java".isBlank()); //false
        // CASE:4
        System.out.println("    \n  \r \f  \t ".isBlank());

    }
}
