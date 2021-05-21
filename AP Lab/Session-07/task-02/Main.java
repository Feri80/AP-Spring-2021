import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

/**
 * This class is the main class of the program that contains UI
 * 
 * @author Farhad Aman
 * @version 1.0
 */
public class Main
{
    /**
     * the number of created notes
     */
    public static int count = 0;

    /**
     * loads the number of created notes
     */
    public static void loadCount()
    {
        try(FileInputStream in = new FileInputStream("count.txt")) 
        {
            count = in.read() - 48;
        } 
        catch(Exception e) 
        {
            saveCount();
        }
    }

    /**
     * saves the number of created notes
     */
    public static void saveCount() 
    {
        try(FileOutputStream out = new FileOutputStream("count.txt")) 
        {
            out.write(count + 48);
        } 
        catch(Exception e) 
        {
            e.printStackTrace();
        }
    }

    /**
     * clears the consule screen
     */
    public static void clearScreen()
    {
        System.out.print("\033[H\033[2J");  
        System.out.flush();
    }
    
    public static void main(String[] args) 
    {
        loadCount();
        OutputNote writeNote = new OutputNote();
        InputNote readNote = new InputNote();
        DeleteNote deleteNote = new DeleteNote();
        int choose = 0;
        while(choose < 1 || choose > 4)
        {
            clearScreen();
            Scanner input = new Scanner(System.in);
            System.out.println("1.Create A New Note.\n2.Read Notes.\n3.Delete A Note.\n4.Exit");
            try 
            {
                choose = input.nextInt();    
            } 
            catch (Exception e) 
            {
                choose = 0;
                continue;
            }
            

            if(choose == 1)
            {
                writeNote.write();
                choose = 0;
            }
            else if(choose == 2)
            {
                readNote.read();
                choose = 0;
            }
            else if(choose == 3)
            {
                deleteNote.delete();
                choose = 0;
            }
            else if(choose == 4)
            {
                System.exit(0);
            }
            else
            {
                clearScreen();
                continue;
            }
        }

    } 
}