# 📘 Factory Method Pattern — Masterclass

🧠 1. What Is Factory Method Pattern?

* The Factory Method Pattern defines an interface for creating an object, but lets the subclasses decide which class to
  instantiate.
* Since these design patterns talk about the instantiation of an object they come under the category of creational
  design pattern.
*

In simpler terms:

* You call a method to get an object, but you don’t use new directly — the factory does that for you based on some
  logic.

✅ 2. Why Use Factory Method? (Use Cases)

| Problem                                                                       | Solution via Factory Method                         |
|-------------------------------------------------------------------------------|-----------------------------------------------------|
| You want to **decouple object creation logic**                                | Encapsulate it inside factory classes/methods       |
| You need to **create objects based on input** (type, env, config)             | Use a method to return different implementations    |
| Want to make your code **easier to extend, test, or maintain**                | Avoid tight coupling via `new` keyword              |
| Used heavily in frameworks like Spring (e.g., `ApplicationContext.getBean()`) | Return objects without exposing instantiation logic |

🧪 3. Real-Life Analogy

* Ordering pizza 🍕 — You just say what kind you want. The kitchen (factory) decides how to make it and gives it to you.
  You don’t worry about the ingredients or cooking steps.

🧵 5. Flow Explained

* [For Example](ClientApp.java)
* You have a common interface (Notification)
* Multiple implementations (EmailNotification, SMSNotification)
* A factory method (createNotification) decides which class to instantiate
* The client doesn’t use new — it just asks the factory to give the object.

📌 6. Key Concepts / Rules

| Rule                                            | Explanation                                                   |
|-------------------------------------------------|---------------------------------------------------------------|
| Don’t expose instantiation logic                | Always use the factory method                                 |
| Use interface or abstract class for the product | So you can return different implementations                   |
| Factory should be extendable                    | If you add new types, you can modify or extend the factory    |
| **Avoid `if-else`** in advanced version         | Use polymorphism, reflection, or registration-based factories |

🧨 7. Pitfalls / Edge Cases

* Too many if-else conditions → consider Factory Registry or Reflection-based factory
* Can't use new keyword directly in tightly controlled environments (Spring, testing, etc.)
* Misunderstanding with Abstract Factory (which creates families of related objects)

🏗️ 8. Spring Framework Use Case

* ApplicationContext.getBean("beanName") → Factory Method
* RestTemplateBuilder.build() → Builder + Factory
* JdbcTemplate/EntityManagerFactory → Factory Pattern