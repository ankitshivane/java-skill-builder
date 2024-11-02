package skillbuilder.java10.programs.VarPrograms;

public class VarDemo3 {
    public static void main(String[] args) {
//        var k=null;  // var type variable declaration is not allowed with null
//        var i;        // var type variable declaration has to be done with initialization without initialization it will give compilation error
        var j = 23;
        var n = m1();
    }

    /*
    // var as method return type is not allowed
    public var m2(){
        return 23;
    }
     */

    public static int m1() {
        return 2;
    }
}
