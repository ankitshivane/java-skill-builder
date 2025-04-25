package skillbuilder.java11.programs.OptionalIsEmpty;

import java.util.Optional;

public class OptionalIsEmptyDemo {
    public static void main(String[] args) {
        String val = null;
        System.out.println(Optional.ofNullable(val).isEmpty()); // true
        System.out.println(Optional.ofNullable(val).isPresent()); // false


    }
}
