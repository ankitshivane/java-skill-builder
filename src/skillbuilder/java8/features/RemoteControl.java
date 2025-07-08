package skillbuilder.java8.features;

public interface RemoteControl {
    default void voiceCommand(String command) {
        if (!command.equals("turn on light")) {
            System.out.println("Unknown voice command::" + command);
            return;
        }
        System.out.println(command);
    }

    int x = 23;

    default void method1() {
        this.method2();
        RemoteControl.method3();
        System.out.println("value " + x);
    }

    default void method2() {
        System.out.println("Interface default method2");
    }

    static void method3() {
        System.out.println("Interface static method3");
    }
    /*default int hashCode() {
        return 23;
    }

    default String toString() {
        return "obj";
    }*/
}
