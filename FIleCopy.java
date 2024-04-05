import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.IOException;

public class FIleCopy {

    public static void main(String[] args) {
        String sourceFile = "source.text";
        String destinationFile = "output.text";

        try {
            copyTextFile(sourceFile, destinationFile);
            System.out.println("File copied successfully! ^_^");
        } catch (IOException e) {
            System.out.println("File copied unsuccessfully! :(");
            e.printStackTrace();
        }
    }

    private static void copyTextFile(String source, String destination) throws IOException {
        File inputFile = new File(source);

        if (!inputFile.exists()) {
            throw new FileNotFoundException("Source file not found: " + source);
        }

        File outputFile = new File(destination);

        try (Scanner sc = new Scanner(inputFile);
             FileWriter writer = new FileWriter(outputFile)) {

            while (sc.hasNextLine()) {
                writer.write(sc.nextLine() + System.lineSeparator());
            }
        }
    }
}