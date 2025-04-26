package skillbuilder.java12.programs;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class MismatchFeatureDemo {
    public static void main(String[] args) throws IOException {
        mismatchDemoFileIdentical();
        mismatchDemoFileDiff();
    }

    private static void mismatchDemoFileIdentical() throws IOException {
        Path file1 = Files.createTempFile("file1", ".txt");
        Path file2 = Files.createTempFile("file2", ".txt");
        Files.writeString(file1, "Ankit is smart");
        Files.writeString(file2, "Ankit is smart");
        long mismatch = Files.mismatch(file1, file2);
        if (mismatch == -1L)
            System.out.println("Both File Content are same");
        else
            System.out.println("Not Identical...");
        /*
        OUTPUT:
        Both File Content are same
         */
    }

    private static void mismatchDemoFileDiff() throws IOException {
        Path file1 = Files.createTempFile("file1", ".txt");
        Path file2 = Files.createTempFile("file2", ".txt");
        Files.writeString(file1, "Ankit is smart");
        Files.writeString(file2, "Ankit is learning java");
        long mismatch = Files.mismatch(file1, file2);
        if (mismatch == -1L)
            System.out.println("Both File Content are same");
        else
            System.out.println("Not Identical...position of mismatch is:" + mismatch);
    /*
    OUTPUT:
    Not Identical...position of mismatch is:9
     */
    }
}