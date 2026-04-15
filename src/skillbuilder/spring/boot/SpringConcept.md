
In Spring Boot, the rules aren't just suggestions—they are the logic the framework uses to stitch your code together. We will tackle this in **4 Modules**, moving from how Spring "breathes" to how it talks to the outside world.

Here is our master index:

---

## 🏗️ Module 1: The Heart (IoC & Lifecycle)
This is where you are currently stuck. We will fix your understanding of how objects are born and managed.
1.  **Inversion of Control (IoC) & The Container:** Who is actually in charge?
2.  **Beans & Scopes:** Singleton vs. Prototype (The "One instance" rule).
3.  **Dependency Injection (DI):** Constructor vs. Setter vs. Field (The "Why field injection is evil" rule).
4.  **The Component Scan:** How Spring "finds" your code.
5.  **Bean Lifecycle:** `@PostConstruct` and `@PreDestroy`.

## ⚙️ Module 2: Configuration & The Environment
How to make your app flexible without changing code.
1.  **`@Value` and `@ConfigurationProperties`:** Dealing with external data.
2.  **Profiles:** How to handle Dev, Test, and Production environments.
3.  **Conditional Configuration:** `@ConditionalOnProperty` (The "Only run if..." rule).

## 🌐 Module 3: The Web Layer (REST APIs)
How your application talks to the internet.
1.  **`@RestController` vs `@Controller`:** The JSON vs. HTML rule.
2.  **Request Mapping:** `@GetMapping`, `@PostMapping`, and Path Variables.
3.  **Request Body & Validation:** Using `@Valid` to stop bad data.
4.  **Exception Handling:** `@ControllerAdvice` (The "Never show a raw stack trace" rule).

## 💾 Module 4: The Persistence Layer (Data)
How to save things forever.
1.  **Spring Data JPA:** The "No more SQL" rule.
2.  **Entities & Repositories:** Mapping Java objects to database tables.
3.  **Derived Query Methods:** How naming a method creates a query.
4.  **Transactional Management:** `@Transactional` (The "All or Nothing" rule).

---

# 1. Spring Boot Concept: Inversion of Control (IoC)
To understand **Inversion of Control (IoC)**, you have to stop thinking like a "Manager" and start thinking like a "Customer."

In traditional Java programming, **you** (the developer) are the manager. You decide exactly when to create an object using the `new` keyword. In Spring Boot, we flip that.

---

## 1. What is Inversion of Control (IoC)?

**The Rule:** You don't call the framework; the framework calls you.

* **Traditional Way:** If Class A needs Class B, Class A writes `B b = new B();`. Class A is in control of B's life.
* **The IoC Way:** Class A says, "I need something that looks like B." Spring Boot says, "Don't worry, I have one ready for you," and plugs it in.

The "Control" being inverted is the **creation and management of objects.**



---

## 2. The Spring Container (The Big Box)

The **ApplicationContext** is the "Container." Think of it as a massive, intelligent bucket. When your Spring Boot app starts, it:
1.  Scans your classes.
2.  Creates instances of classes marked with `@Component`.
3.  Puts them into this "Bucket" (the Container).
4.  Wires them together based on their needs.

> **Key Rule:** If an object is inside the Container, we call it a **Bean**. If you create it yourself with `new`, it is just a regular Java object, and Spring **cannot** help it (it won't inject dependencies or handle its lifecycle).

---

## 3. Why do we do this? (The "Peer" Reason)

Imagine your application has 100 classes that all need a `DatabaseConnection`.
* **Without IoC:** If the database URL changes, you might have to update 100 files where you wrote `new DatabaseConnection("url")`.
* **With IoC:** You define the connection **once** in the Container. Spring passes that same instance to all 100 classes. Change it in one place, and the whole app updates.

---

## 4. Why it Fails: The "Unknown Guest" Error

This is the most common mistake for beginners. Look at this scenario:

```java
// This is in the Container
@Component 
public class EmailService {
    public void send() { System.out.println("Email sent!"); }
}

// This is NOT in the Container (Missing @Component)
public class UserProcessor {
    @Autowired
    EmailService emailService;

    public void process() {
        emailService.send();
    }
}
```

**The Failure:**
If you try to use `UserProcessor`, the `emailService` will be `null`, and you'll get a `NullPointerException`.
**The Rule:** Spring only injects things into objects that it manages. Because `UserProcessor` doesn't have `@Component`, Spring ignores it. It's an "Unknown Guest." To Spring, it doesn't exist.

---

## 5. How to "See" the Container
You can actually ask Spring to show you the container. In your `main` method:

```java
public static void main(String[] args) {
    ApplicationContext context = SpringApplication.run(MyApp.class, args);
    
    // This is how you manually peek into the "Big Box"
    String[] allBeans = context.getBeanDefinitionNames();
    for(String bean : allBeans) {
        System.out.println("Bean name: " + bean);
    }
}
```

### Summary of IoC Rules:
1.  **Don't use `new`** for logic classes (Services, Controllers, Repositories). Let Spring handle it.
2.  **The Container is King:** If a class isn't a Bean, it can't use Spring's powers (like `@Autowired`).
3.  **Dependency Injection** is just the *act* of the Container handing a Bean to another Bean.

---

# 2. Spring Boot Concept: Component Scanning & Bean Creation

When you annotate a class with `@Component` in Spring, the framework automatically registers it as a bean in the IoC container during component scanning.

## Bean Naming Convention
- Spring derives the default bean name from the class name by converting it to camelCase with the first letter lowercase. For example, a class `UserService` becomes the bean named `userService`. You can override this by specifying a value in the annotation, like `@Component("customUserService")`. This naming applies to all stereotype annotations such as `@Service`, `@Repository`, and `@Controller`. [howtodoinjava](https://howtodoinjava.com/spring/spring-bean-naming/)
- with @Bean annotation, by default whatever name we will give to the method, that will be the name of the bean. For example, if we have a method like this:
```java@Bean
public UserService userService() {
    return new UserService();
}
```
The bean name will be `userService`. You can also specify a custom name by using the `name` attribute of the `@Bean` annotation, like this:
```java@Bean(name = "customUserService")
public UserService userService() {
    return new UserService();
}
```
In this case, the bean name will be `customUserService` instead of `userService`.

- In Spring, it requires no-arg constructor to be present inside a class which we marked as @Component. If we don't have no-arg constructor, then Spring will throw an error while creating the bean. This is because Spring uses reflection to create an instance of the class, and it needs a no-arg constructor to do so. If you want to use a constructor with arguments, you can use the `@Autowired` annotation on the constructor to tell Spring how to inject the dependencies. For example:
```java@Component
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
```
In this case, Spring will use the constructor with the `@Autowired` annotation to create an instance of `UserService`, and it will automatically inject the required `UserRepository` bean.
    - or you need to use a @Bean method to create the bean and specify the constructor arguments there. For example:
```java@Configuration
public class AppConfig {
    @Bean
    public UserService userService(UserRepository userRepository) {
        return new UserService(userRepository);
    }
}
```
In this case, Spring will call the `userService` method to create the bean and will automatically inject the required `UserRepository` bean as an argument.

## Bean Creation Process
Component scanning (enabled via `@ComponentScan` or Spring Boot's auto-configuration) detects `@Component`-annotated classes in specified base packages at startup. Spring then processes them through its bean lifecycle: instantiation via no-arg constructor (or configured constructor), population of dependencies via setter/field injection, invocation of `@PostConstruct` methods or `InitializingBean.afterPropertiesSet()`, and finally registering the fully initialized singleton bean (default scope) in the `ApplicationContext`. Custom logic can intervene using `BeanPostProcessor` or `BeanFactoryPostProcessor`. [stackoverflow](https://stackoverflow.com/questions/10604298/spring-component-versus-bean)

---

Now that we know the **Container** is the "Big Box" where objects live, we need to talk about **Beans** and their **Scopes**.

In Spring, a **Bean** is simply an object that is instantiated, assembled, and managed by the Spring IoC container. **Scope** refers to the lifecycle and "visibility" of that bean.

---

## 1. The Default Rule: Singleton Scope
In 95% of Spring applications, every bean is a **Singleton**.

**The Rule:** Spring creates **exactly one instance** of that bean for the entire application. Every time you `@Autowire` that bean into different classes, Spring gives everyone the **same exact object**.



### Why Singleton?
* **Performance:** Creating objects takes time and memory. If a service doesn't store user-specific data (it just has methods/logic), why create it more than once?
* **Statelessness:** Most Services and Controllers are "stateless." They are like a calculator; they don't care who is calling them, they just perform the calculation and return the result.

---

## 2. The Alternative: Prototype Scope
Sometimes you *want* a new instance every single time.

**The Rule:** A new bean instance is created **every time it is requested** from the container.



### How to define it:
```java
@Component
@Scope("prototype")
public class TaskRunner {
    public TaskRunner() {
        System.out.println("New TaskRunner created!");
    }
}
```

---

## 3. Why it Fails: The "State" Trap
This is the most dangerous mistake a developer can make with Singletons. Look at this code:

```java
@Service
public class UserService {
    private String currentUserName; // DANGER: This is "State"

    public void login(String name) {
        this.currentUserName = name;
    }

    public void printUser() {
        System.out.println("Current user is: " + currentUserName);
    }
}
```

**The Failure:**
If User A logs in, `currentUserName` becomes "Alice". If User B logs in a millisecond later on a different thread, `currentUserName` becomes "Bob".
When User A's process finally reaches `printUser()`, it will print **"Bob"**!

**The Rule:** Because Singletons are shared, they must be **Stateless**. Never store data that belongs to a specific request or user inside a Singleton bean's class variable.

---

## 4. Summary of Common Scopes
While Singleton and Prototype are the main ones, in a Web environment, you have three more:

| Scope | Description |
| :--- | :--- |
| **Singleton** | (Default) One instance per Spring Container. |
| **Prototype** | New instance every time it's injected/requested. |
| **Request** | New instance for every single HTTP request. |
| **Session** | New instance for every HTTP Session (user login session). |
| **Application** | One instance for the lifecycle of the ServletContext. |

---

## 5. The "Injection Mystery" Rule (Advanced Warning)
If you inject a **Prototype** bean into a **Singleton** bean, the Prototype bean will only be created **once** (at the time the Singleton is created).

If you want a new Prototype every time the Singleton uses it, you can't just use `@Autowired`. You have to use something called `ObjectFactory` or **Method Injection**. But don't worry about that yet—just remember: **The "Shortest Lifecycle" wins.**

---

Concept of @PostConstruct, @PreDestroy and Constructor

ANSWER:
- whenever we start the application due to component scanning first constructor will be called and then @PostConstruct method will be called. Whenever we stop the application, @PreDestroy method will be called. So the order is Constructor -> @PostConstruct -> @PreDestroy.
- @PostConstruct is used to perform any initialization after the bean has been created and dependencies have been injected. It is called only once in the lifecycle of a bean, right after the constructor and dependency injection.
- @PreDestroy is used to perform any cleanup before the bean is destroyed. It is called only once in the lifecycle of a bean, right before the bean is removed from the container.
- In summary, the lifecycle of a Spring bean is as follows:
1. Bean is instantiated (constructor is called).
2. Dependencies are injected (if any).
3. @PostConstruct method is called (if defined).
4. Bean is in use.
5. When the application is shutting down, @PreDestroy method is called (if defined).
6. Bean is destroyed.
7. It's important to note that @PostConstruct and @PreDestroy are only called for beans that are managed by the Spring container (i.e., beans defined with @Component, @Service, @Repository, or @Bean). If you create an instance of a class using the new keyword, these lifecycle methods will not be called.
8. Example:
```java

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class Comp2 {
    public Comp2(){
        System.out.println("Comp2 constructor called");
    }

    @PostConstruct
    public void init() {
        System.out.println("Comp2 @PostConstruct method called");
    }

    @PreDestroy
    public void cleanup() {
        System.out.println("Comp2 @PreDestroy method called");
    }
}
```