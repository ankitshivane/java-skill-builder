package skillbuilder.core.equalsAndHashCode.hashCode;

import java.util.Objects;

public class Test1 {
    int i;

    Test1(int i) {
        this.i = i;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Test1 test1 = (Test1) o;
//        return i.equals(test1.i);
        return i == test1.i;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(i);
    }

    public static void main(String[] args) {
        Test1 t1 = new Test1(10);
        Test1 t2 = new Test1(20);
        System.out.println(t1.hashCode()); // 10
        System.out.println(t2.hashCode()); // 20
        System.out.println(t1.hashCode() == t2.hashCode()); // false
        System.out.println(t1.equals(t2)); // false

        Test1 t3 = new Test1(10);
        System.out.println(t3.hashCode()); // 10
        System.out.println(t3.hashCode() == t1.hashCode()); // true
        System.out.println(t3.equals(t1)); // true

        /** OUTPUT
         10
         20
         false
         false
         10
         true
         true
         */
    }
}
