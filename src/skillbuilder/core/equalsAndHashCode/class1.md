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

* We can use this method to check equivalence of two objects.
* If our class doesn't contain .equals() method then object class .equals() method will be executed which is always
  meant for reference comparison[address
  comparison]. i.e., if two references pointing to the same object then only .equals() method returns true . If you
  don’t override it, `equals()` in `Object` behaves like the `==` operator:

```java
public boolean equals(Object obj) {
    return (this == obj);
}
```

* [For Example](equals/Student.java)
* In the above program Object class .equals() method got executed which is always
  meant for reference comparison that is if two references pointing to the same
  object then only .equals(() method returns true.
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

* When ever we are overriding .equals() method we have to consider the following
  things :
    * Meaning of content comparison i.e., whether we have to check the names
      are equal (or) roll numbers (or) both are equal.
    * If we are passing different type of objects (heterogeneous object) our
      .equals() method should return false but not ClassCastException i.e., we
      have to handle ClassCastException to return false.
    * If we are passing null argument our .equals() method should return false
      but not NullPointerException i.e., we have to handle
      NullPointerException to return false.
    * The following is the proper way of overriding .equals() method for
      content comparison in Student class.

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

* In String class , Wrapper classes and all collection classes .equals( ) method is
  overriden for content comparision

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

### Relationship between .equals() method and ==(double equal operator) :

1. If r1==r2 is true then r1.equals(r2) is always true i.e., if two objects are equal by
   == operator then these objects are always equal by .equals( ) method also.
2. If r1==r2 is false then we can't conclude anything about r1.equals(r2) it may
   return true (or) false.
3. If r1.equals(r2) is true then we can't conclude anything about r1==r2 it may
   returns true (or) false.
4. If r1.equals(r2) is false then r1==r2 is always false.

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

1. For every object jvm will generate a unique number which is nothing but
   hashCode.
2. Jvm will using hashCode while saving objects into hashing related data
   structures like HashSet, HashMap, and Hashtable etc.
3. If the objects are stored according to hashCode searching will become very
   efficient (The most powerful search algorithm is hashing which will work based
   on hashCode).
4. If we didn't override hashCode() method then Object class hashCode() method
   will be executed which generates hashCode based on address of the object but it
   doesn't mean hashCode represents address of the object.
5. Based on our programming requirement we can override hashCode() method to
   generate our own hashcode.
6. Overriding hashCode() method is said to be proper if and only if for every object
   we have to generate a unique number as hashcode for every object.

### toString() method vs hashCode() method:

* CASE 1:

```java
class Test {
    int i;

    Test(int i) {
        this.i = i;
    }

    public static void main(String[]
                                    args) {
        Test t1 = new Test(10);
        Test t2 = new Test(100);
        System.out.println(t1);
        System.out.println(t2);
    }
}
//Object==>toString() called. 
//Object==>hashCode() called.
```

* In this case Object class toString( ) method
  got executed which is internally calls Object
  class hashCode( ) method.

* CASE 2:

```java
class Test {
    int i;

    Test(int i) {
        this.i = i;
    }

    public int hashCode() {
        return i;
    }

    public static void main(String[]
                                    args) {
        Test t1 = new Test(10);
        Test t2 = new Test(100);
        System.out.println(t1);
        System.out.println(t2);
    }
}
//Object==>toString() called. 
//Test==>hashCode() called. 
```

* In this case Object class toString( ) method
  got executed which is internally calls Test
  class hashCode( ) method.

* CASE 3:

```java

class Test {
    int i;

    Test(int i) {
        this.i = i;
    }

    public String toString() {
        return i + "";
    }

    public static void main(String[]
                                    args) {
        Test t1 = new Test(10);
        Test t2 = new Test(100);
        System.out.println(t1); // 10
        System.out.println(t2); // 100
    }
}
```

* here in this program we are trying to print the t1 and t2 objects so internally JVM will invoke toString() method as
  we have already overridden toString() in our class it won't execute Object class toString method.

---

## 🔹 Relationship between `equals()` and `hashCode()`

Java enforces a **critical contract**:

> If two objects are equal according to `equals()`, they **must have the same hash code**.

| Case                                    | Requirement                                   |
|-----------------------------------------|-----------------------------------------------|
| `x.equals(y) == true`                   | `x.hashCode() == y.hashCode()` ✅ Must be true |
| `x.equals(y) == false`                  | `hashCode` *may* be same (hash collision)     |
| If `x.hashCode() == y.hashCode()` false | `x.equals(y)` is always false                 |
| If you override `equals()`              | You **must also override** `hashCode()`       |

* To maintain the above contract between .equals() and hashCode() methods whenever
  we are overriding .equals() method compulsory we should override hashCode() method.
  Violation leads to no compile time error and runtime error but it is not good
  programming practice.

---

## 🔹 Why is it important?

* Let’s say you put an object in a `HashSet`:[refer](hashCode/Student.java)
* If `hashCode()` is not overridden → `contains()` will return **false**, then Object class hashCode() method will be
  invoke for calculating hash which is based on memory ref because it will look in the
  wrong hash bucket (different hash code).
* CASE 2: here in the [Person class example](hashCode/Person.java) here I have overridden both equals and hashCode and
  explain the output in the example.

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

* If hashCode of two objects are not equal then .equals() method always return false. [Prof](hashCode/Test1.java)
* . If 2 objects are equal by == operator then their hash codes must be same.(valid). [Proof](hashCode/Test2.java)
* . If == operator returns false then their hash codes(may be same (or) may be
  different) [proof](hashCode/Test3.java)

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
