/**
 * this class contains a card and its details
 * 
 * @author Farhad Aman
 * @version 1.0
 */
public abstract class Card
{
    /**
     * the score of the card
     */
    protected int score;

    /**
     * the number of the card
     */
    protected String number;

    /**
     * the color of the card
     */
    protected String color;

    /**
     * @return score of the card
     */
    public int getScore()
    {
        return score;
    }

    /**
     * @return the number of the card
     */
    public String getNumber()
    {
        return number;
    }

    /**
     * @return the color of the card
     */
    public String getColor()
    {
        return color;
    }

    @Override
    public String toString() 
    {
        String s = "";

        if(color.equals("black"))
        {
            s = UI.ANSI_RESET;
        }
        else if(color.equals("red"))
        {
            s = UI.ANSI_RED;
               
        }
        else if(color.equals("green"))
        {
            s = UI.ANSI_GREEN;
        }
        else if(color.equals("blue"))
        {
            s = UI.ANSI_BLUE;
        }

        s += UI.UPPER_LEFT_FRAME + 
             UI.UPPER_RIGHT_FRAME + 
             "\n| " + 
             number + 
             "  " + 
             UI.RIGHT_SPACE + 
             "\n" + 
             UI.LEFT_SPACE + 
             UI.RIGHT_SPACE + 
             "\n" + 
             UI.LEFT_SPACE + 
             UI.RIGHT_SPACE + 
             "\n" + 
             UI.LEFT_SPACE + 
             UI.RIGHT_SPACE + 
             "\n" + 
             UI.LOWER_LEFT_FRAME + 
             UI.LOWER_RIGHT_FRAME +
             UI.ANSI_RESET;
             
        return s;
    }


}
