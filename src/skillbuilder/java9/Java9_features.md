# Java 9 Features

**Some of the important java 9 features are;**

1. Java 9 REPL (JShell)
2. Factory Methods for Immutable List, Set, Map and Map.Entry
    * Oracle Corp has introduced some convenient factory methods to create Immutable List, Set, Map and Map.Entry
      objects. These utility methods are used to create empty or non-empty Collection objects.
    * In Java SE 8 and earlier versions, We can use Collections class utility methods like unmodifiableXXX to create
      Immutable Collection objects. For instance, if we want to create an Immutable List, then we can use
      Collections.unmodifiableList methods are a tedious and verbose approach.
    * To overcome those shortcomings, Oracle Corp has added a couple of utility methods to List, Set and Map interfaces.
      List and Set interfaces have “of()” methods to create an empty or no-empty Immutable List or Set.
3. Private methods in Interfaces
    * In Java 9 onwards we can write private methods in interfaces
    * this private can be static or non-static as well
    * As they are private they can be access only inside that particular interface
    * It brings advantages as
        * Reduce code duplication
        * improve code encapsulation by hiding implementation details
        * It helps us to share common between non-abstract methods of interfaces
    * Till JDK 7 we can have only abstract methods inside interfaces
    * In JDK 8 we can have abstract methods, default methods, static methods
    * in JDK 9 we can have private methods along with abstract methods, default methods, static methods
4. Java 9 Module System
5. Process API Improvements
6. Try With Resources Improvement
    * Try with resources closes all the resources (file, database connections, network connections etc.) automatically.
      No need to close them explicitly by writing finally. This helps us from memory leak.
    * In Java 9 allow us to declare the resources outside of the Try with resources block. we no longer need to create
      the local variable to access the resources. Prior to Java 9 we have to declare the auto-closeable resources under
      the Try-with-resources block (that is `()` block), otherwise we will get compile time error.
7. CompletableFuture API Improvements
8. Reactive Streams
9. Diamond Operator for Anonymous Inner Class
10. Optional Class Improvements
11. Stream API Improvements
    * In Java 9 as a part of Stream API, the following new methods introduced:
        * `takeWhile()` -> default method. In the case of takeWhile method there is no guarantee that it will process
          every
          element of the stream as it will take input elements from the source stream as long as the Predicate condition
          is true. If any given point of time while processing it found that the Predicate condition evaluation is false
          at that point onwards remaining elements won't be process; that is rest of the stream is discarded.
        * `dropWhile()` -> default method, it takes a predicate as param and it is opposite of the `takeWhile()` method.
          it
          will process all the elements of streams with the defined predicate condition and drop all elements instead of
          taking them as until the condition result as true. Once the predicate returns false then rest of the stream
          will be returned without checking the predicate condition.
        * `iterate()` -> static method, iterate() is an existing method since JDK 1.8 but In Java 9, To prevent
          infinite loops, in Java 9, another version of iterate() method introduced, which is nothing but 3-arg
          iterator() method Example Syntax: `Stream<T> iterate(T seed, Predicate<? super T> hasNext, UnaryOperator<T> next)`
        * `ofNullable()` -> static method, this is also existing method but in Java 9 there are some improvements
          introduce to avoid NullPointerException. This method returns an empty stream if the stream is null. It can
          also be used on a non-empty stream where it returns a sequential stream of single elements
12. Enhanced @Deprecated annotation
13. HTTP 2 Client
14. Multi-Resolution Image API
15. Miscellaneous Java 9 Features
16. 