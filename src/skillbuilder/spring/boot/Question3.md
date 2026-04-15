## CASE 1:

### Question 3: What happens if you create a class with @Component annotation having a parameterized constructor and also from configuration class you try to create a Bean of the same class using @Bean annotation and try to use it in a Spring-managed class? Will it work? Why or why not?

```java
package com.demo;

import org.springframework.stereotype.Component;

@Component
public class ClsWithoutAnyAnnotation {
String name;

    public ClsWithoutAnyAnnotation(String name) {
        System.out.println("ClsWithoutAnyAnnotation param constructor called");
        this.name = name;
    }

     public String doSomething() {
        System.out.println("Doing something in ClsWithoutAnyAnnotation:" + name);
        return name;
    }
}
```

```java
package com.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public ClsWithoutAnyAnnotation createclsWithoutAnyAnnotation(){
        System.out.println("Creating bean of ClsWithoutAnyAnnotation from AppConfig");
        return new ClsWithoutAnyAnnotation("Ankit");
    }

    @Bean
    public String createStringBean() {
        System.out.println("Creating a String bean from AppConfig");
        return "This is a string bean";
    }
}
```
and now autowire this class in some other place like this:

```java

    @Autowired
    ClsWithoutAnyAnnotation clsWithoutAnyAnnotation;
```

---

**ANSWER:**

- here when you start the application, Spring will try to create a bean of `ClsWithoutAnyAnnotation` class because it is annotated with `@Component`. But since it has a parameterized constructor and no default constructor, Spring will try to search the beans for its parameter objects in this case it is `String` bean. as we explicitly created a `String` bean in the `AppConfig` class, Spring will find it and use it to create the bean of `ClsWithoutAnyAnnotation` class. So, in this case, it will work and the bean of `ClsWithoutAnyAnnotation` class will be created successfully.
- then as we defined same ClsWithoutAnyAnnotation class as a bean in the AppConfig class using @Bean annotation, Spring will try to create another bean of the same class using the method defined in the AppConfig class. So, in this case, it will also work and the bean of ClsWithoutAnyAnnotation class will be created successfully using the method defined in the AppConfig class., please check below logs for more clarity:
```
Creating a String bean from AppConfig
ClsWithoutAnyAnnotation param constructor called
SomeController constructor called
Creating bean of ClsWithoutAnyAnnotation from AppConfig
ClsWithoutAnyAnnotation param constructor called
```
- as you can see here 'ClsWithoutAnyAnnotation param constructor called' statement twice which means both the beans of `ClsWithoutAnyAnnotation` class are created successfully, one from the `@Component` annotation and another from the `@Bean` method in the `AppConfig` class. So, in this case, it will work and both the beans will be created successfully.
- In the spring application container you will see two beans of `ClsWithoutAnyAnnotation` class, one with the name `clsWithoutAnyAnnotation` which is created from the `@Component` annotation and another with the name `createclsWithoutAnyAnnotation` which is created from the `@Bean` method in the `AppConfig` class. So, in this case, it will work and both the beans will be created successfully.
  - first Bean name will be `clsWithoutAnyAnnotation`
  - second Bean name will be `createclsWithoutAnyAnnotation`

---

## NOW CASE 2:
### - What if we removed the @Bean method from the AppConfig class which is creating a String object keeping everything else same, will it work? Why or why not?

**ANSWER:**

- here when you start the application, Spring will try to create a bean of `ClsWithoutAnyAnnotation` class because it is annotated with `@Component`. But since it has a parameterized constructor and no default constructor, Spring will try to search the beans for its parameter objects in this case it is `String` bean. as we have removed the `String` bean from the `AppConfig` class, Spring will not find any `String` bean in the context and it will throw an error while trying to create the bean of `ClsWithoutAnyAnnotation` class. The error will be something like this: `No qualifying bean of type 'java.lang.String' available: expected at least 1 bean which qualifies as autowire candidate. Dependency annotations: {}`. So, in this case, it will not work and it will throw an error while trying to create the bean of `ClsWithoutAnyAnnotation` class.
- this will fail even if we keep the @Bean method for creating the bean of `ClsWithoutAnyAnnotation` class in the `AppConfig` class because the first priority goes to the `@Component` annotation for creating the bean of `ClsWithoutAnyAnnotation` class and since it has a parameterized constructor and no default constructor, it will try to search the beans for its parameter objects in this case it is `String` bean. as we have removed the `String` bean from the `AppConfig` class, Spring will not find any `String` bean in the context and it will throw an error while trying to create the bean of `ClsWithoutAnyAnnotation` class.

---

## NOW CASE 3:
### - Now lets say in AppConfig class we defined the @Bean like below method
  ```java
  @Bean
  public ClsWithoutAnyAnnotation clsWithoutAnyAnnotation(){
  System.out.println("Creating bean of ClsWithoutAnyAnnotation from AppConfig");
  return new ClsWithoutAnyAnnotation("Ankit");
  }
  ```
### - here we kept the method name same as the class name but with camel case, will it work? Why or why not?

**ANSWER:**

- here it will work and spring application will start but the logs will be something like this:
```
SomeController constructor called
Creating bean of ClsWithoutAnyAnnotation from AppConfig
ClsWithoutAnyAnnotation param constructor called
Creating a String bean from AppConfig
```

- did you observe any difference here comparing to case 1? here you can see that the statement 'Creating bean of ClsWithoutAnyAnnotation from AppConfig' is printed which means the bean of `ClsWithoutAnyAnnotation` is created only by @Bean annotation and the bean creation priority shifted from @Component to @Bean because the method name of @Bean is same as the class name with camel case which is the default naming convention for beans created by @Component annotation. So, in this case, it will work and the bean of `ClsWithoutAnyAnnotation` class will be created successfully using the method defined in the `AppConfig` class and the bean created by @Component annotation will be ignored.
- in the spring application context you will see only one bean of `ClsWithoutAnyAnnotation` class with the name `clsWithoutAnyAnnotation` which is created from the `@Bean` method in the `AppConfig` class and the bean created by @Component annotation will be ignored. So, in this case, it will work and only one bean will be created successfully.

---

## NOW CASE 4:
### - Now lets say we added @Value annotation to the parameter of the constructor of `ClsWithoutAnyAnnotation` class like below:
```java

@Component
public class ClsWithoutAnyAnnotation {
    String name;

    public ClsWithoutAnyAnnotation(@Value("${from.prop.file}") String name) {
        System.out.println("ClsWithoutAnyAnnotation param constructor called");
        this.name = name;
    }

     public String doSomething() {
        System.out.println("Doing something in ClsWithoutAnyAnnotation:" + name);
        return name;
    }
}


@Configuration
public class AppConfig {

    @Bean
    public ClsWithoutAnyAnnotation anyOtherName(){
        System.out.println("Creating bean of ClsWithoutAnyAnnotation from AppConfig");
        return new ClsWithoutAnyAnnotation("Ankit");
    }

}
```
### - here we added @Value annotation to the parameter of the constructor of `ClsWithoutAnyAnnotation` class and we are trying to create a bean of `ClsWithoutAnyAnnotation` class using @Bean annotation in the AppConfig class, will it work? Why or why not?

**ANSWER:**
- here it will work and spring application will start successfully because the @Value annotation is used to inject values from property files or environment variables and it does not affect the bean creation process. So, in this case, it will work and the bean of `ClsWithoutAnyAnnotation` class will be created successfully using the method defined in the `AppConfig` class with 'anyOtherName' instance name and the value of the parameter will be injected from the property file or environment variable as specified in the @Value annotation.
- and first bean will be created by @Component annotation with the name `clsWithoutAnyAnnotation` and the second bean will be created by @Bean annotation with the name `anyOtherName` and both the beans will be created successfully. So, in this case, it will work and both the beans will be created successfully.
- Please find logs as below for more clarity:
```
ClsWithoutAnyAnnotation param constructor called
SomeController constructor called
Creating bean of ClsWithoutAnyAnnotation from AppConfig
ClsWithoutAnyAnnotation param constructor called
```