# 📚 Java Sealed Classes — Ultimate Masterclass 🚀

---
🧠 1. What Are Sealed Classes?

* Sealed Classes restrict which other classes or interfaces can extend or implement them.
* This controls the inheritance hierarchy.
* In Java, we have the concept of abstract classes. It is mandatory to inherit from these classes since objects of these
  classes cannot be instantiated. On the other hand, there is a concept of a final class in Java, which cannot be
  inherited or extended by any other class. What if we want to restrict the number of classes that can inherit from a
  particular class? The answer is sealed class.
* So, a sealed class is a technique that limits the number of classes that can inherit the given class. This means that
  only the classes designated by the programmer can inherit from that particular class, thereby restricting access to
  it. when a class is declared sealed, the programmer must specify the list of classes that can inherit it.
* The concept of sealed classes in Java was introduced in Java 15.
* It allows us to specify which classes or interfaces are allowed to extend or implement a particular class or
  interface.
* It gives more predictability, security, and better modeling.

📜 2. Why Sealed Classes?

* Before Java 15, anyone could extend your class unless it was final.
* You had 2 extremes:
    * final — Nobody can extend.
    * non-final — Anybody can extend.
* Problem:\
  ✅ No control.\
  ✅ Can lead to unexpected behavior or bad design.
* Solution:\
  ✅ Sealed classes — you can allow only specific classes to extend/implement.
* Inheritance is a fundamental concept of Java as an object-oriented programming language. It focuses on creating a
  hierarchy of related classes by inheriting properties and behaviors of one class to another class. The sealed
  classes/interfaces offer us an option to restrict the inheritance process as per our requirement.

🔥 3. Syntax of Sealed Classes\

* Steps to Create a Sealed Class
    * Define the class that you want to make a seal.
    * Add the “sealed” keyword to the class and specify which classes are permitted to inherit it by using the “permits”
      keyword.

✅ Declaring a Sealed Class:

```
public sealed class Shape permits Circle, Rectangle {
    // fields and methods
}
```

✅ Subclasses must either be:

* final (cannot be extended)
* sealed (can control their own subtypes)
* non-sealed (normal, open class)

⚡ 5. Subclass Rules (MANDATORY)\
✔ If a class is sealed, its immediate subclasses must declare themselves as either:

* final
* sealed
* non-sealed

👉 You MUST specify one of these. Otherwise, compilation error.

✅ Example:

```aiignore
public sealed class Vehicle permits Car, Truck, Bike {
}

public final class Car extends Vehicle { }          // final

public sealed class Truck extends Vehicle permits MiniTruck { } // sealed again

public non-sealed class Bike extends Vehicle { }     // non-sealed
```

✅ MiniTruck must again declare (final/sealed/non-sealed) if Truck is sealed.

🛡️ 6. Where You Can Use Sealed Classes?

* Classes
* Interfaces
* Abstract Classes

✅ Example with Interface:

```aiignore
public sealed interface Animal permits Dog, Cat {
}

final class Dog implements Animal { }
final class Cat implements Animal { }

```

✅ Sealed With Record: Record Classes as Permitted Subclasses

* We can name a record class in the permits clause of a sealed class or interface.
* Sealed class in Java works very well with records. Since record is implicitly final, so it can only implement a sealed
  interface & the sealed hierarchy is
  even more concise.
* As record can not be sub-classed, therefore it can not use permits keyword. Thus, there is a single level hierarchy
  with records.
* Working Demo [refer](recordDemo/SealedRecordDemo.java)

✅ Key-points about sealed classes:

* A class declared with sealed keyword then it compulsorily have a sub-class declared in permits keyword and also that
  subclasses or interfaces must be inheriting from this parent sealed class otherwise we will get compile time error.
* As describe above the subclass must be either final, non-sealed and sealed (again if it is a Sealed class then it must
  have its children declared.)
* If any random class or interface which is not declare in the permits list of sealed classes tries to inherit the
  sealed class then we will get compile time error For Example:

```aiignore
sealed class Shape permits Circle {

}

non-sealed class Circle extends Shape {

}
// here if you try to run this program you will get compile time error.
class Rectangle extends Shape {

}
```

* we class create a further child class from a class declared using non-sealed keyword also even if its not declared in
  permits classes or interfaces list, For Example: here in above code base Circle is declared as non-sealed so here we
  can create a new sub-class of circle
* We can use it at the class or interface level, not for methods or fields.
* We can not declare an Functional interface as sealed interface, if we try then we will get compile time error.
* One of the rule or constraint for Sealed classes is --> Permitted subclasses must directly extend the sealed class.
  For example:For example, if X is a sealed class which permits Y to extend it and Y is also a sealed class that permits
  Z.
  Then Z can only extend Y, it can not directly extend
  X. [refer](SealedClsDemo2.java)
* Subclasses of sealed classes must be in the same module as the sealed class, otherwise we wont be able to permit those
  subclasses and will get compile time error. [refer](subpkg1/Account.java)
* A permitted subclass must extend the parent sealed class. For example, if sealed class A permits a class B, then B has
  to extend A. Similarly, the implementing class must explicitly implement the parent sealed interface.
* Check the Working of Sealed Keyword with Interfaces [refer](Sealedinterfaced/SealedInterfaceWorkingDemo.java)

🏛️ 7. Placement of Subclasses
✅ Subclasses can be:

* In the same file as the sealed class OR
* In different files (but must be in the same package).
  ✅ If you use permits, you must list fully qualified names if they are in a different package.

🧩 8. Permits Clause

* You can omit permits clause ONLY IF the permitted classes are nested inside the sealed class.
  ✅ Example:

```aiignore
public sealed class Shape {
    public final class Circle extends Shape { }
    public final class Square extends Shape { }
}
```

* If classes are outside, you MUST use permits.

🔥 13. Interview-Ready Summary Points (Must Speak)

* "Sealed classes introduced in Java 15 and finalized in Java 17."
* "They allow controlled inheritance by specifying permitted subclasses."
* "Subclasses must explicitly declare themselves as final, sealed, or non-sealed."
* "Permits clause is mandatory unless subclasses are nested."
* "They improve security, API design, domain modeling, and restrict unexpected subclassing."
* "Sealed classes can be used with classes, abstract classes, and interfaces."

