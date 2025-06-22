package Factory;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class PdfDocument implements Document {
    @Override
    public void open() {
        try {
            File file = new File("PdfDocument.pdf");
            FileWriter writer = new FileWriter(file);
            writer.write("This is a PDF document.");
            writer.close();
            System.out.println("PDF document created at: " + file.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Error creating PDF document: " + e.getMessage());
        }
    }
}
