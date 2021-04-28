/**
 * this class contains a card with number 10 and its details
 */
public class Card10 extends Card implements Actionable
{
    /**
     * creates a new Card10
     * @param color
     */
    public Card10(String color)
    {
        this.color = color;
        this.number = "\u2469";
        this.score = 10;
    }

    /**
     * changes the direction of the game
     * @param game
     */
    @Override
    public void action(Game game) 
    {
        game.changeDirection();
        System.out.println("This Card Changes The Direction Of The Game.");
    }
}
