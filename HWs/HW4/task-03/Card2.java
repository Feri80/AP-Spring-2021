import java.util.Random;
import java.util.Scanner;

/**
 * this class contains a card with number 2
 * 
 * @author Farhad Aman
 * @version 1.0
 */
public class Card2 extends Card implements Actionable
{
    /**
     * creates a new Card2
     * @param color
     */
    public Card2(String color)
    {
        this.color = color;
        this.number = "2";
        this.score = 2;
    }

    /**
     * give a card from owner to the desired player
     * @param game
     */
    @Override
    public void action(Game game) 
    {
        Player p = game.getPlayers().get(game.getCurrentPlayer());
        Random random = new Random();

        Card chosenCard = p.getCardsList().get(random.nextInt(p.getCardsList().size()));

        Player chosenPlayer = null;

        System.out.println("This Card Has One Penalty Card For Chosen Player.");

        if(p.getIsBot())
        {
            while(chosenPlayer == p || chosenPlayer == null)
            {
                chosenPlayer = game.getPlayers().get(random.nextInt(game.getPlayers().size()));
            }
        }
        else
        {
            Scanner input = new Scanner(System.in);
            int k = -1;
            while(k < 0 || k >= game.getPlayers().size() || game.getPlayers().indexOf(p) == k)
            {
                System.out.println("Please Enter The Nubmer Of Your Chosen Player To Give Card: ");
                k = input.nextInt();
            }
            chosenPlayer = game.getPlayers().get(k);
        }

        p.getCardsList().remove(chosenCard);
        chosenPlayer.getCardsList().add(chosenCard);
    }
}
