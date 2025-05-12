# Masterclass on synchronized keyword

### What is synchronized in Java?

1. It allows only one thread at a time to execute the synchronized code block or method on a shared object. If a method
   or block declared as the synchronized then at a time only one
   Thread is allow to execute that method or block on the given object.
2. Synchronized is the keyword applicable for methods and blocks but not for
   classes and variables.

### Why is it needed?

* In a multithreaded environment, multiple threads might:
    * Read or write shared variables
    * Change shared object state

* Without synchronization, this leads to:
    * Race conditions: When multiple threads try to read and modify shared data simultaneously, the final outcome
      depends on the unpredictable order in which their operations are interleaved. This can lead to incorrect data and
      inconsistent states. Example: Two threads incrementing a shared counter. If count++ is not atomic (it's actually
      read, increment, write), both threads might read the same initial value, both increment it, and both write back
      the same incremented value, resulting in one increment being lost.
    * Inconsistent data
    * Thread interference
* The main advantage of synchronized keyword is we can resolve date inconsistency problems.
* But the main disadvantage of synchronized keyword is it increases waiting time of the Thread and effects performance
  of the system.
* Hence if there is no specific requirement then never recommended to use synchronized keyword.
* Internally synchronization concept is implemented by using lock concept.
* Every object in java has a unique lock. Whenever we are using synchronized
  keyword then only lock concept will come into the picture.
* If a Thread wants to execute any synchronized method on the given object 1st it
  has to get the lock of that object. Once a Thread got the lock of that object then
  it's allow to execute any synchronized method on that object. If the synchronized
  method execution completes then automatically Thread releases lock.
* While a Thread executing any synchronized method the remaining Threads are
  not allowed execute any synchronized method on that object simultaneously. But
  remaining Threads are allowed to execute any non-synchronized method
  simultaneously. [lock concept is implemented based on object but not based on
  method]

### Types of Synchronization

| Type               | Where Used                        | Lock Acquired On                 |
|--------------------|-----------------------------------|----------------------------------|
| Instance method    | `synchronized` on instance method | Current object (`this`)          |
| Static method      | `synchronized` on static method   | Class object (`ClassName.class`) |
| Synchronized block | `synchronized(obj)` block         | Specific object reference        |

1. Synchronized Instance Method

```aiignore
public synchronized void display() {
    // only one thread per object can execute this at a time
}
```

* Lock acquired on: Current instance (this)

2. Synchronized Static Method

```aiignore
public static synchronized void displayStatic() {
    // only one thread per class can execute this at a time
}
```

* Lock acquired on: Class object (ClassName.class)

3. Synchronized Block

```aiignore
public void printData() {
    synchronized (this) {
        // critical section
    }
}
```

* You can also synchronize on a custom object:

```aiignore
synchronized(myLockObject) {
    // threads must acquire lock on myLockObject
}
```

---

# Locks In Synchronization

* Locks in Java threading provide a way to control access to shared resources among multiple threads. They ensure that
  only one thread can access a resource at a time, thus preventing data corruption and race conditions.

* Object Locks:
    * Object locks are used to synchronize access to an object’s methods and fields. When a thread acquires a lock on an
      object, no other thread can execute any of the object’s synchronized methods until the lock is released. To
      acquire a lock on an object, a thread can use the synchronized keyword when declaring a method or use the
      synchronized block.
    * Object-level locks are synchronized blocks/methods that use the intrinsic lock (or monitor lock) associated with
      an object. They ensure that only one thread can execute a synchronized block/method on a specific instance of the
      object at a time.
    * Basically, When a thread wants to execute a synchronized instance method, it must first acquire the intrinsic lock
      of the this object (the instance on which the method is called).
* Class level lock:
    * Every class in java has a unique lock. If a Thread wants to execute a static
      synchronized method then it required class level lock.
    * Once a Thread got class level lock then it is allow to execute any static
      synchronized method of that class.
    * While a Thread executing any static synchronized method the remaining
      Threads are not allow to execute any static synchronized method of that class
      simultaneously.
    * But remaining Threads are allowed to execute normal synchronized methods,
      normal static methods, and normal instance methods simultaneously.
    * Class level lock and object lock both are different and there is no relationship
      between these two.
    * When a thread wants to execute a synchronized static method, it must first acquire the intrinsic lock of the Class
      object to which the method belongs.

* Synchronized block:
    * If very few lines of the code required synchronization then it's never
      recommended to declare entire method as synchronized we have to enclose those
      few lines of the code with in synchronized block.
    * The main advantage of synchronized block over synchronized method is it
      reduces waiting time of Thread and improves performance of the system.
    * When a thread wants to execute a synchronized (someObject) { ... } block, it must first acquire the intrinsic lock
      of someObject.
    * CASE 1:
        * Example 1: To get lock of current object we can declare synchronized block as follows.
          If Thread got lock of current object then only it is allowed to execute this block.
          Synchronized(this){}

    * CASE 2:
        * Example 2: To get the lock of a particular object 'b' we have to declare a synchronized
          block as follows.
          If thread got lock of 'b' object then only it is allowed to execute this block.
          Synchronized(b){}
    * CASE 3:
        * Example 3: To get class level lock we have to declare synchronized block as follows.
          Synchronized(Display.class){}
          If thread got class level lock of Display then only it allowed to execute this block.
    * Note:As the argument to the synchronized block we can pass either object reference or
      ".class file" and we can't pass primitive values as argument [because lock concept is
      dependent only for objects and classes but not for primitives]
    *

```aiignore
Example:
Int x=b;
Synchronized(x){}
Output:
Compile time error.
Unexpected type.
Found: int
Required: reference
```

* Blocking: If a thread tries to acquire a lock that is already held by another thread, the attempting thread will be
  blocked. It will pause its execution and wait until the lock becomes available. Blocked threads are typically placed
  in a queue associated with the lock.
* Releasing the Lock: When the thread that holds the lock exits the synchronized method or block (either by normal
  completion or by throwing an exception), it automatically releases the lock. This allows one of the waiting (blocked)
  threads, if any, to acquire the lock and proceed.
* No inheritance for synchronization: Child class doesn’t automatically inherit the synchronized behavior unless you
  explicitly mark methods as synchronized.
* Deadlock is possible if two threads lock resources in opposite order
*

``` 
    Thread-1 locks A, then B  
    Thread-2 locks B, then A  
→ 💥 Deadlock
 ```

| Case                           | `synchronized` method | `synchronized(this)` block | `synchronized(obj)` block |
|--------------------------------|-----------------------|----------------------------|---------------------------|
| Whole method needs lock        | ✅                     | ✅                          | ❌                         |
| Only part of method needs lock | ❌                     | ✅                          | ✅                         |
| Multiple locks in one class    | ❌                     | ❌                          | ✅ (different objects)     |

✅ Point 1: Static synchronized method vs Instance synchronized method

* While a thread is executing a static synchronized method (Class-level lock), other threads can still access:
    * Normal instance methods
    * Instance synchronized methods
    * Static non-synchronized methods
    * In-depth example: [refer](SynchronizedDemo4.java) Proves: Static synchronized method does not block instance-level
      or non-synchronized methods.

✅ Point 2: Class-level lock vs Object-level lock (No relation)

* Static synchronized methods acquire a Class lock, while instance synchronized methods acquire an Object lock.
* These two locks are independent — threads holding one don't block the other.
* In-depth example:[refer](SynchronizedDemo5.java) Proves: Class-level and Object-level locks are completely separate
  and
  don't interfere.

---

# Dead lock:

* If 2 Threads are waiting for each other forever(without end) such type of
  situation(infinite waiting) is called dead lock.
* There are no resolution techniques for dead lock but several
  prevention(avoidance) techniques are possible.
* Synchronized keyword is the cause for deadlock hence whenever we are using
  synchronized keyword we have to take special care.
  👁‍🗨 Classic Example
* Thread-1 holds Lock A and waits for Lock B.
* Thread-2 holds Lock B and waits for Lock A.
* Neither can proceed → Deadlock!

✅ 2. Conditions for Deadlock (Coffman Conditions)

* Deadlock occurs only when all four of the following conditions are true:
*

| Condition               | Meaning                                                              |
  |-------------------------|----------------------------------------------------------------------|
| 1. **Mutual Exclusion** | Only one thread can hold a resource at a time                        |
| 2. **Hold and Wait**    | A thread holds a resource and waits for others                       |
| 3. **No Preemption**    | A resource cannot be forcibly taken away from a thread               |
| 4. **Circular Wait**    | A circular chain of threads exists where each waits for the next one |

* If you break any one of these, deadlock can be avoided.
* Example: [refer](DeadlockExample.java)
* Example 2: [refer](DeadlockDemo2.java)
* Note: here in Example 2, If we remove at least one synchronized keyword then we won't get DeadLOck. Hence
  synchronized keyword is the only reason for DeadLock due to this while using synchronized keyword we have to handling
  carefully.
* When Dead lock occurred, the threads cant even run the normal class method once locked occurred.

✅ 4. How to Detect Deadlocks
📌 1. Thread Dump Analysis

* Use jstack <pid> or view thread dump in IDE
* Look for lines like:

```aiignore
Found one Java-level deadlock:
Thread-1 is waiting to lock...
Thread-2 is waiting to lock...
```

📌 2. Using VisualVM or JConsole

* Attach to running JVM
* Check for blocked threads and resource contention

### ✅ How to Prevent Deadlocks

1. Lock Ordering
    * Always acquire locks in a global, consistent order.
    * Make sure all threads follow this order: lockA → lockB. For example:
    *

```aiignore
public void safeMethod() {
synchronized (lockA) {
synchronized (lockB) {
// Do something safely
}
}
}
```

2. Use tryLock() with timeout

* Use ReentrantLock with tryLock() to avoid indefinite waiting.

3. Use a Single Lock: If possible, use a single global lock to avoid lock interaction.
4. Avoid Nested Locks: Keep your synchronization blocks flat when possible.
5. Final Tip: Always Keep Synchronization Blocks Small

🔚 Summary Table

| Concept              | Takeaway                                   |
|----------------------|--------------------------------------------|
| What is Deadlock?    | Threads wait on each other forever         |
| When does it happen? | All 4 Coffman conditions are met           |
| How to detect?       | Thread dumps, VisualVM                     |
| How to prevent?      | Lock ordering, tryLock, avoid nested locks |
