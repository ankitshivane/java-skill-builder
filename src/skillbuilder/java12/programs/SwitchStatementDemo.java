package skillbuilder.java12.programs;

public class SwitchStatementDemo {
    public static void main(String[] args) {
        // CASE:1
//        traditionalSwitch();
        // CASE:2
//        switchStatement1();

        // CASE:3
        String result = switchStatementToReturnResult();
        System.out.println(result);
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
        return switch (day) {
            case "MON", "TUE", "WED", "THUR", "FRI" -> "Weekday";
            case "SAT", "SUN" -> "Weekend";
            default -> "Invalid";
        };
    }
}