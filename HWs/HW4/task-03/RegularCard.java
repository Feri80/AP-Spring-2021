/**
 * this class contains a non actionable card
 * 
 * @author Farhad Aman  
 * @version 1.0
 */
public class RegularCard extends Card
{
    /**
     * creates a new regularCard
     * @param score
     * @param number
     * @param color
     */
    public RegularCard(int score, String number, String color)
    {
        this.score = score;
        this.number = number;
        this.color = color;
    }
}
