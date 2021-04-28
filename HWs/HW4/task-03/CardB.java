import java.util.Random;
import java.util.Scanner;

/**
 * this class contains a card with number B
 * 
 * @author Farhad Aman
 * @version 1.0
 */
public class CardB extends Card implements Actionable
{
    /**
     * creates a new CardB
     * @param color
     */
    public CardB(String color)
    {
        this.color = color;
        this.number = "B";
        this.score = 12;
    }

    /**
     * the player can choose the next color of the game
     * @param game
     */
    @Override
    public void action(Game game) 
    {
        String chosenColor = "-1";

        System.out.println("This Card Can Change The Color Of The Game.");

        if(game.getPlayers().get(game.getCurrentPlayer()).getIsBot())
        {
            Random random = new Random();
            int r = random.nextInt(4);
            if(r == 0)
            {
                chosenColor = "black";
            }
            else if(r == 1)
            {
                chosenColor = "blue";
            }
            else if(r == 2)
            {
                chosenColor = "red";
            }
            else if (r == 3)
            {
                chosenColor = "green";
            }
        }   
        else
        {
            Scanner input = new Scanner(System.in);
            while(!(chosenColor.equals("black") || chosenColor.equals("blue") || chosenColor.equals("red") || chosenColor.equals("green")))
            {
                System.out.println("Please Enter Next Color :");
                chosenColor = input.nextLine();
            }
        }
        game.setCurrentColor(chosenColor);
    }
}
