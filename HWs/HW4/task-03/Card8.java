/**
 * this class contains a card with number 8 and its details
 */
public class Card8 extends Card implements Actionable
{
    /**
     * creates a new Card8
     * @param color
     */
    public Card8(String color)
    {
        this.color = color;
        this.number = "8";
        this.score = 8;
    }

    /**
     * the player should play again
     * @param game
     */
    @Override
    public void action(Game game) 
    {
        game.turnStepBackward();
        System.out.println("This Card Has Another Gift Turn.");
    }
}
