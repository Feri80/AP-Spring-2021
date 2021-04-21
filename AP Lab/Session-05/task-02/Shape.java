/**
 * This class contains a shape details
 * 
 * @author Farhad Aman
 * @version 1.0
 */
public abstract class Shape 
{

    /**
     * returns the perimeter of the shape
     */
    public abstract double calculatePerimeter();
    
    /**
     * returns the area of the shape
     */
    public abstract double calculateArea();

    /**
     * draws a shape
     */
    public abstract void draw();

    @Override
    public abstract boolean equals(Object obj);

    @Override
    public abstract String toString();
}
