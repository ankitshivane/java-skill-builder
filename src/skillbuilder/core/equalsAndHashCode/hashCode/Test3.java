package skillbuilder.core.equalsAndHashCode.hashCode;

import skillbuilder.java11.programs.NewStringUtilityMeth.StripDemo;

import java.util.Objects;

public class Test3 {
    int i;

    Test3(int i) {
        this.i = i;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Test3 test3 = (Test3) o;
        return i == test3.i;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(i);
    }

    public static void main(String[] args) {
        Test3 t1 = new Test3(10);
        Test3 t2 = new Test3(10);
        System.out.println(t1.hashCode()); // 10
        System.out.println(t2.hashCode()); // 10
        System.out.println(t1 == t2); //false
    }
}
