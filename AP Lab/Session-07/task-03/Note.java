import java.io.Serializable;
import java.util.Date;

/**
 * This class contains a note and its details
 * 
 * @author Farhad Aman
 * @version 1.0
 */
public class Note implements Serializable
{
    /**
     * the title of the note
     */
    private String title;
    
    /**
     * the date of note creation 
     */
    private Date date;

    /**
     * the text of the note
     */
    private String text;

    public Note(String title, String text)
    {
        this.title = title;
        this.text = text;
        date = new Date();
    }

    /**
     * @return the title of the note
     */
    public String getTitle()
    {
        return title;
    }

    /**
     * @return the date of note creation
     */
    public Date getDate()
    {
        return date;
    }

    /**
     * @return the text of the note
     */
    public String getText()
    {
        return text;
    }

    /**
     * prints the first line of the note
     */
    public void printFirstLine()
    {
        System.out.println("Title : " + title + "    Date : " + date + "\n" + text.split("\n")[0]);
    }

    @Override
    public String toString() 
    {
        return "Title : " + 
               title + 
               "\tDate : " + 
               date + 
               "\n-----------------------------------------------\n" + 
               text + 
               "\n-----------------------------------------------\n";   
    }
}
