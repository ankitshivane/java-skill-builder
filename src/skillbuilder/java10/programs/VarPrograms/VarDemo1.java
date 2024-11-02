package skillbuilder.java10.programs.VarPrograms;

public class VarDemo1 {
    public static void main(String[] args) {
        // CASE: 1 declaring variables
        var i = 230;
        System.out.println(i);

        // CASE: 2 using inside loops
        for (var k = 1; k <= 10; k++) {
            System.out.print(k + " ");
        }

        // old way of declaring arrays
        int[] arr = new int[]{12, 2, 1, 2, 2, 1};

        //Java 10 var approach for declaring arrays
        var arr2 = new int[]{2, 3, 22, 2, 1};
    }
}
