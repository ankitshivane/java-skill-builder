package skillbuilder.designPatterns.creational.singleton.cloningBreak;

public class Demo1 {
    public static void main(String[] args) throws CloneNotSupportedException {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = (Singleton) s1.clone();

        System.out.println(s1 == s2); // false --> Two different instances!, ⚠️ This breaks the Singleton pattern!


    }
}
