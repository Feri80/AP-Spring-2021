import java.util.ArrayList;

/**
 * This class contains a polygon details
 * 
 * @author Farhad Aman 
 * @version 1.0
 */
public abstract class Polygon extends Shape
{
    /**
     * the list of polygon sides
     */
    protected ArrayList<Integer> sides;

    /**
     * creates a new polygon with given sides
     * @param args
     */
    public Polygon(int... args)
    {
        sides = new ArrayList<Integer>();
        for(int i : args)
        {
            sides.add((Integer)i);
        }
    }

    /**
     * returns the list of polygon sides
     * @return sides
     */
    public ArrayList<Integer> getSides()
    {
        return sides;
    }

    @Override
    public String toString()
    {
        String s = "Sides : ";
        for(int i : sides)
        {
            s += i + " ";
        }
        s += "\n";
        return s;
    }
}