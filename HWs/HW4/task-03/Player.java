import java.util.ArrayList;

/**
 * this class contains a player an its details
 * 
 * @author Farhad Aman  
 * @version 1.0
 */
public class Player 
{
    /**
     * name of the player
     */
    private String name;

    /**
     * is the player a bot or human
     */
    private boolean isBot;

    /**
     * the card list of the player
     */
    private ArrayList<Card> cardsList;

    /**
     * creates a new player
     * @param name
     * @param isBot
     */
    public Player(String name,boolean isBot)
    {
        this.name = name;
        this.isBot = isBot;
        cardsList = new ArrayList<Card>();
    }

    /**
     * @return calculate a returns the total score of the player
     */
    public int getTotalScore()
    {
        int totalScore = 0;
        for(Card c : cardsList)
        {
            totalScore += c.getScore();
        }
        return totalScore;
    }

    /**
     * @return the card list of the player
     */
    public ArrayList<Card> getCardsList()
    {
        return cardsList;
    }

    /**
     * adds a new card to the card list
     * @param card
     */
    public void addCard(Card card)
    {
        cardsList.add(card);
    }

    /**
     * @return the isBot
     */
    public boolean getIsBot()
    {
        return isBot;
    }

    /**
     * @return the name of the player
     */
    public String getName()
    {
        return name;
    }

    /**
     * displays the card list of the player in a visual way
     */
    public void displayCards()
    {
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_BLACK = "\u001B[30m";
        final String ANSI_RED = "\u001B[31m";
        final String ANSI_GREEN = "\u001B[32m";
        final String ANSI_YELLOW = "\u001B[33m";
        final String ANSI_BLUE = "\u001B[34m";
        final String ANSI_PURPLE = "\u001B[35m";
        final String ANSI_CYAN = "\u001B[36m";
        final String ANSI_WHITE = "\u001B[37m";
        
        final String UPPER_LEFT = "\u250C";
        final String LOWER_LEFT = "\u2514";
        final String UPPER_RIGHT = "\u2510";
        final String LOWER_RIGHT = "\u2518";
        final String MIDDLE = "\u2500";
        
        final String UPPER_LEFT_FRAME = UPPER_LEFT + MIDDLE + MIDDLE + MIDDLE + MIDDLE;
        final String LOWER_LEFT_FRAME = LOWER_LEFT + MIDDLE + MIDDLE + MIDDLE + MIDDLE;
        final String UPPER_RIGHT_FRAME = MIDDLE + MIDDLE + MIDDLE + MIDDLE + UPPER_RIGHT;
        final String LOWER_RIGHT_FRAME = MIDDLE + MIDDLE + MIDDLE + MIDDLE + LOWER_RIGHT;

        final String LEFT_SPACE = "|    ";
        final String RIGHT_SPACE = "    |";

        int n = cardsList.size();

        System.out.println(ANSI_PURPLE + "\t" + name.toUpperCase());

        for(int i = 0; i < n; i++)
        {
            if(cardsList.get(i).getColor().equals("black"))
            {
                System.out.print(ANSI_RESET + UPPER_LEFT_FRAME);
            }
            if(cardsList.get(i).getColor().equals("red"))
            {
                System.out.print(ANSI_RED + UPPER_LEFT_FRAME);
            }
            if(cardsList.get(i).getColor().equals("green"))
            {
                System.out.print(ANSI_GREEN + UPPER_LEFT_FRAME);
            }
            if(cardsList.get(i).getColor().equals("blue"))
            {
                System.out.print(ANSI_BLUE + UPPER_LEFT_FRAME);
            }
            if(i == (n - 1))
            {
                System.out.println(UPPER_RIGHT_FRAME);
            }
        }

        for(int i = 0; i < 4; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(i == 0)
                {
                    if(cardsList.get(j).getColor().equals("black"))
                    {
                        System.out.print(ANSI_RESET + "| " + cardsList.get(j).getNumber() + "  ");
                    }
                    if(cardsList.get(j).getColor().equals("red"))
                    {
                        System.out.print(ANSI_RED + "| " + cardsList.get(j).getNumber() + "  ");
                    }
                    if(cardsList.get(j).getColor().equals("green"))
                    {
                        System.out.print(ANSI_GREEN + "| " + cardsList.get(j).getNumber() + "  ");
                    }
                    if(cardsList.get(j).getColor().equals("blue"))
                    {
                        System.out.print(ANSI_BLUE + "| " + cardsList.get(j).getNumber() + "  ");
                    }
                    if(j == (n - 1))
                    {
                        System.out.println(RIGHT_SPACE);
                    }
                }
                else
                {
                    if(cardsList.get(j).getColor().equals("black"))
                    {
                        System.out.print(ANSI_RESET + LEFT_SPACE);
                    }
                    if(cardsList.get(j).getColor().equals("red"))
                    {
                        System.out.print(ANSI_RED + LEFT_SPACE);
                    }
                    if(cardsList.get(j).getColor().equals("green"))
                    {
                        System.out.print(ANSI_GREEN + LEFT_SPACE);
                    }
                    if(cardsList.get(j).getColor().equals("blue"))
                    {
                        System.out.print(ANSI_BLUE + LEFT_SPACE);
                    }
                    if(j == (n - 1))
                    {
                        System.out.println(RIGHT_SPACE);
                    }
                }
            }
        }

        for(int i = 0; i < n; i++)
        {
            if(cardsList.get(i).getColor().equals("black"))
            {
                System.out.print(ANSI_RESET + LOWER_LEFT_FRAME);
            }
            if(cardsList.get(i).getColor().equals("red"))
            {
                System.out.print(ANSI_RED + LOWER_LEFT_FRAME);
            }
            if(cardsList.get(i).getColor().equals("green"))
            {
                System.out.print(ANSI_GREEN + LOWER_LEFT_FRAME);
            }
            if(cardsList.get(i).getColor().equals("blue"))
            {
                System.out.print(ANSI_BLUE + LOWER_LEFT_FRAME);
            }
            if(i == (n - 1))
            {
                System.out.println(LOWER_RIGHT_FRAME);
            }
        }

        System.out.print(" ");
        for(int i = 0; i < n; i++)
        {
            System.out.print(ANSI_RESET + "  " + i + "  ");
        }
        System.out.println();
    }
}
