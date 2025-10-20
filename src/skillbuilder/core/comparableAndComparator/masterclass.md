
# 📘 Java Comparable and Comparator — Complete Notes

---

## 🧩 1. Comparable Interface

### 🔹 Definition

`Comparable` is an interface used to define the **natural (default) ordering** of objects of a class.
It allows an object to compare itself with another object of the same type.

```java
public interface Comparable<T> {
    int compareTo(T other);
}
```

---

### 🔹 Purpose

To provide a **single, default sorting logic** inside a class, so that objects of that class can be sorted automatically (e.g., using `Collections.sort()` or `Arrays.sort()`).

---

### 🔹 When to Use

Use `Comparable` when:

* You want to define one **natural/default order** for your class (e.g., by ID, Name, Date).
* You often sort objects of that class the same way.

---

### 🔹 How It Works Internally

1. When you call:

   ```java
   Collections.sort(list);
   ```

    * Java checks whether the class implements `Comparable`.
    * If yes → it calls `compareTo()` repeatedly between pairs of elements.
    * Internally, sorting algorithm (**TimSort**) decides swaps based on:

        * **Negative** → current < next (keep order)
        * **Zero** → current == next (keep order)
        * **Positive** → current > next (swap)

2. The **actual sorting** happens using TimSort (hybrid of merge + insertion sort).

3. The sorting algorithm never looks at fields directly —
   it relies entirely on the **sign** returned by `compareTo()`.

---

### 🔹 Syntax Example

```java
class Employee implements Comparable<Employee> {
    int id;
    String name;
    double salary;

    Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public int compareTo(Employee other) {
        // Natural ordering by ID (ascending)
        return this.id - other.id;
    }

    @Override
    public String toString() {
        return id + " - " + name;
    }
}
```

Usage:

```java
List<Employee> list = new ArrayList<>();
list.add(new Employee(3, "Ankit", 50000));
list.add(new Employee(1, "John", 60000));
list.add(new Employee(2, "Zara", 55000));

Collections.sort(list); // Uses compareTo()
System.out.println(list);
```

---

### 🔹 Return Value Interpretation

| Return Value | Meaning         | Sorting Action      |
| ------------ | --------------- | ------------------- |
| `< 0`        | `this < other`  | Keep order          |
| `0`          | `this == other` | Keep order (stable) |
| `> 0`        | `this > other`  | Swap                |

The **sign** matters, not the magnitude of the number.

---

### 🔹 “Natural Order” Meaning

* **Natural order** = default logical order that “makes sense” for the class.

    * Numbers → ascending
    * Strings → alphabetically
    * Dates → chronological
* You can still **reverse** or **customize** natural order:

  ```java
  @Override
  public int compareTo(Employee other) {
      return Double.compare(other.salary, this.salary); // descending
  }
  ```
* You can also reverse it externally:

  ```java
  Collections.sort(list, Comparator.reverseOrder());
  ```

---

### 🔹 Consistency with equals()

Good practice (not enforced by Java):

* If `a.compareTo(b) == 0` → `a.equals(b)` should be true.
* Prevents inconsistent behavior in sorted collections like `TreeSet` or `TreeMap`.

---

### 🔹 Key Points

| Aspect         | Details                                                        |
| -------------- | -------------------------------------------------------------- |
| Package        | `java.lang`                                                    |
| Method         | `compareTo(T other)`                                           |
| Type           | Generic                                                        |
| Used by        | `Collections.sort(list)` / `Arrays.sort(array)`                |
| Algorithm      | TimSort                                                        |
| Order type     | Natural (default)                                              |
| Changes class? | Yes — logic is inside class                                    |
| Example        | `String`, `Integer`, `Date`, etc. already implement Comparable |

---

### 🔹 Real-world Use Cases

* Sorting `Employee` by ID (natural)
* Sorting `Book` by publication date
* Sorting `Transaction` by timestamp
* `TreeSet` and `TreeMap` rely on `compareTo()` when no Comparator is provided.

---

### 🔹 Limitations

1. Only **one** sorting logic per class (cannot change dynamically).
2. You must **modify the class** to define sorting.
3. If class is from an external library (e.g., cannot edit it), you **cannot** use Comparable.

---

### ✅ Summary of Comparable

| Property           | Description                                           |
| ------------------ | ----------------------------------------------------- |
| Purpose            | Defines natural/default sorting logic                 |
| Method             | `compareTo(T other)`                                  |
| Defined in         | Inside the class                                      |
| Comparator needed? | No                                                    |
| Example            | `Collections.sort(list)`                              |
| Flexibility        | One sorting logic only                                |
| Use Case           | When the class has one obvious way to compare objects |

---

---

# 📗 2. Comparator Interface

---

### 🔹 Definition

`Comparator` is a **functional interface** used to define **custom or multiple sorting logics** externally, without modifying the class.

```java
public interface Comparator<T> {
    int compare(T o1, T o2);
}
```

---

### 🔹 Purpose

To allow **flexible, external, and multiple** comparison strategies for the same class.

---

### 🔹 When to Use

Use `Comparator` when:

* You want to define **different sorting orders** dynamically.
* You **cannot or do not want** to modify the class.
* You need **multi-level sorting** (by multiple fields).

---

### 🔹 How It Works Internally

When you call:

```java
Collections.sort(list, comparator);
```

1. Java checks that `comparator` is not null.
2. Internally uses **TimSort**, but instead of calling `compareTo()`, it calls:

   ```java
   comparator.compare(element1, element2);
   ```
3. The sorting logic (−, 0, +) works exactly the same as `Comparable`.

So the algorithm is identical — only the **comparison source** changes.

---

### 🔹 Syntax Example

#### (a) Using Lambda:

```java
Comparator<Employee> bySalary = (e1, e2) -> Double.compare(e1.salary, e2.salary);
Collections.sort(list, bySalary);
```

#### (b) Using Class:

```java
class SortByName implements Comparator<Employee> {
    public int compare(Employee e1, Employee e2) {
        return e1.name.compareTo(e2.name);
    }
}
Collections.sort(list, new SortByName());
```

---

### 🔹 Return Value Interpretation

Same as Comparable:

| Return Value | Meaning  | Sorting Action |
| ------------ | -------- | -------------- |
| `< 0`        | o1 < o2  | Keep order     |
| `0`          | o1 == o2 | Keep order     |
| `> 0`        | o1 > o2  | Swap           |

---

### 🔹 Comparator Chaining (Java 8+)

Modern Java provides convenient chaining:

```java
Comparator<Employee> byNameThenSalary =
    Comparator.comparing(Employee::getName)
              .thenComparing(Employee::getSalary);
```

or reverse:

```java
Comparator<Employee> byNameDesc =
    Comparator.comparing(Employee::getName).reversed();
```

Null-safe comparison:

```java
Comparator<Employee> byNameSafe =
    Comparator.comparing(Employee::getName, Comparator.nullsLast(String::compareTo));
```

---

### 🔹 Comparator Methods (Java 8+)

| Method                                  | Description                     |
| --------------------------------------- | ------------------------------- |
| `comparing(Function<T,U> keyExtractor)` | Creates comparator using a key  |
| `thenComparing(Comparator)`             | Chains comparators              |
| `reversed()`                            | Reverse order                   |
| `nullsFirst()` / `nullsLast()`          | Handle null values safely       |
| `naturalOrder()`                        | Uses natural order (Comparable) |
| `reverseOrder()`                        | Reversed natural order          |

---

### 🔹 Use Cases

* Sorting Employees by salary, then name.
* Sorting Students by marks descending.
* Sorting external API response objects (cannot modify class).
* Creating TreeSet / TreeMap with custom ordering.

Example:

```java
TreeSet<Employee> set = new TreeSet<>(Comparator.comparing(Employee::getSalary));
```

---

### 🔹 Advantages

✅ Multiple sorting logics possible
✅ No modification to class required
✅ Reusable and clean (using lambdas or method references)
✅ Can chain comparisons

---

### 🔹 Key Points

| Aspect          | Details                                |
| --------------- | -------------------------------------- |
| Package         | `java.util`                            |
| Method          | `compare(T o1, T o2)`                  |
| Type            | Functional Interface (can use lambdas) |
| Used by         | `Collections.sort(list, comparator)`   |
| Algorithm       | TimSort                                |
| Order type      | Custom (external)                      |
| Changes class?  | No                                     |
| Multiple logics | Yes                                    |

---

### 🔹 Real-world Use Cases

| Example                   | Comparator Logic                                                             |
| ------------------------- | ---------------------------------------------------------------------------- |
| Sort by Salary            | `(e1, e2) -> Double.compare(e1.salary, e2.salary)`                           |
| Sort by Name then Salary  | `Comparator.comparing(Employee::getName).thenComparing(Employee::getSalary)` |
| Sort by Date descending   | `(a, b) -> b.getDate().compareTo(a.getDate())`                               |
| TreeSet with Custom Order | `new TreeSet<>(Comparator.comparing(Employee::getId))`                       |

---

### 🔹 Limitations

* Slightly more verbose in pre-Java 8 versions.
* Must provide Comparator explicitly wherever needed.

---

### ✅ Summary of Comparator

| Property           | Description                                       |
| ------------------ | ------------------------------------------------- |
| Purpose            | Defines custom/external sorting logic             |
| Method             | `compare(T o1, T o2)`                             |
| Defined in         | External class or lambda                          |
| Comparator needed? | Yes                                               |
| Example            | `Collections.sort(list, comparator)`              |
| Flexibility        | Many logics for same class                        |
| Use Case           | When you need multiple or runtime sorting options |

---

# 🧠 3. Comparable vs Comparator — Quick Comparison Table

| Feature                  | Comparable                  | Comparator                           |
| ------------------------ | --------------------------- | ------------------------------------ |
| Package                  | `java.lang`                 | `java.util`                          |
| Method                   | `compareTo(T o)`            | `compare(T o1, T o2)`                |
| Defined in               | Inside the class            | Outside the class                    |
| Type                     | Natural / Default order     | Custom / External order              |
| Usage                    | `Collections.sort(list)`    | `Collections.sort(list, comparator)` |
| Modifies class           | Yes                         | No                                   |
| Multiple orders possible | No                          | Yes                                  |
| Can use Lambda           | No                          | Yes (Java 8+)                        |
| Default examples         | `String`, `Integer`, `Date` | `Comparator.comparing(...)`          |
| Typical use              | One fixed logical order     | Many flexible sorting options        |
| TreeSet / TreeMap use    | Uses `compareTo()`          | Uses provided Comparator             |

---

# 🧾 4. Internal Algorithm (Same for Both)

Both interfaces work under **TimSort**, which:

* Is a hybrid of merge sort and insertion sort.
* Uses `compareTo()` or `compare()` for comparisons.
* Stable (preserves order of equal elements).
* Time Complexity: **O(n log n)**
* Space Complexity: **O(n)**

During sorting:

```java
if (compare(a, b) > 0)  // positive
    swap(a, b);
```

That’s the entire internal logic — the algorithm only cares about sign.

---

# ✅ 5. Key Takeaways

* `Comparable` → Natural, single order, inside class.
* `Comparator` → Custom, multiple orders, outside class.
* Sorting is based purely on the **sign of comparison result**.
* `Collections.sort()` and `Arrays.sort()` both rely on **TimSort**.
* `TreeSet` / `TreeMap` use `Comparable` or supplied `Comparator` for ordering.
* Always ensure consistency between `compareTo()` and `equals()` to avoid logical issues.

---