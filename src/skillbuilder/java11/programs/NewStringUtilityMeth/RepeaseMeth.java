package skillbuilder.java11.programs.NewStringUtilityMeth;

public class RepeaseMeth {
    public static void main(String[] args) {
        // METHOD: 1
        String str = "Ankit";
        String repeated = str.repeat(5);
        System.out.println(repeated); //OUTPUT: AnkitAnkitAnkitAnkitAnkit
        try{
            System.out.println("Negative repeatation: "+str.repeat(-3));
// output exception:            java.lang.IllegalArgumentException: count is negative: -3
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        System.out.println("Zero repeatation:"+str.repeat(0)); //Output: Zero repeatation:


    }
}
