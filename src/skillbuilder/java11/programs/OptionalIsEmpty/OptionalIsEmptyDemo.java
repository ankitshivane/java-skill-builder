package skillbuilder.java11.programs.OptionalIsEmpty;

import java.util.List;
import java.util.Optional;

public class OptionalIsEmptyDemo {
    public static void main(String[] args) {
        String val = null;
        System.out.println(Optional.ofNullable(val).isEmpty()); // true
        System.out.println(Optional.ofNullable(val).isPresent()); // false

        String name = "Ankit Shivane";
        System.out.println(Optional.ofNullable(name).isEmpty()); //false
        System.out.println(Optional.ofNullable(name).isPresent()); //true

        List<Integer> nums = null;
        Optional.ofNullable(nums).stream().forEach(System.out::println); //prints nothing, do not throw any error

    }
}
