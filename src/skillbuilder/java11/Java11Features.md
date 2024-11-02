# Java 11 Features

Below are the list of java 11 features:

1) Running Java File with single command
    * Upto Java 10 version, if we want to run Java file, first we have to compile Java file with
      "javac" command then we have to execute Java application by using "java" command.
    * Java11 version has provided an environment to execute Java file with out compiling
      java file explicitly, when we execute Java file internally Java file will be compiled , it
      will
    * If we provide more than one class with main() method in single java file and if we execute
      that Java file then JVM will search for the main() method class in the order in which we
      have provided from starting point of the file to ending point, in which class JVM identifies
      main() method first time then JVM will treat that class as the actual main class and JVM
      will execute that main class.
    * Note: Java11 Version is providing backward Compatibility, that is, in Java11 version, we
      can follow the old convention like compilation of Java file with javac and execution of the
      Java program with java command.
2) New utility methods in String class
    * In Java11 version, String class has provided the following new methods.

    1) public String repeat(int count)
        * It will repeat the String object content up to the given no of times.
        * If we provide -ve value then repeat() method will raise an Exception like              
          "java.lang.IllegalArgumentException".
        * If the count value is 0 then it will return an empty string.
    2) public boolean isBlank()
        * It will check whether the String is Blank[Or White Spaces] or not, if the String is blank  
          then it will return true value otherwise false value.
        * For any null input this isBlank() method will throw NPE
    3) public String strip()
        * It is same as trim() method, it will remove all leading spaces and trailing spaces of a  
          String.
    4) public String stripLeading()
        * It will remove all leading spaces[Pre Spaces] to a String, it will not remove Trailing  
          spaces.
    5) public String stripTrailing()
        * It will remove all trailing Spaces to a String, it will not remove leading spaces.
    6) public Stream lines()
        * This method will split a String into no of Tokens in the form of Stream object on the  
          basis of '\n' or '\r' or '\r\n' literals.
        * the stream of lines extracted from this string Syntax: `public Stream<String> lines()`
3) Local-Variable Syntax for Lambda Parameters
    * In Java10 version, Local variables type inference was inroduced, with this, we can declare
      variables without providing data type explicitly and just by using "var", here type will be
      calculated on the basis of the provided variable values.
    * In Java10 version, "var" is not allowed for the parameter variables.
    * JAVA 11 version has provided flexibility to use "var" for the parameter variables in
      Lambda Expressions.
   # ***Limitations***
    * We must provide var for all Lambda parameters, not for few lambda parameters.
      ``` 
      interface Calculator{
      int add(int i, int j);
      }
      Calculator cal = (var i, j) -> i+j  Invalid
      Calculator cal = (var i, int j) -> i+j;  Invalid ```

* If we have simple Parameter in Lambda and if we want to use "var" then () are
  mandatory.
  ``` 
    interface Calculator{
    int sqr(int i);
    }
    Calculator cal = var i -> i+j  Invalid
    Calculator cal = (var i) -> i+j;  Invalid 
  ```


4) Nested Based Access Control
    * Upto Java10 version, in inner classes, if we access private member of any inner class in the
      respective outer class by using reflection API then we are able to get an exception like
      java.lang.IllegalAccessException, but, if we use Java11 version then we will get any
      exception , because, in JAVA11 version new methods are introduced in java.lang.Class
      class like

    1) public Class getNestHost() : It able to get the enclosed outer class java.lang.Class
       object.
    2) public Class[] getNestMembers(): It will return all nested members in the form of
       Class[].
    3) public boolean isNestmateOf(): It will check whether a member is nested member or
       not.

    * Note: In Java11 the above methods will be executed internally when we access private
      members of the outer class from nested class and nested members from outer class.
    * For Example:

```
         package java11features;   

      public class Test {   
      class NestTest {   
      private int count = 10;   
      }

       public static void main(String[] args) throws Exception {   
           Test.NestTest tt = new Test().new NestTest();   
           System.out.println(tt.count);   
    
           java.lang.reflect.Field f = NestTest.class.getDeclaredField("count");   
         f.setInt(tt, 2000);   
           System.out.println(tt.count);   
      }
    }   
```

### Running above program by setting Java Version as 10
```
D:\java11practice>set path=C:\Java\jdk-10.0.2\bin;
D:\java11practice>javac Test.java
D:\java11practice>java Test
10
Exception in thread "main" java.lang.IllegalAccessException: class Test cannot access a
member of class Test$NestTest with modifiers "private"
```
### Running above program by setting Java Version as 11
```
D:\java11practice>set path=C:\Java\jdk11\jdk-11\bin;
D:\java11practice>javac Test.java
D:\java11practice>java Test
10
2000
```

5) HTTP Client
6) Reading/Writing Strings to and from the Files
7) Flight Recorder 