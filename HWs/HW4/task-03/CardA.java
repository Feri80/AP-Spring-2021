/**
 * this class contains a card with number A and its details
 * 
 * @author Farhad Aman
 * @version 1.0
 */
public class CardA extends Card implements Actionable
{
    /**
     * creates a new CardA
     * @param color
     */
    public CardA(String color)
    {
        this.color = color;
        this.number = "A";
        this.score = 11;
    }

    /**
     * next player cant play
     * @param game
     */
    @Override
    public void action(Game game) 
    {
        game.turnStepForward();
        System.out.println("Next Players Cant Play.");
    }
}
