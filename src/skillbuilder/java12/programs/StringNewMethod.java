package skillbuilder.java12.programs;

public class StringNewMethod {
    public static void main(String[] args) {
        indent();
//        transformDemo();
    }

    private static void indent() {
        // CASE:1
        String text = "Hello Ankit!\nThis is Java 12 article.";
        System.out.println(text);
        // It will add 5 spaces at the starting of each line
        String indent = text.indent(5);
        System.out.println(indent);
        System.out.println("--------------------------------------------------");

        // CASE:2
        String text2 = "\t\tHello Ankit!            @    \n\tThis is Java 12 article. \t  @@      ";
        System.out.println(text2);
        String trailingIndent = text2.indent(-1);
        System.out.println(trailingIndent);
        /*
        OUTPUT:
Hello Ankit!
This is Java 12 article.
     Hello Ankit!
     This is Java 12 article.

--------------------------------------------------
		Hello Ankit!            @
	This is Java 12 article. 	  @@
	Hello Ankit!            @
This is Java 12 article. 	  @@
         */
    }

    private static void transformDemo() {
        String str = "Ankit is genius...";
        String transform = str.transform(i -> i.toUpperCase());
        System.out.println("Output:" + transform);
        /*
        Output:ANKIT IS GENIUS...
         */
    }
}
