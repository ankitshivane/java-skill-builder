# Default Methods in Java 8 Masterclass

## What is a Default Method?

* The default method in Java 8 is one of the key enhancements that made interfaces more powerful and flexible.
* Until Java 1.7 every methods declared inside interface is always public abstract by default. we cant declare concrete
  methods inside it else will get compilation error,
* Every variable declared inside interface is always public static final whether we are declaring or
  not.
* A default method is a method in a Java interface that has a method implementation. It uses the default
  keyword and allows interfaces to provide concrete methods.
* Syntaxt:

```aiignore
interface MyInterface {
    default void sayHi() {
        System.out.println("Hi from default method!");
    }
}
```

🔍 Why Default Methods Were Introduced

* As I said earlier, Before Java 8 Interfaces could only contain abstract methods (no body), also Adding a new method to
  an interface would break all implementing classes.
* So with Java 8 default methods, This default methods are by default available to all implementation classes, based on
  the requirement implementation classes can either use these default implementation directly or can override it.
* here the advantage of adding default methods inside interface is existing classes won't break hence provide backward
  compatibility.

Note or Cases to consider:

* The scope of default method is implicitly "public" whether we declare it or not. also only public modifier is allowed
  on default methods, we can not reduce the scope of this
  method in inheriting classes, and doing so we will get the compilation error.
* Java does not allow default methods in interfaces to override or define methods from java.lang.Object (e.g., equals(),
  hashCode(), toString()) because it would introduce ambiguity and conflict with class inheritance rules.
* For Example:

```aiignore
default String toString() {
        return "obj";
    }
```

* from Default method we can access public static final variable declared inside the interface.
* from Default method we can call other default methods directly with or without "this" ref.
* from Default method we can call other static methods directly with or without an Interface name.
* default method Can be overridden in implementing class
* Inside implementing classes, we can use "super" keyword to invoke the interface default method.

### Default methods vs multiple Inheritance (Diamond Problem)

* If a class implements two interfaces with the same default method, it must override the method to resolve ambiguity.
* In the implementation class we can provide complete new implementation or we can call any
  interface method with "super" keyword as "InterfaceName.super.methodName()"
* For Example

```aiignore

public class DemoInterf  {
    public static void main(String[] args) {
        C c=new C();
        c.show();
    }
}

interface A {
    default void show() {
        System.out.println("A's show");
    }
}

interface B {
    default void show() {
        System.out.println("B's show");
    }
}

class C implements A, B {
    @Override
    public void show() {
        System.out.println("C's show");
        A.super.show(); // Call A's version
        B.super.show(); // Call B's version
    }
}

```

* Output:

```aiignore
C's show
A's show
B's show
```

### Bonus: Interview question:  in case we create a class that extends base class and implements an interface. if both base class and interface default method with same signature then which definition will be picked by java?

* When a class extends a base class and also implements an interface that contains a default method with the same
  signature, Java will always use the method from the base class. This is because in Java’s method resolution hierarchy,
  class methods take precedence over interface default methods.
* Program:

```aiignore
interface Interf3 {
    default void m1() {
        System.out.println("Interface m1");
    }
}

class Base {
    public void m1() {
        System.out.println("Base class m1 method");
    }
}

class Child extends Base implements Interf3 {}

public class Demo2 {
    public static void main(String[] args) {
        Child c = new Child();
        c.m1();  // ✅ Output: Base class m1 method
    }
}

```

* ✅ Summary Table

| Case                                           | What Happens          | Why                       |
|------------------------------------------------|-----------------------|---------------------------|
| Only interface has `default m1()`              | Interface method used | No class version exists   |
| Base class has `m1()`                          | Class method used     | Class wins over interface |
| Both interfaces have `m1()`                    | Must resolve manually | Ambiguity, compiler error |
| Class and multiple interfaces with same `m1()` | Class wins            | No ambiguity for JVM      |

