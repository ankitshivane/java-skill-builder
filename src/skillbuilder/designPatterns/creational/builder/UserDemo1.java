package skillbuilder.designPatterns.creational.builder;

public class UserDemo1 {
    public static void main(String[] args) {
        User user1 = new User.Builder("ankit", "shivane").build();

        /*
💡 How Does This Work?
🔁 Method Chaining (Fluent API)
Each method like .age(), .job(), .country():
Sets a value.
Returns this, i.e., the Builder object itself.
So you can keep chaining methods.
         */
    }
    /*
Here’s what happens behind the curtain:

new User.Builder("John", "Doe") creates a Builder object, stores the required fields.

.age(30) sets age inside the builder object.

.job("Engineer") sets the job inside the same builder object.

.country("India") sets the country.

.build() finally creates a User object by passing the builder into new User(builder).

So ultimately:
Now User constructor reads all values from the builder and initializes a new User object.
     */
}
