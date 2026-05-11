package skillbuilder.indepth.record.taskbasedlearning;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        Test test = new Test();
        // uncomment each method and test it out.
//        test.task1();
//        test.task2();
//        test.task3();
//        test.task4();
        test.task5();
    }

    /**
     * Task:
     * Create a simple record
     * Task: Create Person record with components String name, int age.
     * Implement: Instantiate a few Person objects and print them.
     * Test: Verify toString() output and that accessors are named name() and age().
     * Hint: Records auto-generate constructor, accessors, equals/hashCode, toString.
     * Lesson: Basic syntax and auto-generated members.
     */
    public void task1() {
        Person p = new Person("Ankit", 29);
        Person p2 = new Person("Adwitya", 40);
        System.out.println(p);
        System.out.println(p2);
    }

    /**
     * Task:2
     * Equality and immutability check
     * Task: Create two Person objects with same component values and compare with equals.
     * Implement: Put one Person into a HashSet and check contains() with the other instance.
     * Test: person1.equals(person2) must be true and HashSet behavior verifies hashCode.
     * Lesson: equals/hashCode based on components.
     */
    public void task2() {
        Person p = new Person("Ankit", 29);
        Person p2 = new Person("Ankit", 29);
        //1
        /**
         * the record's implementation checks if two instances have the same data (logical equality).
         */
        System.out.println(p.equals(p2)); //true

        //2
        HashSet<Person> hs = new HashSet<>();
        hs.add(p);
        System.out.println(hs.contains(p2)); //true
        System.out.println("Hash Code of P Object is " + p.hashCode()); //1965774292
        System.out.println("Hash Code of P2 Object is " + p2.hashCode());//1965774292
    }

    /**
     * Canonical constructor (full form)
     * Task: Create Email record with String local, String domain. Provide a canonical constructor that validates domain contains a dot.
     * Implement: Throw IllegalArgumentException if invalid.
     * Test: Attempt to construct invalid email and assert exception thrown.
     * Hint: Canonical constructor signature must match component list: public Email(String local, String domain) { ... }
     * Lesson: Add validation in canonical constructor.
     */

    public void task3() {
        Email e1 = new Email("ankit", "gmail.com");
        System.out.println(e1);
        try {
            Email e2 = new Email("ankit", "gmailcom");
        } catch (Exception ex) {
            System.out.println("Exception caught: " + ex.getMessage());
        }
        /**
         * OUTPUT:
         * Email[local=ankit, domain=gmail.com]
         * Exception caught: Invalid Domain entered
         */

    }

    /**
     * Compact canonical constructor (compact form)
     * Task: Create User record with String username, String passwordHash. Use compact constructor to normalize username to lower-case and trim.
     * Implement: public User { username = username.trim().toLowerCase(); ... }
     * Test: Construct with " Alice " and verify username() is "alice".
     * Lesson: Compact constructor removes parameter declarations for succinct normalization logic.
     */
    public void task4() {
        User u1 = new User(" ANKIT ", "gmail.com");
        System.out.println(u1.username().equals("ankit"));
    }

    public void task5() {
        List<String> mutableList = new ArrayList<>(List.of("Alice", "Bob"));
        Book b1 = new Book("Java Records", mutableList);
        mutableList.add("Charlie");
        System.out.println("Original Mutable list size:"+mutableList.size()); // you can see here the original list got modified and new element got added
        System.out.println("Book record authors list size:" + b1.authors().size()); // but the record's list is unaffected and remains unchanged because of List.copyOf() in the constructor
        System.out.println(b1);
        try {
            b1.authors().add("David"); // this will throw UnsupportedOperationException because the list is unmodifiable
        } catch (UnsupportedOperationException e) {
            System.out.println("Exception caught: " + e.getMessage());
            e.getStackTrace();
        }
    }
}
