import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class contains the notepad and its details
 * 
 * @author Farhad Amana
 * @version 1.0
 */
public class Notepad 
{
    /**
     * the list of the notes
     */
    private ArrayList<Note> notes;

    /**
     * the number of existing notes
     */
    private int notesCount;

    public Notepad()
    {
        notes = new ArrayList<Note>();
        notesCount = 0;
        loadNotes();
    }

    /**
     * loads the list of notes from the notes.bin file
     */
    public void loadNotes()
    {
        if(!(new File("notes.bin").exists()))
        {
            saveNotes();
            return;
        }

        try(FileInputStream in = new FileInputStream("notes.bin"); ObjectInputStream reader = new ObjectInputStream(in)) 
        {
            while(true)
            {
                notes.add((Note)reader.readObject());
                notesCount++;
            }
        } 
        catch(EOFException e)
        {
            System.out.println("EOF");
        }
        catch(Exception e) 
        {
            System.out.println("EOF");
        }
    }

    /**
     * saves the list of notes in notes.bin file
     */
    public void saveNotes()
    {
        File f = new File("notes.bin");
        if(f.exists())
        {
            f.delete();
        }

        try(FileOutputStream out = new FileOutputStream("notes.bin"); ObjectOutputStream writer = new ObjectOutputStream(out)) 
        {
            for(Note n : notes)
            {
                writer.writeObject(n);
            }
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }

    /**
     * shows the first line of each note to choose
     */
    public void showFirstLines()
    {
        int i = 1;
        for(Note note : notes)
        {
            System.out.print(i + " ");
            note.printFirstLine();
            System.out.println();
            i++;
        }
    }

    /**
     * adds a new note to the list with given information
     */
    public void addNote()
    {
        Main.clearScreen();
        Scanner input = new Scanner(System.in);
        System.out.print("Please Enter The Title Of Your Note : ");
        String title = input.nextLine();
        System.out.println("Please Enter The Text Of Yout Note :");
        String text = "";
        while(input.hasNext())
        {
            text += input.nextLine();
            text += "\n";
        }
        notes.add(new Note(title, text));
        saveNotes();
        notesCount++;
        System.out.println("Your Text Succesfully Saved.");
        try 
        {
            Thread.sleep(3000);
        } 
        catch(InterruptedException e) 
        {
            e.printStackTrace();
        }
    }

    /**
     * show a note from the list of notes
     */
    public void showNote()
    {
        Main.clearScreen();
        if(notesCount == 0)
        {
            System.out.println("There Is Not Any Note.");
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
        showFirstLines();
        Scanner chooseNote = new Scanner(System.in);
        int choose = 0;
        while(choose < 1 || choose > notesCount)
        {
            System.out.print("Choose Your Note To See : ");
            choose = chooseNote.nextInt();
        }
        Main.clearScreen();
        System.out.println(notes.get(choose - 1));        
        try 
        {
            Thread.sleep(10000);    
        } 
        catch(Exception e) 
        {
            e.printStackTrace();
        }
        Main.clearScreen();
    }

    /**
     * deletes a note from the list of notes
     */
    public void deleteNote()
    {
        Main.clearScreen();
        if(notesCount == 0)
        {
            System.out.println("There Is Not Any Note.");
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
        showFirstLines();
        Scanner chooseNote = new Scanner(System.in);
        int choose = 0;
        while(choose < 1 || choose > notesCount)
        {
            System.out.print("Choose Your Note To See : ");
            choose = chooseNote.nextInt();
        }
        Main.clearScreen();
        notes.remove(choose - 1);
        saveNotes();
        notesCount--;
        System.out.println("Your Text Succesfully Deleted.");
        try 
        {
            Thread.sleep(3000);
        } 
        catch(InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
