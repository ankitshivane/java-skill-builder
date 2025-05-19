# Singleton Design Pattern (Creational) Masterclass

---

1. What is it?

* A singleton desgin pattern is the most popular and older design pattern within the design patterns catalog.
* If we create a class as Singleton then application will allow only one instance of that class and globally accessible
  throughout the application.

2. Real-world Analogy,Think of:

* Logger class
* Database connection pool
* Application configuration
* As you can see in all above examples, Only one shared instance is needed and reused.

3. How to create a class as singleton
    1. Declare the constructor of that class as private:- when we declare the costructor of the class as private, other
       class in the application context cannot create the object of the class directly (Stop allowing more instances)
    2. Declare a public static method: As you made the constructor of the class as private, no one from outside the
       class
       can call the constructor to create the object using new keyword.The methods of the same class can call the
       constructor to create
       objects, so in this method I can write the code to check and return only object of the class and we can access
       this method directly using Class name. (But if we declass this method as member method (non-static), to call it
       we need an object of the class (which is not possible). So to call this method without the object, declare this
       method as static method.) As this method contains only the logic for creating the object, this method is also
       called as factory method (static factory method).
    3. Declare a private static member of the same class type in the class: In the above static method, we need to write
       the
       code for returning only one instance of the class.How do you track whether an object for that class already
       exists? That's where you create a first object you will assign it to a member variable.So, In the next call
       to the method, you return the same object which you stored in the member variable.
    4. For example [refer to the given class](BasicSIngleton.java)
    5. But there is a problem with the given Problem: Multiple threads can create multiple instances.

### Eager initialization

* In the above piece of code we are instantiating the instance on the first call to getInstance() method. Instead of
  delaying the instantiation till we call method, we can instantiate it eagerly much before when class is loaded into
  the memory. For Example, [refer](EagerInitializationDemo.java)
* Drawback: Instance is created even if not used.

### Lazy initialization

* In most of the cases it is recommended to delay the instantiation process until the object is needed. To achieve this
  we can delay the creational process till the first call of getInstance() method. But as stated above the problem is in
  a multi threaded environment when more than one thread are executing at the same time, it might end-up in creating
  more than one instances of the class. To avoid this we can even declare that method as synchronized.
* For Example, [refer](LazyInitializationDemo1.java) Thread-safe (synchronized method)
* Drawback:
    * Synchronization slows down every call.
    * The preceding implementation works fine in the case of the single-threaded environment, but when it comes to
      multi-threaded systems, it can cause issues if multiple threads are inside the if condition at the same time. It
      will destroy the singleton pattern and both threads will get different instances of the singleton class.
    * For example: [refer](LayInitDrawbackDemo.java) run the program or refer the attached output in both cases.

### Double-checked Locking (Best for performance)

* Instead of making the whole method as shown in just above piece of code, it is enough to enclose only the conditional
  check in synchronized block.
* The preceding implementation (Thread safe lazy initialization) works fine and provides thread-safety, but it reduces
  the performance because of the cost associated with the synchronized method, although we need it only for the first
  few threads that might create separate instances. To avoid this extra overhead every time, double-checked locking
  principle is used. In this approach, the synchronized block is used inside the if condition with an additional check
  to ensure that only one instance of a singleton class is created.
* For Example:

```aiignore
public static LazyInitializationDemo1 getInstance() {
        synchronized (LazyInitializationDemo1.class) {
            if (null == instance) {
                instance = new LazyInitializationDemo1();
            }
        }
        return instance;
    }
```

* Again, we have a problem with the above piece of code, after the first call to the getInstance(), in the next calls to
  the method will check for instance == null check.while; doing this check, it acquires the lock to verify the condition
  which is not required. Acquiring and releasing the locks are quite costly, and we should avoid as much as we can. To
  avoid this, we can have double level check for the condition.
* It is recommended to declare the static member instance as volatile to avoid problems in a multithreaded
  environment. Volatile ensures visibility and prevents instruction reordering.
* For Example, [refer](DoubleCheckSingletonDemo.java)
* [Thread safe double check working](DoubleCheckSingletonWorkingInMultiThreading.java) In this example, we can see in
  multithreading environment how double check is working exactly with given output.

### Bill Pugh Singleton pattern

* The Bill Pugh Singleton pattern uses a static inner helper class to lazily and safely initialize the Singleton
  instance only when it is needed, without using synchronized blocks.
* This technique is based on the Java Language Specification (JLS) rule that:
* A class is not loaded until it is referenced for the first time.
* Why It Works (Theory):
    * The inner static class (Holder) is not loaded into memory until getInstance() is called.
    * This guarantees lazy initialization.
    * Class loading in Java is thread-safe and guaranteed to happen once, so no need for synchronized blocks.
    * Thus, this approach is simple, performant, and thread-safe.
* Advantages:
*

| Feature             | Benefit                          |
  |---------------------|----------------------------------|
| Lazy initialization | Loads instance only when needed  |
| Thread-safe         | Uses JVM’s classloader guarantee |
| No synchronization  | Avoids performance cost          |
| Readable and clean  | Easy to understand and implement |

* Best For:
    * High-concurrency environments
    * Singleton classes where lazy initialization and performance both matter
* For example, [Bill Pugh plain Singleton demo class](BillPugh/BillPughSingletonClass.java)
* For Example, [Refer this to get idea with output in multi threaded example](BillPugh/BillPughSingletonDemo.java)

---

# Problems With Singleton (and How to Fix Them)

* Even though Singleton is a popular pattern, it's not foolproof in traditional (non-enum) implementations.

## 1. Reflection Breaking Singleton

* For example, [Refer](reflectionToBreakSingleton/Demo1.java) you can refer output of the program and compare the
  hashCode generated to see if different objects are getting generated or not.

## 2. Serialization Breaking Singleton

* Sometimes in distributed systems, we need to implement Serializable interface in the singleton class so that we can
  store its state in the file system and retrieve it at a later point in time. Here is a small singleton class that
  implements Serializable interface also: [refer](serializationBreak/SerDemo1.java)
* The problem with serialized singleton class is that whenever we deserialize it, it will create a new instance of the
  class.
* So to avoid creating more than one objects of the singleton class even we serialize and de-serialize also, Thats where
  we need to write a readResolve() method as a part of singleton class.
* The de-serialization process will call readResolve() method automatically on a class to read the byte stream to build
  the objects. so we can avoid creating multiple objects using this approach.
* For Example, [Fix Singleton with Serialization using readResolve() method](serializationBreak/SerDemo2.java)

## 3. Cloning Breaking Singleton

✅ What is the Cloning Problem in Singleton?

* Cloning creates a new copy of an object. If your Singleton class allows cloning, then another instance of the
  Singleton will be created, violating the Singleton principle (only one instance should ever exist).

🔍 Clone Basics (Java)

* Object class defines the protected method clone()
* To allow cloning, a class must:
    * Implement Cloneable interface
    * Override the clone() method as public
    * If you call clone() without implementing Cloneable, you'll get a CloneNotSupportedException.

🚨 How Cloning Breaks Singleton (Example)

* [For Example](cloningBreak/Demo1.java) you can refer to this example to look how cloning is breaking singleton and
  able to create more than one object in output.
* Fix for singleton pattern from cloning, [For Example refer](cloningBreak/Demo2Fix.java), here in this example as a fix
  we have overriden the clone method in two approaches, in one approach we are returning the same static instance and in
  another approach we are throwing an CloneNotSupportedException to avoid cloning.

🔐 Summary Table: Cloning vs Singleton

*

| Scenario                                                  | Result                          | Singleton Safe? | Fix Needed? |
|-----------------------------------------------------------|---------------------------------|-----------------|-------------|
| No Cloneable anywhere                                     | Compile-time error              | ✅ Yes           | ❌ No        |
| Implements Cloneable + calls `super.clone()`              | Creates new instance            | ❌ No            | ✅ Yes       |
| Extends class that implements Cloneable                   | Inherited `clone()` creates new | ❌ No            | ✅ Yes       |
| Implements interface that extends Cloneable               | Cloning allowed                 | ❌ No            | ✅ Yes       |
| Overrides `clone()` to throw exception or return INSTANCE | Cloning prevented or safe       | ✅ Yes           | ❌ No        |
| Uses Enum Singleton                                       | Cloning not possible (safe)     | ✅ Yes           | ❌ No        |

* Best practice for Singleton Class
```aiignore

public class Singleton implements Cloneable, Serializable {

    private static final Singleton INSTANCE = new Singleton();

    private Singleton() {
        if (INSTANCE != null) {
            throw new RuntimeException("Use getInstance()");
        }
    }

    public static Singleton getInstance() {
        return INSTANCE;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Cloning not allowed");
    }

    // Fix for Serialization
    protected Object readResolve() {
        return INSTANCE;
    }
}


```