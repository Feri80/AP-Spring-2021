import java.util.Scanner;

/**
 * This class is the main class of the program and contains UI
 * 
 * @author Farhad Aman
 * @version 1.0
 */
public class Main
{
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
        Notepad notepad = new Notepad();
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
                notepad.addNote();
                choose = 0;
            }
            else if(choose == 2)
            {
                notepad.showNote();
                choose = 0;
            }
            else if(choose == 3)
            {
                notepad.deleteNote();
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