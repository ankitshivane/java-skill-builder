package skillbuilder.java8.features.practice;

@FunctionalInterface
public interface InterfPtac {

    void m1(int i);
    default void justPrint(){
        System.out.println("just print");
    }
}
