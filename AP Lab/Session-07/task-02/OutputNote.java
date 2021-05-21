import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * This class writes a new note
 * 
 * @author Farhad Aman
 * @version 1.0
 */
public class OutputNote 
{
    /**
     * FileOutputStream to write note
     */
    private FileOutputStream out;

    public OutputNote()
    {
        out = null;
    }

    /**
     * the main method that do process of writing a new note
     */
    public void write()
    {
        Main.clearScreen();
        try
        {
            out = new FileOutputStream("notes/note" + (Main.count + 1) + ".txt");
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
                String s = input.nextLine();
                for(char c : s.toCharArray())
                {
                    out.write(c);
                }
                out.write('\n');
            } 
            catch (IOException e) 
            {
                e.printStackTrace();
            }
        }
        try 
        {
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
