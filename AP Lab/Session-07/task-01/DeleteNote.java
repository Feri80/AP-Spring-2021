import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

/**
 * This class deletes an existing note from notes
 */
public class DeleteNote 
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
     * the main method that do the process of deleting an existing note
     */
    public void delete()
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
        File note = new File("notes/note" + choose + ".txt");
        if(note.delete())
        {
            System.out.println("Successfully Deleted.");
        }
        else
        {
            System.out.println("Failed To Delete");
        }
        try 
        {
            Thread.sleep(3000);    
        }
        catch(Exception e) 
        {
            e.printStackTrace();
        }
    }
}
