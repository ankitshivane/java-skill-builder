# Java 10 Features

Below are the list of java 10 features:

1) Local-Variable Type Inference
    * Java10 version has given an option to declare variables with out specifying its type  and
      calculating variable type on the basis of its value , this feature is called as "Type
      Inference".
        ` Syntax: 
        var varName = Value; `
    * We can use Type Inference to the variables inside the loops also
    * If we want to declare arrays with Type Inference then we must use the following syntax.
      `var varName = new DataTpe[]{values};`
    * We can use Type Inference for Collection variables declarations.
      * Note: In Collection variables declaration we can use diamond operator along with Type
        Inference, in this context, Compiler will assign Object type to the respective variable , we
        can add any type of element to the respective Collection.
      * In Java 10 version, we can use 'var' as variable name, method name (can be static and non-static), package name, static and instance block, Resource variables of the try-with-resources statement , it will not give any error
      * No runtime overhead. As compiler infers the type based on value provided, there is no performance loss. 
      * No dynamic type change. Once type of local variable is inferred it cannot be changed. 
      * Complex boilerplate code can be reduced using local variable type inference.
      ## ***Limitations of Type Inference:***
   * Type Inference is applicable for only local variables only, not applicable for class level
     variables.
   * Type Inference is not possible for Parameters in methods, constructors....
   *  Type inference is not possible for variables declaration with out initialization and with
      null value initialization.
   * Type inference is not possible for Lambda Expression variable declaration, but, we can
     apply Type Inference for variables inside Lambda expressions
   * we can not use var as a method return type
2) Consolidate the JDK Forest into a Single Repository
3) Garbage-Collector Interface
4) Parallel Full GC for G1
5) Application Class-Data Sharing 
6) Thread-Local Handshakes 
7) Remove the Native-Header Generation Tool (javah) 
8) Additional Unicode Language-Tag Extensions 
9) Heap Allocation on Alternative Memory Devices 
10) Experimental Java-Based JIT Compiler 
11) Root Certificates 
12) Time-Based Release Versioning  
13) Immutable collections/Unmodifiable Collections:
    * In Java 10 version, `copyOf()` function is added in List, Set and Map inorder to get
      Unmodifiable List, Set and Map.
    * if we try to modify the collections return by `copyOf()` method then it will throw and RuntimeException `java.lang.UnsupportedOperationException`
    * It is a static method present inside the respective interface of List, Set,Map
14) API Changes in Collectors Class in Streem API:
    * Upto JAVA9 version, Collectors class has toList(), toSet(), toMap() methods to get list or
      set or Map of elements from Streams. 
    * JAVA10 has provided the following methods to Collectors class to provide Unmodifiable or immutable List, Set and Map.
      * `public static List unmodifiableList()`
      * `public static Set unmodifiableSet()` 
      * `public static Map unmodifiableMap()`