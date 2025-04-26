package skillbuilder.java13.programs;

public class NewTextBlockMethods {
    public static void main(String[] args) {
        String TEXT_BLOCK_JSON = """
                {
                    "name" : "Java",
                    "website" : "https://www.%s.com?age=%d?salary=%f/"
                }
                """;
        formattedMethodDemo(TEXT_BLOCK_JSON);
//        stripIndentDemo(TEXT_BLOCK_JSON);
//        translateEscapes();
    }

    private static void formattedMethodDemo(String TEXT_BLOCK_JSON) {
        System.out.println("Before using formatted string on text block");
        System.out.println(TEXT_BLOCK_JSON);
        System.out.println("After using formatted method on text block");
        // here we formatted and replaced %s with the java_tutorial value, and so on. it is similar to normal String format() method but only for text block feature
        String formatted = TEXT_BLOCK_JSON.formatted("java_tutorial", 28, 200000.12);
        System.out.println(formatted);
        /*
        OUTPUT:

Before using formatted string on text block
{
    "name" : "Java",
    "website" : "https://www.%s.com?age=%d?salary=%f/"
}

After using formatted method on text block
{
    "name" : "Java",
    "website" : "https://www.java_tutorial.com?age=28?salary=200000.120000/"
}
         */
    }

    private static void stripIndentDemo(String textBlockStr) {
        System.out.println("-----------Before stripIndent text block containing spaces at the beginning------------");
        String data1 = """
                \t\t           This is Java 13 Text block \t\t""";
        String data2 = "\t\tfeature\t\t";
        System.out.println(data1);
        System.out.println(data2);
        System.out.println("-----------After stripIndent------------");
        System.out.println(data1.stripIndent() + data2.stripIndent());
        /*
        OUTPUT:
-----------Before stripIndent text block containing spaces at the beginning------------
		           This is Java 13 Text block
		feature
-----------After stripIndent------------
This is Java 13 Text blockfeature
         */
    }

    private static void translateEscapes() {
        String str1 = "Durga\nSoftware\nSolutions";
        String str2 = "Durga\\nSoftware\\nSolutions";
        System.out.println(str1);
        System.out.println();
        System.out.println(str2);
        System.out.println();
        System.out.println(str2.translateEscapes());
        /*
        as you can see in the output post the translateEscapes() remove the extra backslash or escape character it was now able to parse those \n
        OUTPUT:
Durga
Software
Solutions

Durga\nSoftware\nSolutions

Durga
Software
Solutions
         */
    }
}
