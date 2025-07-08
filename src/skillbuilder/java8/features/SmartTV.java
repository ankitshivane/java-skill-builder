package skillbuilder.java8.features;

public class SmartTV implements RemoteControl {
    String name = "samsung";

    @Override
    public void voiceCommand(String command) {
        RemoteControl.super.method1();
        System.out.println(name);
    }
    public void test(){
        RemoteControl.super.method1();
    }
    public static void test1(){

    }
}
