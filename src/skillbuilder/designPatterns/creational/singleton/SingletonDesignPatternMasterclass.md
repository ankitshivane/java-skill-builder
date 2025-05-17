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
* Drawback: Synchronization slows down every call.

### Double-checked Locking (Best for performance)

* Instead of making the whole method as shown in just above piece of code, it is enough to enclose only the conditional
  check in synchronized block.
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