package skillbuilder.designPatterns.creational.builder;

public class User {
    private final String firstName; // required
    private final String lastName;  // required
    private final int age;          // optional
    private final String job;       // optional
    private final String country;   // optional

    //We don’t expose a public constructor to avoid misuse. Instead, we build User objects only through the builder.
    private User(Builder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.age = builder.age;
        this.job = builder.job;
        this.country = builder.country;
    }

    public static class Builder {
        private final String firstName;
        private final String lastName;
        private int age;
        private String job;
        private String country;

        public Builder(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder job(String job) {
            this.job = job;
            return this;
        }

        public Builder country(String country) {
            this.country = country;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
