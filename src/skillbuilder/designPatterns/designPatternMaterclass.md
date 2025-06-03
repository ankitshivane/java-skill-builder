# Design Patterns Masterclass

* In Software engineering a design pattern is general reusable solution to commonly occurring problem within a given
  context in software design.
    * A design pattern is not a finished design that can be transformed directly into a code. It is a description or
      template for how to solve a problem that can be used in many different situations.
    * The design patterns are language independent strategies for solving object oriented design problems
    * Design patterns has no relation with designing phase of the project, they will be purely implemented in the
      development phase of the project.
    * GOF Pattern Catalog: According to GOF, all the design patterns can be classified into the following categories:
        * Creational Pattern: Concern the process of object creation
        * Structural Pattern: Deal with the composition of classes and objects
        * Behavioral Pattern: Deal with the interaction of classes and objects

## Creational Patterns:

* How an object can be created That is creational design patterns are the design pattern that deal with object creation
  mechanisms, trying to create an object suitable to the situation.
* The Basic form of object creation (using new keyword) could result in design problems or added complexity to the
  design. Creational design pattern solves this problem by somehow controlling this object creation.
* All the creational patterns define the best possible way in which an object can be instantiated. The can be
  categorized as below:
    * Singleton - [Indepth Explanation refers...](creational/singleton/SingletonDesignPatternMasterclass.md)
    * Factory Method - [Indepth Explanation refers...](creational/factory/FactoryMethodDesignPattern.md)
    * Abstract Factory
    * Builder - [Indepth Explanation refers...](creational/builder/BuilderDesignPattern.md)
    * Prototype

## Structural Patterns:

* Structural pattern is design patterns that ease the design by identifying a simple way to realize relationships
  between entities. Structural patterns describe how objects and classes can be combined to form larger structures.
* According to GOF Structural design pattern is categorized into below:
    * Adapter
    * Bridge
    * Composite
    * Decorator
    * Facade
    * Flyweight
    * Proxy

## Behavioral Patterns

* Behavioral design pattern is design patterns that identify common communication pattern between objects and realized
  these patterns. By doing this so, these patterns increase flexibility in carrying out this communication.
* That is prescribing the way objects interact with each other, Below are the 11 Behavioral design patters:
    * Observer - [Indepth Explanation refers...](behavioural/Observer/ObserverDesignPatternMasterclass.md)
    * Strategy
    * Template Method
    * Command
    * Chain of Responsibility
    * Iterator
    * Mediator
    * Memento
    * State
    * Visitor
    * Interpreter

## High-Impact Patterns for Java Developer Interviews

* Here are Top 10 Patterns you should focus on with priority, use cases, and practical applications in
  backend/microservices architecture:

  | **Pattern**                 | **Category** | **Why Important**                                                 |
      | --------------------------- | ------------ | ----------------------------------------------------------------- |
  | **Singleton**               | Creational   | Commonly asked, used for config, cache manager, DB connections    |
  | **Factory Method**          | Creational   | Decouples object creation from usage, used in frameworks          |
  | **Builder**                 | Creational   | Complex object creation (e.g., DTOs, request objects)             |
  | **Observer**                | Behavioral   | Pub-sub model, event handling, Kafka consumers                    |
  | **Strategy**                | Behavioral   | Runtime behavior change, e.g., payment gateways                   |
  | **Template Method**         | Behavioral   | Defines algorithm skeleton, used in JDBC, servlets                |
  | **Decorator**               | Structural   | Adding functionality dynamically, e.g., Spring Security filters   |
  | **Proxy**                   | Structural   | AOP, logging, security (e.g., Spring Proxies)                     |
  | **Adapter**                 | Structural   | Compatibility between incompatible interfaces, legacy integration |
  | **Chain of Responsibility** | Behavioral   | Request processing chains like filters/interceptors               |
