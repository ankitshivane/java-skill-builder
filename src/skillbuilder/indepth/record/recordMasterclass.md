# Java `record` Masterclass

---

# 📖 Java `record` Masterclass

---

## 1. What is a `record` in Java?
- A `record` is a **special kind of class** introduced in **Java 14 (preview)** and **finalized in Java 16**.
- It is used to **model immutable data** — like a **data carrier** or **value object**.
- When you define a `record`, Java automatically provides:
    - Private final fields
    - Public constructor
    - Getters (accessor methods)
    - `toString()`
    - `equals()`
    - `hashCode()`
- You don't need to manually write boilerplate code.

---

## 2. Basic Syntax

```java
public record Person(String name, int age) {
}
```

This is **equivalent** to writing:

```java
public final class Person {
    private final String name;
    private final int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String name() {
        return name;
    }

    public int age() {
        return age;
    }

    @Override
    public boolean equals(Object o) { ... }

    @Override
    public int hashCode() { ... }

    @Override
    public String toString() { ... }
}
```

☝ **Notice**: Getters are named after the fields directly: `name()`, `age()` — **no `getName()`**.

---

## 3. Important Rules for `record`

✅ `record` is **implicitly**:
- `final` (cannot be extended)
- `extends java.lang.Record`
- **fields are final** (cannot be reassigned)

✅ **Mandatory:**
- The **record header** must declare all fields.

✅ **No explicit field declarations** — you **cannot declare fields manually** outside the header (unless they are `static`).

✅ **Can define additional methods** (non-static or static).

✅ **Can define static fields**, but **cannot define non-static mutable fields**.

✅ **Can override** `toString()`, `equals()`, `hashCode()` if you need custom logic.

✅ **Canonical constructor** can be customized (but must initialize all fields).

✅ **Compact constructor** can be used for validation.

✅ **Cannot extend any class** (except `java.lang.Record` implicitly).

✅ **Can implement interfaces**.

---

## 4. Examples and Variants

---

### 4.1 Default behavior

```java
public record Employee(String id, String name) {
}
```

Usage:

```java
Employee emp = new Employee("101", "Alice");
System.out.println(emp.name());    // Alice
System.out.println(emp);           // Employee[id=101, name=Alice]
```

---

### 4.2 Custom Method inside a record

```java
public record Point(int x, int y) {
    public double distanceFromOrigin() {
        return Math.sqrt(x * x + y * y);
    }
}
```

---

### 4.3 Custom Constructor (Canonical Constructor)

You can customize how fields are initialized:

```java
public record Student(String name, int marks) {
    public Student {
        if (marks < 0 || marks > 100) {
            throw new IllegalArgumentException("Marks must be between 0 and 100");
        }
        // No need to assign: compiler assigns automatically
    }
}
```

---

### 4.4 Custom toString(), equals(), hashCode()

```java
public record Product(String id, String name) {
    @Override
    public String toString() {
        return "Product: " + id + ", " + name;
    }
}
```

---

### 4.5 Static Fields and Methods in record

```java
public record Circle(double radius) {
    public static final double PI = 3.1415;

    public static Circle unitCircle() {
        return new Circle(1.0);
    }

    public double area() {
        return PI * radius * radius;
    }
}
```

---

## 5. Use Cases — When Should You Use `record`?

- ✅ DTOs (Data Transfer Objects)
- ✅ API Request/Response payloads
- ✅ Immutable Data Holders
- ✅ Configuration objects
- ✅ Value Objects (especially in DDD — Domain-Driven Design)
- ✅ Event objects in Event-Driven Architecture
- ✅ Keys in HashMaps or Sets (records auto-generate correct `equals` and `hashCode`)

---

## 6. Restrictions on `record`

❌ Cannot extend another class  
❌ Cannot have mutable instance fields  
❌ Cannot explicitly define instance fields (only via the header)  
❌ Cannot call `super()` because it automatically extends `java.lang.Record`  
❌ All instance fields are **final**, meaning **no setters allowed**

---

## 7. Common Interview Questions and Short Answers

| ❓ | 🧠 Answer |
|:---|:---|
| **Can a record be abstract?** | No, a record is always implicitly `final`. |
| **Can a record extend a class?** | No, only implements interfaces. |
| **Can you override equals/hashCode?** | Yes, but by default Java generates them properly based on all fields. |
| **Can a record have a mutable field?** | No, fields are implicitly `final`. |
| **Can a record have methods?** | Yes, both instance and static methods. |
| **Can a record have static fields?** | Yes. |
| **Can you add validation logic to a record?** | Yes, inside a **compact constructor**. |
| **Which class does every record implicitly extend?** | `java.lang.Record`. |
| **In which version were records fully introduced?** | Java 16. |
| **How is a record different from a Lombok @Data class?** | Record is built into Java and ensures true immutability; no external dependency. |

---

## 8. Advanced Topics

---

### 8.1 Nested Records

```java
public record Order(int orderId, Product product) {
    public record Product(String name, double price) {}
}
```

---

### 8.2 Serialization

```java
import java.io.Serializable;

public record Customer(String id, String name) implements Serializable {
}
```

---

### 8.3 Records with Generics

```java
public record Wrapper<T>(T value) {
}
```

---

### 8.4 Record and Reflection

```java
for (var component : Customer.class.getRecordComponents()) {
    System.out.println(component.getName() + " : " + component.getType());
}
```

---

### 8.5 Copying a record (new object)

```java
Person p1 = new Person("Alice", 30);
Person p2 = new Person(p1.name(), p1.age());
```

From Java 21 onward, **record patterns** and **record deconstruction** help even more.

---

# 🎯 Quick Summary

| Concept | Key Points |
|:--------|:-----------|
| Definition | Immutable, lightweight data carrier |
| Constructor | Can customize validation using compact constructor |
| Methods | Can add custom methods |
| Fields | All final, no manual field declaration |
| Static Members | Allowed |
| Interfaces | Can implement |
| Extending Class | Not allowed |
| Boilerplate | Auto-generated constructor, accessors, equals, hashCode, toString |
| Java Version | Java 16 (final) |

---

# ⚡ **Practice Mini Project Idea**
- Create a `record` for `Book` (title, author, price)
- Create a `record` for `Library` (list of books)
- Add methods to calculate total price of all books.

---

**Would you like a runnable project template with JUnit tests too? ✨**

(Ask anytime!)

