# Java 12 Features

🚀 Java 12 Features – Complete Tutorial for Learning & Interview Prep

### Java 12, released in March 2019, brought several new features and improvements. Although it was a non-LTS (Long-Term Support) release, it introduced some handy enhancements.

1) Switch Expressions (Preview feature)
2) File mismatch() Method
3) Compact Number Formatting]
4) Teeing Collectors in Stream API
5) Java Strings New Methods – indent(), transform(), describeConstable(), and
   resolveConstantDesc().
6) JVM Constants API
7) Pattern Matching for instanceof
8) Raw String Literals is Removed From JDK 12.(Preview feature)

---

1) Switch Expression
    * Traditional switch statements were verbose and limited. Java 12 introduced switch as an expression to return a
      value.
    * It is almost all same as switch statement before Java12 version, but, in JAVA12 version, we
      are able to define multi labelled case statements in switch.
    * this helps make switch more compact and reduces boilerplate making it readable.They also remove the need for break
      statements. The code execution will not fall through after the first match.
    * Another notable difference is that we can assign a switch statement directly to the variable. It was not possible
      previously.
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
    * A new teeing collector was introduced in Java 12 as an addition to the Collectors class:
    * Every element is processed by both downstream collectors. Then their results are passed to the merge function and
      transformed into the final result.Combines two collectors and merges their result using a third function.
    * Useful for collecting multiple results from a stream in one pass.
    * its main purpose is to take two straems and performing BIFunction then generating results.
    * ```public static Collector teeing (Collector stream1, Collector stream2, BiFunction merger);```
      Where stream1 and Stream2 are two Streams and merger is able to merge the result of
      both Collectors and generating result
4) String class new methods
    * ```public String indent(int count)```:
        * Main intention of indent() method is to add spaces from a string or remove spaces
          to the string.
        * indent adjusts the indentation of each line based on the integer parameter. If the parameter is greater than
          zero, new spaces will be inserted at the beginning of each line. On the other hand, if the parameter is less
          than zero, it removes spaces from the begging of each line. If a given line does not contain sufficient white
          space, then all leading white space characters are removed.
        * CASES:
            * count < 0 then spaces will be removed at the beginning of each and every line.
            * If count > 0 then spaces will be added at beginning of String.
            * If negative count > the existed spaces then all spaces are removed.
    * ``public R transform(Function f)``:
        * It will take a Function as parameter and it will transform string into some other form and
          return that result.
5) File mismatch() Method
    * Java 12 introduced a new mismatch method in the nio.file.Files utility class:
    * Syntax: ``public static long mismatch(Path path, Path path2) throws IOException``
    * it can be used to check whether two files content is matched or not, if files content is matched then
      mismatch() method will return -1L value , if the files content is mismatched then
      mismatch() method will return the position of the mismatched byte.
6) Raw String Literals is Removed From JDK 12.
    * It is a preview feature, it will not be executed in JAVA12 version.
    * A raw string literal can span multiple lines of source code and does not interpret escape sequences, such as \n,
      or Unicode escapes, of the form \uXXXX.
    * Please note: This was intended to be a preview language feature in JDK 12, but it was withdrawn and did not appear
      in JDK 12.

