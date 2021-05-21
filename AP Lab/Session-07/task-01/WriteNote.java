import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * This class creates a new note and save that as a txt file
 * 
 * @author Farhad Aman
 * @version 1.0
 */
public class WriteNote 
{
    /**
     * FileWriter for writing file
     */
    private FileWriter out;
    /**
     * bufferedWriter for writing file
     */
    private BufferedWriter writer;

    public WriteNote()
    {
        out = null;
        writer = null;
    }

    /**
     * the main method that do the process of making a new note 
     */
    public void write()
    {
        Main.clearScreen();
        try
        {
            out = new FileWriter("notes/note" + (Main.count + 1) + ".txt");
            writer = new BufferedWriter(out);
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        Scanner input = new Scanner(System.in);
        while(input.hasNext())
        {
            try 
            {
                writer.write(input.nextLine());
                writer.write("\n");
                writer.flush();
            } 
            catch (IOException e) 
            {
                e.printStackTrace();
            }
        }
        try 
        {
            writer.close();
            out.close();
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
        Main.count++;
        Main.saveCount();
    }
}
