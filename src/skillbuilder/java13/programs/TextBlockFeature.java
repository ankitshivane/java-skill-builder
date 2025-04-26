package skillbuilder.java13.programs;

public class TextBlockFeature {
    public static void main(String[] args) {
        beforeJava13();
        textBlockDemo();
    }

    private static void beforeJava13() {
        System.out.println("-----------Before JAVA 13 Release--------------");
        String val = "This is demo for showing\n newline in java\n which will break the code in \n multiple lines";
        System.out.println(val);
    }

    private static void textBlockDemo() {
        System.out.println("-----------After JAVA 13 Release--------------");
        String val = """
                This is demo for showing
                 newline in java
                 which will break the code in
                 multiple lines]]]]
                """;
        System.out.println(val);

        System.out.println("-------- Comparing strings -----------");
        String txtBlck1 = """
                this is java 13 text block feature""";
        String normalStr = "this is java 13 text block feature";
        System.out.println("Text block string::" + txtBlck1);
        System.out.println("Normal block string::" + normalStr);
        System.out.println(txtBlck1.equals(normalStr));
        System.out.println(txtBlck1 == normalStr);

        System.out.println("-------- Concat text block and normal string --------");
        String txtBlck2 = """
                this is java 13 text block feature""";
        String normalStr2 = "this is java 13 text block feature";
        String concat = txtBlck2.concat(normalStr);
        String concResult2 = txtBlck2 + normalStr2;
        System.out.println("Concat Result::" + concat);
        System.out.println("Concat Result::" + concResult2);

        passingMethAsParam(txtBlck2);
    }

    private static void passingMethAsParam(String str) {
        String s1 = str;
        System.out.println(s1);
    }
/*
OUTPUT:

-----------Before JAVA 13 Release--------------
This is demo for showing
 newline in java
 which will break the code in
 multiple lines
-----------After JAVA 13 Release--------------
This is demo for showing
 newline in java
 which will break the code in
 multiple lines]]]]

-------- Comparing strings -----------
Text block string::this is java 13 text block feature
Normal block string::this is java 13 text block feature
true
true
-------- Concat text block and normal string --------
Concat Result::this is java 13 text block featurethis is java 13 text block feature
Concat Result::this is java 13 text block featurethis is java 13 text block feature
this is java 13 text block feature
 */

}
