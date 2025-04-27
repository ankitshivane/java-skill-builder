package skillbuilder.indepth.sealed_classes;

public class SealedClsDemo2 {
    public static void main(String[] args) {

    }
}

// Inheritance guidelines rule
sealed class X permits Y {

}

sealed class Y extends X permits Z {

}

// here we can only extend Y not X if we try to extend X then we will get compile time error.
final class Z extends Y {

}

