import java.io.FileInputStream;
import java.util.Scanner;

/**
 * This class reads an existing note from notes
 * 
 * @author Farhad Aman
 * @version 1.0
 */
public class InputNote 
{
    /**
     * shows the first line of each note to choose
     */
    public void showFirstLine()
    {
        for(int i = 1; i <= Main.count; i++)
        {
            try(FileInputStream f = new FileInputStream("notes/note" + i + ".txt"); Scanner input = new Scanner(f)) 
            {
                System.out.println(i + " : " + input.nextLine());
            } 
            catch (Exception e) 
            {

            }
        }
    }

    /**
     * the main method that do the process of reading an existing note
     */
    public void read()
    {
        Main.clearScreen();
        if(Main.count == 0)
        {
            System.out.println("There Is Not Any Note");
            try 
            {
                Thread.sleep(3000);
            } 
            catch(InterruptedException e) 
            {
                e.printStackTrace();
            }
            return;
        }
        showFirstLine();
        Scanner chooseNote = new Scanner(System.in);
        int choose = 0;
        while(choose < 1 || choose > Main.count)
        {
            System.out.print("Choose Your Note To See : ");
            choose = chooseNote.nextInt();
        }
        Main.clearScreen();
        try(FileInputStream in = new FileInputStream("notes/note" + choose + ".txt")) 
        {
            int buf;
            while((buf = in.read()) != -1)
            {
                System.out.print((char)buf);
            }
        } 
        catch (Exception e) 
        {
            read();
        }
        try 
        {
            Thread.sleep(10000);    
        }
        catch(Exception e) 
        {
            e.printStackTrace();
        }
    }
}
