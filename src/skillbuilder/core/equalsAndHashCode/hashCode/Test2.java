package skillbuilder.core.equalsAndHashCode.hashCode;

import java.util.Objects;

public class Test2 {
    int i;

    Test2(int i) {
        this.i = i;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Test2 Test2 = (Test2) o;
//        return i.equals(Test2.i);
        return i == Test2.i;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(i);
    }

    public static void main(String[] args) {
        Test2 t1 = new Test2(10);
//        Test2 t2 = new Test2(10);
        Test2 t2=t1;
        System.out.println(t1.hashCode()); // 10
        System.out.println(t2.hashCode()); // 10
        System.out.println(t1 == t2); //true
    }
}
