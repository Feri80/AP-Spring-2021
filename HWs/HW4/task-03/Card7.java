import java.util.ArrayList;

/**
 * this class contains a card with number 7
 * 
 * @author Farhad Aman
 * @version 1.0
 */
public class Card7 extends Card implements Actionable
{
    /**
     * the penalty card
     */
    private ArrayList<Card> penaltyCards;

    /**
     * create a new Card7
     * @param color
     */
    public Card7(String color)
    {
        penaltyCards = new ArrayList<Card>();
        this.color = color;
        this.number = "7";
        if(color == "black")
        {
            this.score = 15;
        }
        else
        {
            this.score = 10;
        }
    }

    /**
     * @return the list of penalty cards
     */
    public ArrayList<Card> getPenaltyCards()
    {
        return penaltyCards;
    }

    /**
     * give some penalty card to the next player
     * @param game
     */
    @Override
    public void action(Game game) 
    {
        if(color.equals("black"))
        {
            for(int i = 0; i < 4; i++)
            {
                penaltyCards.add(game.getStorage().get(game.getStorage().size() - 1));
                game.getStorage().remove(game.getStorage().size() - 1);
            }
            System.out.println("This Card Has 4 Penalty Card For Next Player");
        }
        else
        {
            for(int i = 0; i < 2; i++)
            {
                penaltyCards.add(game.getStorage().get(game.getStorage().size() - 1));
                game.getStorage().remove(game.getStorage().size() - 1);
            }
            System.out.println("This Card Has 2 Penalty Card For Next Player");
        }

    }
}
