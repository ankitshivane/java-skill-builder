# Singleton Design Pattern Masterclass: Understand, Break, and Defend Like a Pro


---

## Table of Contents
1. [What Is the Singleton Pattern?](#1-what-is-the-singleton-pattern)
2. [Real-World Analogies](#2-real-world-analogies)
3. [Why Use a Singleton?](#3-why-use-a-singleton)
4. [How to Implement a Singleton (Theory & Practice)](#4-how-to-implement-a-singleton-theory--practice)
    - Eager Initialization
    - Lazy Initialization
    - Thread-safe Singleton
    - Double-Checked Locking
    - Bill Pugh Singleton
5. [Common Pitfalls: How Singleton Can Be Broken](#5-common-pitfalls-how-singleton-can-be-broken)
    - Multithreading
    - Reflection
    - Serialization
    - Cloning
6. [Best practice for Singleton Class](#6-Best-practice-for-Singleton-Class)

## 1. What Is the Singleton Pattern?



The **Singleton Design Pattern** ensures that only **one instance** of a class is created throughout the lifetime of your application.  
This single instance is “globally accessible”: any part of your code can use it, but no duplicates can exist.

> **Why was Singleton created?**  
In many software systems, you often need to:
> - Coordinate a global resource (like a logging service)
> - Avoid redundancy/configuration duplication (e.g., application configuration)
> - Manage expensive resources (such as database connection pools)
>
> Allowing multiple instances could lead to bugs, wasted resources, or inconsistent data. Singleton is designed to solve these issues.

---

## 2. Real-World Analogies

Let’s put Singleton in day-to-day life:

- **Logger**: Every part of your app writes logs through the same object.
- **Database Connection Pool**: Only one pool created for all DB operations.
- **App Configuration**: One source of truth throughout the app.
- As you can see in all above examples, Only one shared instance is needed and reused.

## 3. Why Use a Singleton?

**Key motivations for Singleton:**
- Saving memory or resources by not duplicating heavyweight objects
- Ensuring consistency across your application (all parts ‘see’ the same instance)
- Centralizing access: One global point for data or service management

> **When NOT to use:** If your class requires different states in different parts of your app, Singleton may hurt flexibility or testability.

---

## 4. How to Implement a Singleton (Theory & Practice)

1. **Private Constructor:** Declare the constructor of that class as private.Hide constructor so nobody outside can call `new`to restrict instantiation.
2. **Public Static Getter:** Declare a public static method. Because the constructor is private, no object can be created directly from outside.
   A static method can be called without an object, making it the only entry point to get the instance. As this method contains only the logic for creating the object, this method is also
   called as factory method (static factory method).
3. **Static Instance:** Declare a private static variable of the same class type. This will hold the single instance of the class, return by getInstance() method.
> For example: 
> [refer to the given class](BasicSIngleton.java)  – Shows a simple singleton pattern implementation.
5. But there is a problem with the given Problem: Multiple threads can create multiple instances. 
> For Example: 
> [refer to the given class and verify Output](BreakingBasicSingletonWithMultithreadingDemo.java)

### Eager Initialization

* In the Above piece of code we are instantiating the instance on the first call to getInstance() method. Instead of
  delaying the instantiation till we call method, here In eager initialization, the Singleton instance is created at the time of class loading, even before any method is called.
* This means the object is ready to use as soon as the class is referenced, and you don’t need to perform any null checks or synchronization.
> For Example, [Refer Eager Initialization of Singleton](EagerInitializationDemo.java)
* Drawback: The major downside is resource wastage. If the instance is never used during the application lifecycle, it still consumes memory unnecessarily. 
* **Use Eager Initialization When:**
    * You’re certain the instance will be used during application startup.
    * Object creation is not resource-intensive.
    * You prefer simplicity over lazy loading.

### Lazy initialization

* In most of the cases it is recommended to delay the instantiation process until the object is needed. To achieve this
  we can delay the creational process till the first call of getInstance() method.
>For example: [Simple Lazy Initialization of Singleton](LazyInit/LazyInitializedSingleton.java)
* But as stated above (in the singleton class creation steps) the problem is in
  a multi threaded environment when more than one thread are executing at the same time, it might end-up in creating
  more than one instances of the class. To avoid this we can even declare that method as synchronized.
> For Example, [Thread-Safe Lazy init singleton](LazyInit/LazyInitializationThreadSafe.java) (synchronized method)
* Drawback:
    * Synchronization slows down every call.
  >For example: [refer](LazyInit/LayInitDrawbackDemo.java) run the program or refer the attached output in both cases (with Synchronized keyword and without synchronized keyword on getInstance() method)

### Double-Checked Locking (Best for performance)

* Instead of making the whole method as shown in just above piece of code, it is enough to enclose only the conditional
  check in synchronized block.
* The preceding implementation (Thread safe lazy initialization) works fine and provides thread-safety, but it reduces
  the performance because of the cost associated with the synchronized method, although we need it only for the first
  few threads that might create separate instances. 
* To avoid this extra overhead every time, double-checked locking
  principle is used. In this approach, the synchronized block is used inside the IF Condition with an additional check
  to ensure that only one instance of a singleton class is created.
> For Example, [Double Check Locking Singleton Demo](DoubleCheckSingletonDemo.java)
* Refer to the below piece of code: here we are not declaring the if condition as "if (null == instance)" before synchronized block.
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

* The Problem with above piece of code is:
  * Every call to getInstance()—even after the instance is created—still has to acquire the lock on the class.
  * This happens even when the instance already exists and no object creation is required.
  * Lock acquisition and release are relatively expensive operations, and doing this repeatedly when it's not needed leads to unnecessary performance overhead.
> For Example: [Thread safe double check working](DoubleCheckSingletonWorkingInMultiThreading.java) In this example, we can see in
  multithreading environment how double check is working exactly with given output.
* **Why This works:**
  * The first if (instance == null) check is performed without locking. If the instance already exists, the method skips synchronization entirely — this gives us a significant performance benefit in high-concurrency applications.
  * Only when the instance is still null will the code enter the synchronized block, ensuring that only one thread creates the instance.
  * This avoids unnecessary locking after the object has been created — which was the main issue in previous implementations.
* **Note:** To ensure that the instance is correctly created and visible to all threads, you must declare the instance variable as volatile
* **Why volatile?**:
  * It prevents instruction reordering, where a reference to a partially constructed object might become visible to other threads.
  * It ensures visibility guarantees — once the object is initialized, all threads will see the fully constructed object.
> * If one thread has already created the instance, then for all other threads, the instance will no longer be null.
  They will not enter the synchronized block at all, thus avoiding the cost of acquiring a lock.
  This is the core idea behind the “double-check” optimization.

### Bill Pugh Singleton (Best in Modern Java)

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
>For example, [Bill Pugh plain Singleton demo class](BillPugh/BillPughSingletonClass.java)
> 
> For Example, [Bill Pugh in multi threaded example](BillPugh/BillPughSingletonDemo.java)

---

## 5. Common Pitfalls: How Singleton Can Be Broken

Singleton isn’t foolproof. Here’s how it can go wrong if you’re not careful:

## 1. Reflection Breaking Singleton

* Java Reflection can access private constructors and create more than one instance.
> For example, [Problem with Reflection](reflectionToBreakSingleton/Demo1.java) you can refer output of the program and compare the
  hashCode generated to see if different objects are getting generated or not.
* **Theory:** Reflection lets code bypass access controls and call the constructor directly.
* **Reflection Defense(FIXED):** Throw an exception in the constructor if the instance already exists.
> Refer [FIX Singleton breaking from reflection](reflectionToBreakSingleton/FixForReflectionIssueWithSingleton.java)

## 2. Serialization Breaking Singleton

* If your singleton implements `Serializable`, Java’s default serialization creates a **new instance** upon deserialization.
* Sometimes in distributed systems, we need to implement Serializable interface in the singleton class so that we can
  store its state in the file system and retrieve it at a later point in time. Here is a small singleton class that
  implements Serializable interface, showing how it breaks singleton with serialization: 
* > [Refer: Serialization breaking singleton](serializationBreak/SerDemo1.java)
* The problem with serialized singleton class is that whenever we deserialize it, it will create a new instance of the
  class.
* **Theory:** Deserialization always makes a new object—unless you tell Java what to do!
* So to avoid creating more than one objects of the singleton class even we serialize and de-serialize also, Thats where
  we need to write a readResolve() method as a part of singleton class.
* **Serialization Defense(FIXED):**
  * Implement a `readResolve()` method returning the existing instance.
  * The de-serialization process will call readResolve() method automatically on a class to read the byte stream to build
    the objects. so we can avoid creating multiple objects using this approach.
  >For Example, [Fix Singleton with Serialization using readResolve() method](serializationBreak/SerDemo2.java)

## 3. Cloning Breaking Singleton

**What is the Cloning Problem in Singleton?**

* Cloning creates a new copy of an object. If your Singleton class allows cloning, then another instance of the
  Singleton will be created, violating the Singleton principle (only one instance should ever exist).

* Clone Basics (Java)
  * Object class defines the protected method clone()
  * To allow cloning, a class must:
      * Implement Cloneable interface
      * Override the clone() method as public
      * If you call clone() without implementing Cloneable, you'll get a CloneNotSupportedException.

**How Cloning Breaks Singleton (Example)**

> [For Example](cloningBreak/Demo1.java) you can refer to this example to look how cloning is breaking singleton and
  able to create more than one object in output.
* **Cloning Defense:** Fix for singleton pattern from cloning,
>[For Example refer](cloningBreak/Demo2Fix.java), here in this example as a fix
  we have overriden the clone method in two approaches, in one approach we are returning the same static instance and in
  another approach we are throwing an CloneNotSupportedException to avoid cloning.

**Summary Table: Cloning vs Singleton**



| Scenario                                                  | Result                          | Singleton Safe? | Fix Needed? |
|-----------------------------------------------------------|---------------------------------|-----------------|-------------|
| No Cloneable anywhere                                     | Compile-time error              | ✅ Yes           | ❌ No        |
| Implements Cloneable + calls `super.clone()`              | Creates new instance            | ❌ No            | ✅ Yes       |
| Extends class that implements Cloneable                   | Inherited `clone()` creates new | ❌ No            | ✅ Yes       |
| Implements interface that extends Cloneable               | Cloning allowed                 | ❌ No            | ✅ Yes       |
| Overrides `clone()` to throw exception or return INSTANCE | Cloning prevented or safe       | ✅ Yes           | ❌ No        |
| Uses Enum Singleton                                       | Cloning not possible (safe)     | ✅ Yes           | ❌ No        |

## 6. Best practice for Singleton Class
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