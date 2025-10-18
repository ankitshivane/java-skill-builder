package skillbuilder.core.equalsAndHashCode.hashCode;

import java.util.HashSet;
import java.util.Set;

public class Student {
    String name;

    public Student(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        Set<Student> set = new HashSet<>();
        set.add(new Student("ankit"));
        System.out.println(set.contains(new Student("ankit"))); // false
    }
}
