package skillbuilder.java9.programs.tryWithResources;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Demo {
    public static void main(String[] args) throws FileNotFoundException {
        FileOutputStream fos = new FileOutputStream("output.txt");
        try (fos) {
            fos.write("Hello World...".getBytes());
            System.out.println("content written successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
