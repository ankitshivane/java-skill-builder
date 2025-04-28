package skillbuilder.java11.programs.OptionalIsEmpty;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * A complete practice class demonstrating different use cases
 * of Optional.ofNullable() up to Java 17.
 */
public class OptionalOfNullablePractice {

    /**
     * Example 1: Safe Wrapping of Potentially Null Values
     */
    public static void safeWrapping() {
        String name = getNameNullable();
        Optional<String> optionalName = Optional.ofNullable(name);
        System.out.println("Optional value: " + optionalName);
    }

    /**
     * Example 2: Avoid Manual Null Checks using ifPresent
     */
    public static void avoidNullChecks() {
        Optional.ofNullable(getNameNullable())
                .ifPresent(name -> System.out.println("Name is: " + name));
    }

    /**
     * Example 3: Provide Default Value using orElse
     */
    public static void provideDefaultValue() {
        String name = Optional.ofNullable(getNameNullable())
                .orElse("Default Name");
        System.out.println("Resolved Name: " + name);
    }

    /**
     * Example 4: Lazy Default Value using orElseGet
     */
    public static void lazyDefaultValue() {
        String name = Optional.ofNullable(getNameNullable())
                .orElseGet(() -> computeDefaultName());
        System.out.println("Resolved Name (lazy): " + name);
    }

    /**
     * Example 5: Throw Exception if Value is Null
     */
    public static void throwIfNull() {
        String name = Optional.ofNullable(getNameNullable())
                .orElseThrow(() -> new IllegalArgumentException("Name is missing"));
        System.out.println("Name is: " + name);
    }

    /**
     * Example 6: Chain Transformations using map()
     */
    public static void chainTransformations() {
        Integer nameLength = Optional.ofNullable(getNameNullable())
                .map(String::length)
                .orElse(0);
        System.out.println("Name Length: " + nameLength);
    }

    /**
     * Example 7: Flatten Nested Optionals using flatMap()
     */
    public static void flattenOptionals() {
        Optional<User> optionalUser = Optional.ofNullable(getUserNullable());
        Optional<Address> address = optionalUser.flatMap(User::getAddress);
        System.out.println("Address Present: " + address.isPresent());
    }

    /**
     * Example 8: Filter Values inside Optional
     */
    public static void filterValues() {
        Optional<String> filteredName = Optional.ofNullable(getNameNullable())
                .filter(name -> name.startsWith("A"));
        System.out.println("Filtered Name: " + filteredName);
    }

    /**
     * Example 9: Integrate Optional with Stream API (Java 9+)
     */
    public static void optionalToStream() {
        Stream<String> stream = Optional.ofNullable(getNameNullable()).stream();
        stream.forEach(name -> System.out.println("Name from stream: " + name));
    }

    /**
     * Example 10: Method Parameter Handling with Optional
     */
    public static void methodParameterHandling() {
        processName(Optional.ofNullable(getNameNullable()));
    }

    private static void processName(Optional<String> optionalName) {
        optionalName.ifPresent(name -> System.out.println("Processed Name: " + name));
    }

    /**
     * Helper method: Simulate a nullable name provider
     */
    private static String getNameNullable() {
        // Simulating a nullable value (could be null in real cases)
        return Math.random() > 0.5 ? "Alice" : null;
    }

    /**
     * Helper method: Compute default name
     */
    private static String computeDefaultName() {
        System.out.println("Computing default name...");
        return "Default-Computed-Name";
    }

    /**
     * Helper method: Simulate a nullable user provider
     */
    private static User getUserNullable() {
        // Simulating a nullable User
        return Math.random() > 0.5 ? new User(new Address("New York")) : null;
    }

    /**
     * Sample User class for flatMap example
     */
    static class User {
        private final Address address;

        public User(Address address) {
            this.address = address;
        }

        public Optional<Address> getAddress() {
            return Optional.ofNullable(address);
        }
    }

    /**
     * Sample Address class for User
     */
    static class Address {
        private final String city;

        public Address(String city) {
            this.city = city;
        }

        public String getCity() {
            return city;
        }
    }

    /**
     * Main method to run all practice examples
     */
    public static void main(String[] args) {
        System.out.println("\n1. Safe Wrapping Example:");
        safeWrapping();

        System.out.println("\n2. Avoid Manual Null Checks Example:");
        avoidNullChecks();

        System.out.println("\n3. Provide Default Value Example:");
        provideDefaultValue();

        System.out.println("\n4. Lazy Default Value Example:");
        lazyDefaultValue();

        System.out.println("\n5. Throw If Null Example:");
        try {
            throwIfNull();
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }

        System.out.println("\n6. Chain Transformations Example:");
        chainTransformations();

        System.out.println("\n7. Flatten Nested Optionals Example:");
        flattenOptionals();

        System.out.println("\n8. Filter Values Example:");
        filterValues();

        System.out.println("\n9. Optional to Stream Example:");
        optionalToStream();

        System.out.println("\n10. Method Parameter Handling Example:");
        methodParameterHandling();
    }

    /*
OUTPUT:

1. Safe Wrapping Example:
Optional value: Optional[Alice]

2. Avoid Manual Null Checks Example:
Name is: Alice

3. Provide Default Value Example:
Resolved Name: Default Name

4. Lazy Default Value Example:
Resolved Name (lazy): Alice

5. Throw If Null Example:
Exception: Name is missing

6. Chain Transformations Example:
Name Length: 5

7. Flatten Nested Optionals Example:
Address Present: false

8. Filter Values Example:
Filtered Name: Optional.empty

9. Optional to Stream Example:

10. Method Parameter Handling Example:
     */
}
