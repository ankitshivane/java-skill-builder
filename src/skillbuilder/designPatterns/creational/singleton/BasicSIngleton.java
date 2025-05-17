package skillbuilder.designPatterns.creational.singleton;

public class BasicSIngleton {
    public static void main(String[] args) {
        MySingletonDemo instance = MySingletonDemo.getInstance();
    }
}

class MySingletonDemo {
    // declare a static member of the same class type in the class
    private static MySingletonDemo instance;

    // Constructor declared as private
    private MySingletonDemo() {

    }

    // declare a static method to create only one instance (static factory method)
    public static MySingletonDemo getInstance() {
        if (instance == null) {
            instance = new MySingletonDemo();
        }
        return instance;
    }
}
