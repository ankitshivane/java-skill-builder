# Java 12 Features

🚀 Java 12 Features – Complete Tutorial for Learning & Interview Prep

### Java 12, released in March 2019, brought several new features and improvements. Although it was a non-LTS (Long-Term Support) release, it introduced some handy enhancements.

1) Switch Expressions
2) File mismatch() Method
3) Compact Number Formatting]
4) Teeing Collectors in Stream API
5) Java Strings New Methods – indent(), transform(), describeConstable(), and
   resolveConstantDesc().
6) JVM Constants API
7) Pattern Matching for instanceof
8) Raw String Literals is Removed From JDK 12.

---

1) Switch Expression

    * Traditional switch statements were verbose and limited. Java 12 introduced switch as an expression to return a
      value.
    * It is almost all same as switch statement before Java12 version, but, in JAVA12 version, we
      are able to define multi labelled case statements in switch.
    * this helps make switch more powerful and reduces boilerplate.
2) Compact Number Formatting
    * in java applications, we are able to represent numbers in numeric form, not
      in Short form like 10K, 100K,..... and Long form like 1 Thousand or 100 Thousand, if we
      want to represent numbers in short form and long form like above JAVA12 version has
      provided a predefined class in the form of java.text.CompactNumberFormat.
    * For Example:
   > By Using CompactNumberFormat we are able to perform the following actions.
   Converting Normal Numbers to Short Form and Long Form of Numbers
   100 -------> 100 \
   1000 ------> 1 Thousand or 1 k \
   10000 -----> 10 Thousand or 10 k
    * Helps format numbers in a human-readable way (e.g., 1K, 1M).
    * 🔸 Use Case: Displaying numbers in dashboards or reports.

3) Teardown in Collectors – Collectors.teeing() (JEP 355)
    * Combines two collectors and merges their result using a third function.
    * Useful for collecting multiple results from a stream in one pass.
    * JAVA 12 version has provided Teeing collector in Stream API, its main purpose is to take
      two straems and performing BIFunction then generating results.
    * ```public static Collector teeing (Collector stream1, Collector stream2, BiFunction merger);```
      Where stream1 and Stream2 are two Streams and merger is able to merge the result of
      both Collectors and generating result