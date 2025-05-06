package skillbuilder.core.java;

import java.util.Arrays;

public class Enum1 {
    public static void main(String[] args) {
//        simpleEnum1();
//        enumDemo2();
        enumWithSwitchDemo();
    }

    private static void simpleEnum1() {
        Days wed = Days.WED;
        System.out.println(wed);
        if (wed == Days.WED)
            System.out.println("its a wed");
    }

    private static void enumDemo2() {
        String name = Status.NEW.name();
        Status aNew = Status.valueOf("NEW");
        Status[] values = Status.values();
        System.out.println(name);
        System.out.println(aNew);
        System.out.println(Arrays.toString(values));
        System.out.println(Status.NEW.getDescription());
        System.out.println(Status.CLOSED.getDescription());
    }

    private static void enumWithSwitchDemo() {
        Status newStat = Status.NEW;
        switch (newStat) {
            case NEW -> System.out.println("new..");
            case COMPLETED -> System.out.println("completed");
            default -> System.out.println("Invalid");
        }
    }
}

enum Days {
    SUN, MON, TUE, WED;
}

enum Status {
    NEW("New Ticket"),
    IN_PROGRESS("Work Started"),
    COMPLETED("Task Done"),
    CLOSED("Ticket Closed");
    private String description;

    Status(String statusDesc) {
        this.description = statusDesc;
    }

    public String getDescription() {
        return this.description;
    }
}