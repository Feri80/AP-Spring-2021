/**
 * This class contains the rectangle shape details
 * 
 * @author Farhad Aman  
 * @version 1.0
 */
public class Rectangle extends Polygon
{
    /**
     * creates a new rectangle with given sides
     * @param side1
     * @param side2
     * @param side3
     * @param side4
     */
    public Rectangle(int side1, int side2, int side3, int side4)
    {
        super(side1, side2, side3, side4);
    }

    /**
     * checks if the rectangle is square
     */
    public boolean isSquare()
    {
        if(sides.get(0) == sides.get(1) && sides.get(2) == sides.get(3) && sides.get(1) == sides.get(2))
        {
            return true;
        } 
        return false;
    }

    /**
     * returns the perimeter of the rectangle
     * @return perimeter
     */
    @Override
    public double calculatePerimeter()
    {
        return sides.get(0) + sides.get(1) + sides.get(2) + sides.get(3);
    }

    /**
     * returns the area of the rectangle
     * @return area
     */
    @Override
    public double calculateArea()
    {
        if(isSquare() == true)
        {
            return sides.get(0) * sides.get(0);
        }
        else
        {
            if(sides.get(0) != sides.get(1))
            {
                return sides.get(0) * sides.get(1);
            }
            else
            {
                return sides.get(0) * sides.get(2);
            }
        }
    }

    /**
     * draws the rectangle
     */
    @Override
    public void draw()
    {
        System.out.println("--------------------------------------");
        System.out.println("Type : Rectangle");
        System.out.println("Perimeter : " + calculatePerimeter());
        System.out.println("Area : " + calculateArea());
        System.out.println("--------------------------------------");
    }

    @Override
    public boolean equals(Object obj)
    {
        if(obj == this)
        {
            return true;
        }
        if(!(obj instanceof Rectangle))
        {
            return false;
        }
        Rectangle r = (Rectangle)obj;
        if(sides.get(0) == r.getSides().get(0) && sides.get(1) == r.getSides().get(1) && sides.get(2) == r.getSides().get(2) && sides.get(3) == r.getSides().get(3))
        {
            return true;
        }
        return false;
    }

    @Override
    public String toString() 
    {
        String s = "Type : Triangle" + "\n" + super.toString();
        return s;
    }
}
