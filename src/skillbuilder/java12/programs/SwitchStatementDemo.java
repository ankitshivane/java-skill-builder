package skillbuilder.java12.programs;

public class SwitchStatementDemo {
    public static void main(String[] args) {
        // CASE:1
//        traditionalSwitch();
        // CASE:2
//        switchStatementWitMultiLabel();

        // CASE:3
        /*String result = switchStatementToReturnResult();
        System.out.println(result);*/

        // CASE: 4
        testSwitch();
    }

    private static void traditionalSwitch() {
        String day = "MON";
        switch (day) {
            case "MON":
            case "TUE":
            case "WED":
            case "THUR":
            case "FRI":
                System.out.println("Its a Weekday...");
                break;
            case "SAT":
            case "SUN":
                System.out.println("Its a Weekend...");
                break;
            default:
                System.out.println("Invalid Day provided...");
                break;
        }
        System.out.println("End of Traditional switch...");
    }

    private static String switchStatementToReturnResult() {
        String day = "MON";
        var result = switch (day) {
            case "MON", "TUE", "WED", "THUR", "FRI" -> "Weekday";
            case "SAT", "SUN" -> "Weekend";
            default -> "Invalid";
        };
        return result;
    }

    private static void switchStatementWitMultiLabel() {
        String day = "MON";
        switch (day) {
            // here ->{} are optional, it will be useful if we have multi line logic then we can encapsulate in here.
            // Note: we can not use ->{} block if we are returning the value from switch expression.
            case "MON", "TUE", "WED", "THUR", "FRI" -> {
                System.out.println("Weekday");
            }
            case "SAT", "SUN" -> {
                System.out.println("Weekend");
            }
            default -> {
                System.out.println("Invalid");
            }
        }
    }


    // as you can see here we have not return the break statement still fall-through will not happen here
    private static void testSwitch() {
        int val = 10;
        switch (val) {
            case 10, 15 -> {
                System.out.println("In first loop block");
                System.out.println("small size");
            }
            case 20, 30 -> System.out.println("Medium size");
            case 35, 50 -> System.out.println("Large size");
            default -> System.out.println("invalid size");
        }
        /*
        OUTPUT:
        In first loop block
        small size
         */
    }
}