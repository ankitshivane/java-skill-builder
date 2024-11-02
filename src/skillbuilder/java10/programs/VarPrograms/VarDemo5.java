package skillbuilder.java10.programs.VarPrograms;

import java.io.File;
import java.io.PrintWriter;

public class VarDemo5 {
    public static void main(String[] args) {
        //CASE: 1 var can be used with try-with-resources
        try (var writer = new PrintWriter(new File("output2.txt"))) {
            writer.write("welcome to Java10 features");
            System.out.println("Content written successfully...");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
