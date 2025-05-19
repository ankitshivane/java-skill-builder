package skillbuilder.designPatterns.creational.singleton.BillPugh;

public class BillPughSingletonClass {
    private BillPughSingletonClass() {

    }

    private static class MyStaticInnerCls {
        private static final BillPughSingletonClass INSTANCE = new BillPughSingletonClass();
    }

    public static BillPughSingletonClass getInstance() {
        return MyStaticInnerCls.INSTANCE;
    }
}
