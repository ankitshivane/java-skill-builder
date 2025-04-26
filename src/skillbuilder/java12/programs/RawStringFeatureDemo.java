package skillbuilder.java12.programs;

public class RawStringFeatureDemo {
    public static void main(String[] args) {
        System.out.println("-------------------Before Java 12-------------------");
        String html = "<html>\n" +
                " <body>\n" +
                " <p>Hello World.</p>\n" +
                " </body>\n" +
                "</html >\n ";
        System.out.println(html);
        System.out.println("-------------------After Java 12-------------------");
        /*String html = `<html>
                <body>
                <p>Hello World.</p>
                </body>
                </html>
              `;*/
    }
}
