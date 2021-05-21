import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

/**
 * This class can read existing notes 
 * 
 * @author Farhad Aman
 * @version 1.0
 */
public class ReadNote 
{
    /**
     * shows the first line of each note to choose
     */
    public void showFirstLine()
    {
        for(int i = 1; i <= Main.count; i++)
        {
            try(FileReader f = new FileReader("notes/note" + i + ".txt"); Scanner input = new Scanner(f)) 
            {
                System.out.println(i + " : " + input.nextLine());
            } 
            catch (Exception e) 
            {

            }
        }
    }

    /**
     * the main method that do the process of read an existing note
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
        try(FileReader in = new FileReader("notes/note" + choose + ".txt"); BufferedReader input = new BufferedReader(in)) 
        {
            int buf;
            while((buf = input.read()) != -1)
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
