package Factory;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WordDocument implements Document
{
    @Override
    public void open()
    {
        try 
        {
            File file = new File("WordDocument.docx");
            FileWriter writer = new FileWriter(file);
            writer.write("This is a Word document.");
            writer.close();
            System.out.println("Word document created at: " + file.getAbsolutePath());
        }
        catch (IOException e) 
        {
            System.out.println("Error creating Word document: " + e.getMessage());
        }
    }
}
