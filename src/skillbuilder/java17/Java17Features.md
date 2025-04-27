# Java 17 Features

📚 Java 17 Important Features (with Interview-Focused Explanations and Examples)

1. Restore always-strict floating-point semantics
2. enhanced pseudo-random number generators
3. deprecate the Applet API for removal
4. strongly encapsulate JDK Internals
5. [Sealed classes:Click here to learn more about it](../indepth/sealed_classes)
6. Remove RMI activation
7. Pattern Matching for switch (preview)
8. Removed Experimental the AOT and JIT compiler

---

1. Restore always-strict floating-point semantics

* Restore Always-Strict Floating-Point Semantics is a small but important change introduced in Java 17.
* Java initially (in Java 1.2) allowed floating-point calculations (float, double) to sometimes use extra precision (
  like using 80-bit floating points on some hardware like Intel CPUs) for performance reasons.
* This could cause small, unexpected differences in floating-point results across different platforms (Windows, Linux,
  Mac) or even different machines.
* To fix this, Java introduced the strictfp keyword, to force strict IEEE 754 standard behavior — meaning floating-point
  calculations would behave exactly the same everywhere.\

✅ Now, in Java 17:

* Java always follows strict floating-point rules, even without the strictfp keyword.
* So all floating-point calculations (+, -, *, /) are consistent and portable across all platforms and compilers.

✅ In simple words:

* Floating-point math will behave the same everywhere without needing strictfp.

✅ Before Java 17:

* Without strictfp :: Maybe inconsistent results (due to extra precision)
* With strictfp :: Guaranteed consistent results

✅ Since Java 17:

* strictfp is no longer needed for consistency.

✅ Why was this done?

* To make Java simpler.
* To avoid bugs caused by subtle differences in floating-point results.
* To make Java fully consistent with IEEE 754 standards without extra developer effort.

✅ For Example:

```aiignore
double x = 0.1 + 0.2;
System.out.println(x); // Same result everywhere, no surprises.
```

---

2. Pattern Matching for switch (preview)

* Java 17 introduced a new feature called “Pattern Matching for switch Statements” that allows developers to simplify
  the code for switch statements that involve pattern matching. This feature provides a short and more readable syntax
  to handle multiple conditions in switch statements.
* Before the introduction of this feature, switch statements could only compare the value of a single variable against a
  series of constants or expressions. Moreover, the previous version of switch statement was limited to byte, short,
  char, int, Byte, Character, Short, Integer, String, and Enum types.
* The new feature allows developers to use patterns to match against the value of an object of any type.
* For Example

```aiignore
static String format(Object obj) {
        return switch (obj) {
            case Integer i -> "int " + i;
            case String s -> "String " + s;
            default -> "Unknown";
        };
    }
```

➡️ Notice:

* The case Integer i matches if obj is an Integer, and automatically casts it to i.
* Same for String s.
* No need for instanceof checks + casting manually!

➡️ You can now even match null safely inside switch!, Earlier, switch (null) would throw a NullPointerException.

* For Example:

```aiignore
static String handle(Object obj) {
    return switch (obj) {
        case null        -> "Null object"; // you can handle null directly!
        case Integer i   -> "Integer value: " + i;
        case String s    -> "String value: " + s;
        case Double d    -> "Double value: " + d;
        default          -> "Unknown type";
    };
}
```

➡️ Before Java 17:

```aiignore
static String format(Object obj) {
    if (obj instanceof Integer) {
        Integer i = (Integer) obj;
        return "int " + i;
    } else if (obj instanceof String) {
        String s = (String) obj;
        return "String " + s;
    } else {
        return "Unknown";
    }
}
```

➡️ Key Points:

* Works with type patterns inside switch.
* Makes type-check + cast automatic.
* Helps write shorter, cleaner, safer code.
* It was introduced as a preview feature in Java 17, meaning you must enable it with --enable-preview when compiling and
  running.

