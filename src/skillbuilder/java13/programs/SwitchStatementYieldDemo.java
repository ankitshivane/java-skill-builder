package skillbuilder.java13.programs;

public class SwitchStatementYieldDemo {
    public static void main(String[] args) {
        String day = "MON";
        var result = switch (day) {
            case "MON", "TUE", "WED", "THUR", "FRI":
                yield "Weekday";
            case "SAT", "SUN":
                yield "Weekend";
            default:
                yield "Invalid";
        };
        System.out.println(result);
    }
}
