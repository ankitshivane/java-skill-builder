package skillbuilder.core.equalsAndHashCode.hashCode;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Person {
    String name;
    int rollno;

    Person(String name, int rollno) {
        this.name = name;
        this.rollno = rollno;
    }

    public static void main(String[] args) {
        Set<Person> set = new HashSet<>();
        set.add(new Person("ankit", 1));
        System.out.println(set.contains(new Person("ankit", 1))); // true

        /** OUTPUT:
         Person class hashCode() method invoked
         Person class hashCode() method invoked
         Person class equals() method invoke
         true
         */
        /*
        here in the above output first hashCode() method invoke because we are calling set.add() which internally calls hashCode() for finding bucket and put the value in it.
        and the second hashCode() method invoke by contains() method to find the correct bucket and equals() method to check the Object equality that is why the output is true,
        If you override hashCode() but not equals() then output will be false, because then parent means Object class equals() method will be invoke and that is meant for reference comparison.
         */
    }

    @Override
    public boolean equals(Object o) {
        System.out.println("Person class equals() method invoke");
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return rollno == person.rollno && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        System.out.println("Person class hashCode() method invoked");
        return Objects.hash(name, rollno);
    }
}
