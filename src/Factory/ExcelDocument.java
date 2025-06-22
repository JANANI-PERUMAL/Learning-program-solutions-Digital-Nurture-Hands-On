package Factory;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ExcelDocument implements Document {
    @Override
    public void open() {
        try {
            File file = new File("ExcelDocument.xlsx");
            FileWriter writer = new FileWriter(file);
            writer.write("This is an Excel document.");
            writer.close();
            System.out.println("Excel document created at: " + file.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Error creating Excel document: " + e.getMessage());
        }
    }
}
