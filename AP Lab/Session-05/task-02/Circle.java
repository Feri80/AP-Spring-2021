/**
 * This class contains a circle shape details
 * 
 * @author Farhad Aman 
 * @version 1.0
 */
public class Circle extends Shape
{
    /**
     * the radius of the circle
     */
    private double radius;

    /**
     * creates new circle with given radius
     * @param radius
     */
    public Circle(double radius)
    {
        this.radius = radius;
    }

    /**
     * return the radius of the circle
     * @return radius
     */
    public double getRadius()
    {
        return radius;
    }

    /**
     * returns the perimeter of the circle
     * @return perimeter
     */
    @Override
    public double calculatePerimeter()
    {
        return 2 * Math.PI * radius;
    }

    /**
     * returns the area of the circle
     * @return area
     */
    @Override
    public double calculateArea()
    {
        return Math.PI * radius * radius;
    }

    /**
     * draws the circle
     */
    @Override
    public void draw()
    {
        System.out.println("--------------------------------------");
        System.out.println("Type : Circle");
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
        if(!(obj instanceof Circle))
        {
            return false;
        }
        Circle c = (Circle)obj;
        if(c.getRadius() == this.radius)
        {
            return true;
        }
        return false;
    }

    @Override
    public String toString() 
    {
        String s = "Type : Circle" + "\n" + "Radius : " + radius + "\n";
        return s;
    }
    
}
