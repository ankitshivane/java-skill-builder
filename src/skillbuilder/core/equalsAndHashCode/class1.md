# 🧠 MASTERCLASS: `equals()`, `hashCode()`, and `toString()` in Java

---

## 🧩 1. What are these methods?

These three methods come from the **`java.lang.Object`** class, which is the **root of all classes in Java**.

That means **every class** inherits these methods — even if you don’t define them.

### Their signatures:

```java
public boolean equals(Object obj)

public int hashCode()

public String toString()
```

---

# PART 1️⃣ — `equals(Object obj)`

---

## 🔹 Default behavior

If you don’t override it, `equals()` in `Object` behaves like the `==` operator:

```java
public boolean equals(Object obj) {
    return (this == obj);
}
```

It checks **reference equality** — i.e., whether both references point to the **same object** in memory.

Example:

```java
String s1 = new String("ankit");
String s2 = new String("ankit");

System.out.

println(s1 ==s2);      // false (different objects)
System.out.

println(s1.equals(s2)); // true (String overrides equals())
```

But if it were your own class:

```java
class Student {
    String name;

    Student(String name) {
        this.name = name;
    }
}

Student s1 = new Student("ankit");
Student s2 = new Student("ankit");

System.out.

println(s1.equals(s2)); // false (no override)
```

Because `Student` inherits `equals()` from `Object`, and compares references, not data.

---

## 🔹 When to override `equals()`

You override `equals()` when **two distinct objects should be considered logically equal** if their internal state (
data) is equal.

Example:

```java
class Student {
    String name;
    int id;

    Student(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;                 // 1. Same reference
        if (o == null || getClass() != o.getClass()) return false; // 2. Type check
        Student s = (Student) o;                    // 3. Typecast
        return id == s.id && Objects.equals(name, s.name); // 4. Compare fields
    }
}
```

---

## 🔹 The **Contract** of `equals()` (very important)

Java specifies 5 rules that must **always hold true** for a correctly overridden `equals()`:

| Property        | Description                                                         | Example                          |
|-----------------|---------------------------------------------------------------------|----------------------------------|
| **Reflexive**   | `x.equals(x)` → must be true                                        | A student equals itself          |
| **Symmetric**   | If `x.equals(y)` → then `y.equals(x)` must also be true             | Equality must go both ways       |
| **Transitive**  | If `x.equals(y)` and `y.equals(z)` → then `x.equals(z)`             | Consistent logical equality      |
| **Consistent**  | Multiple invocations must return the same result if nothing changes | No randomness                    |
| **Non-nullity** | `x.equals(null)` must return false                                  | Never throw NullPointerException |

✅ Violating any of these can cause unpredictable behavior in collections like `HashSet`, `HashMap`, etc.

---

## 🔹 `instanceof` vs `getClass()` in equals

You can do type checking in two ways:

```java
if(!(o instanceof Student))return false; // allows subclass comparison
```

or

```java
if(getClass() !=o.

getClass())return false; // strict type match
```

### Difference:

* `instanceof` → allows subclass to be considered equal to parent (looser)
* `getClass()` → requires exact class match (stricter, safer in most cases)

---

## 🔹 Common mistake

Comparing arrays:

```java
int[] a1 = {1, 2, 3};
int[] a2 = {1, 2, 3};
System.out.

println(a1.equals(a2)); // false
```

Because arrays do not override `equals()`.
Use `Arrays.equals(a1, a2)` instead.

---

## 🔹 Recommended implementation pattern (modern Java)

```java

@Override
public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Student s)) return false; // pattern matching (Java 16+)
    return id == s.id && Objects.equals(name, s.name);
}
```

---

# PART 2️⃣ — `hashCode()`

---

## 🔹 What is `hashCode()`?

`hashCode()` returns an `int` used by **hash-based collections** like:

* `HashMap`
* `HashSet`
* `Hashtable`
* `ConcurrentHashMap`

It helps locate an object **quickly** using hashing.

---

## 🔹 Default behavior

If not overridden:

```java
public native int hashCode();
```

Each object’s hash code is typically derived from its **memory address** (JVM dependent).

---

## 🔹 Relationship between `equals()` and `hashCode()`

Java enforces a **critical contract**:

> If two objects are equal according to `equals()`, they **must have the same hash code**.

| Case                       | Requirement                                   |
|----------------------------|-----------------------------------------------|
| `x.equals(y) == true`      | `x.hashCode() == y.hashCode()` ✅ Must be true |
| `x.equals(y) == false`     | `hashCode` *may* be same (hash collision)     |
| If you override `equals()` | You **must also override** `hashCode()`       |

---

## 🔹 Why is it important?

Let’s say you put an object in a `HashSet`:

```java
Set<Student> set = new HashSet<>();
set.

add(new Student("ankit", 1));
        System.out.

println(set.contains(new Student("ankit", 1)));
```

If `hashCode()` is not overridden → `contains()` will return **false**,
because it will look in the wrong hash bucket (different hash code).

---

## 🔹 Correct `hashCode()` Implementation

```java

@Override
public int hashCode() {
    return Objects.hash(id, name);
}
```

### Older manual way:

```java

@Override
public int hashCode() {
    int result = name != null ? name.hashCode() : 0;
    result = 31 * result + id;
    return result;
}
```

👉 `31` is used because it’s prime and helps generate unique hashes efficiently.

---

## 🔹 Best Practice Summary

| Scenario                 | Rule                                                                      |
|--------------------------|---------------------------------------------------------------------------|
| Override `equals()`      | Always override `hashCode()` too                                          |
| Equal objects            | Must have equal hash codes                                                |
| Unequal objects          | Can have same hash codes (but try to avoid)                               |
| `hashCode()` consistency | Must return the same value for the same object while it’s in a collection |

---

# PART 3️⃣ — `toString()`

---

## 🔹 Default behavior

In `Object` class:

```java
public String toString() {
    return getClass().getName() + "@" + Integer.toHexString(hashCode());
}
```

Example:

```java
Student s = new Student("ankit", 1);
System.out.

println(s.toString()); // Student@1a2b3c
```

---

## 🔹 Purpose

* We can use this method to get string representation of an object, Used to provide **human-readable representation** of
  objects.
* Whenever we are try to print any object reference internally toString() method will be executed.
* If our class doesn't contain toString() method then Object class toString()
  method will be executed.
* when we access toString() method internally or externally , first,
  JVM has to execute toString(), to execute toString() method JVM will search for toString()
  method in the respective class whose reference variable we passed as parameter to
  System.out.println(--) method, if the required toString() method is not existed in the
  respective class then JVM will search for toString() method in its super class, here if super
  class is not existed then JVM will search for toString() method in the common and default
  super class Object class.
* In Object class, toString() method was implemented in such a way to return a string contains "Class_Name@ref_Val" .
* **Note:** In Java, some predefined classes like String, StringBuffer, Exception, Thread, all
  wrapper classes, all Collection classes are not depending on Object class toString()
  method, they are having their own toString() method inorder to display their own data
* [For Example](toString/Demo.java)
```java
System.out.println(s); // calls s.toString()
```

---

## 🔹 Overriding example

```java

@Override
public String toString() {
    return "Student{name='" + name + "', id=" + id + "}";
}
```

Now:

```
Student{name='ankit', id=1}
```

---

## 🔹 `toString()` best practices

| Rule                                                       | Explanation                       |
|------------------------------------------------------------|-----------------------------------|
| Always override in domain classes                          | Helps debugging and logging       |
| Include key fields                                         | Don’t dump all data unnecessarily |
| Avoid exposing sensitive info                              | (passwords, tokens, etc.)         |
| Use `String.format()` or `Objects.toString()` for neatness |                                   |

---

# PART 4️⃣ — 💣 Advanced Concepts & Edge Cases

---

## ⚙️ 1. Collections behavior

| Collection  | Uses `equals()`?     | Uses `hashCode()`? |
|-------------|----------------------|--------------------|
| `ArrayList` | ✅ yes                | ❌ no               |
| `HashSet`   | ✅ yes                | ✅ yes              |
| `TreeSet`   | ❌ uses `compareTo()` | ❌                  |
| `HashMap`   | ✅ for key comparison | ✅ for key lookup   |

---

## ⚙️ 2. Immutable classes like `String`

`String` overrides both `equals()` and `hashCode()` so that:

```java
"a".equals(new String("a")) // true
        "a".

hashCode() =="a".

hashCode() // true
```

That’s why `String` works perfectly as a key in HashMaps.

---

## ⚙️ 3. Lombok shortcut

If you use **Lombok**, you can let it generate these:

```java

@EqualsAndHashCode
@ToString
public class Student {
    private String name;
    private int id;
}
```

---

## ⚙️ 4. Java Record classes (since Java 16)

Records automatically generate `equals()`, `hashCode()`, and `toString()`.

```java
public record Student(String name, int id) {
}
```

Automatically behaves as:

```java
s1.equals(s2) // compares field by value
s1.

hashCode() // consistent hash
s1.

toString() // Student[name=ankit, id=1]
```

---

## ⚙️ 5. Arrays and Deep Equality

| Type          | Correct Comparison              |
|---------------|---------------------------------|
| `int[]`       | `Arrays.equals(arr1, arr2)`     |
| `Object[]`    | `Arrays.deepEquals(arr1, arr2)` |
| Nested arrays | `Arrays.deepHashCode()`         |

---

## ⚙️ 6. Null-safe comparisons

Use:

```java
Objects.equals(a, b)    // handles null safely
Objects.

hash(a, b, c)   // handles null safely
```

---

# 🧾 SUMMARY CHEAT SHEET

| Method           | Purpose               | Default Behavior            | Must Override With          |
|------------------|-----------------------|-----------------------------|-----------------------------|
| `equals(Object)` | Logical equality      | Reference equality (`==`)   | Field-based comparison      |
| `hashCode()`     | Hash bucket indexing  | Derived from memory address | Field-based hash generation |
| `toString()`     | String representation | `ClassName@HexHash`         | Human-readable description  |

---

# 🧠 INTERVIEW GOLD POINTS

1. If you override `equals()` but not `hashCode()`, collections like `HashSet` and `HashMap` will **misbehave**.
2. Two unequal objects can have the same hash code (hash collision), but it’s rare and acceptable.
3. Never use mutable fields in `equals()` and `hashCode()` if the object is used in hash-based collections.
4. Always make `equals()` **consistent**, **reflexive**, **symmetric**, **transitive**.
5. `toString()` is automatically called in `System.out.println()` or string concatenation.
6. `Objects.equals()` and `Objects.hash()` introduced in Java 7+ simplify null-safe code.
7. For better maintainability → prefer **records** or **Lombok annotations**.

---

Would you like me to create a **cleanly formatted Markdown notes file (like a PDF or `.md` doc)** you can directly copy
into your personal notes app? It’ll include formatted headings, code blocks, and diagrams showing `equals` and
`hashCode` interaction inside HashMap.
