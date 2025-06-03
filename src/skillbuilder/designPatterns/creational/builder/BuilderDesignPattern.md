# Builder Design Pattern – Masterclass (Java)

## Definition (Theory)

The Builder Design Pattern is a creational pattern used to construct complex objects step-by-step. It separates the
construction of an object from its representation, allowing the same construction process to create different
representations.

## In Simple Words:

It’s used when we need to build an object with many optional parameters or a lot of internal configuration logic.

2. Problem It Solves
    1. Traditional object creation:

```aiignore
new User("John", "Doe", 25, "Engineer", "USA", "1234567890");
```

- Not readable.
- Difficult to maintain.
- What if I want to make age and job optional?

    2. With Setters (JavaBean approach):

```aiignore
User user = new User();
user.setFirstName("John");
user.setLastName("Doe");
...
```

- Allows mutable objects.
- Not thread-safe.
- Object can be in inconsistent state.

    3. With Builder Pattern:

```aiignore
User user = new User.Builder("John", "Doe")
                    .age(25)
                    .job("Engineer")
                    .country("USA")
                    .build();
```

- Much cleaner, readable, and safe.
- Immutable final object.
- Good for objects with many parameters.

3. When to Use the Builder Pattern

* When an object has many optional parameters.
* When object construction is complex and involves multiple steps.
* When you want to create immutable objects.
* When constructors with many arguments become confusing or error-prone.

4. Key Benefits

| Advantage                   | Description                        |
|-----------------------------|------------------------------------|
| Readable                    | Easy-to-read object construction   |
| Immutable Objects           | Prevents accidental mutation       |
| No Telescoping Constructors | Avoid constructor overloading hell |
| Flexible Construction       | Only set what’s needed             |

5. Real-World Examples

* StringBuilder / StringBuffer in Java.
* Lombok’s @Builder annotation.
* Spring Security and Spring WebClient builders.
* Building complex HTTP Requests, Query DSL, Hibernate CriteriaBuilder, etc.

Q3. Is Builder Pattern thread-safe?
A: The pattern itself is not thread-safe by default. But since the final object is immutable, you can make the builder
thread-safe using synchronization if needed.

6. Edge Cases & Tips

* Always validate fields in the build() method if needed.
* Use @Builder from Lombok for faster development (but avoid it in interviews unless asked).
* If the class has 10+ fields, Builder is preferred.
* Immutable objects + Builder = Best Practice in modern Java.

🧊 Why Is This Final User Object Immutable?
Because:

* All fields in User are private final.
* You didn’t expose setters.
* You control all values via Builder.
* Builder is mutable → you can set fields.
* User is immutable → no setters, only getters, final fields.

⚠️ Important Note

* A Builder Pattern does not force you to make the object immutable.
* You can make the built object mutable (with setters), but that defeats the benefit of immutability.

---

📘 3. Real-World Use Case of Lombok Builder (Interview-Ready)
✅ Use Case: Building DTOs for Microservice Communication

* We use Lombok's @Builder pattern for constructing DTOs sent over Kafka/RabbitMQ between microservices. It helps in
  maintaining immutability, readability, and makes testing easier without requiring long constructors or boilerplate.
* Use @Builder to reduce boilerplate; great for DTOs and test data.
* When it fails	--> Inheritance, missing constructor, JPA constraints, final fields, no validation.