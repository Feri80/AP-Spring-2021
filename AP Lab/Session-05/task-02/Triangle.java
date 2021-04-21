/**
 * This class contains a triangle shape details
 * 
 * @author Farhad Aman  
 * @version 1.0
 */
public class Triangle extends Polygon
{
    /**
     * creates a new triangle with given sides
     * @param side1
     * @param side2
     * @param side3
     */
    public Triangle(int side1, int side2, int side3)
    {
        super(side1, side2, side3);
    }

    /**
     * checks if the triangle is equilateral
     */
    public boolean isEquilateral()
    {
        if(sides.get(0) == sides.get(1) && sides.get(1) == sides.get(2))
        {
            return true;
        } 
        return false;
    }

    /**
     * returns the perimeter of the triangle
     * @return perimeter
     */
    @Override
    public double calculatePerimeter()
    {
        return sides.get(0) + sides.get(1) + sides.get(2);
    }

    /**
     * returns the area of the triangle
     * @return area
     */
    @Override
    public double calculateArea()
    {
        double p = calculatePerimeter() / 2;
        return Math.sqrt(p * (p - sides.get(0)) * (p - sides.get(1)) * (p - sides.get(2)));
    }

    /**
     * draws the triangle
     */
    @Override
    public void draw()
    {
        System.out.println("--------------------------------------");
        System.out.println("Type : Triangle");
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
        if(!(obj instanceof Triangle))
        {
            return false;
        }
        Triangle t = (Triangle)obj;
        if(sides.get(0) == t.getSides().get(0) && sides.get(1) == t.getSides().get(1) && sides.get(2) == t.getSides().get(2))
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
