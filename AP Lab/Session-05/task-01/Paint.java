import java.util.ArrayList;

/**
 * This class contains the lists of the shapes
 * 
 * @author Farhad Aman
 * @version 1.0
 */
public class Paint 
{
    /**
     * the list of circles
     */
    private ArrayList<Circle> circles;

    /**
     * the list of triangles
     */
    private ArrayList<Triangle> triangles;

    /**
     * the list of rectangles
     */
    private ArrayList<Rectangle> rectangles;

    /**
     * creates a new paint
     */
    public Paint()
    {
        circles = new ArrayList<Circle>();
        triangles= new ArrayList<Triangle>();
        rectangles = new ArrayList<Rectangle>();
    }

    /**
     * adds a new circle to the list
     * @param circle
     */
    public void addCircle(Circle circle)
    {
        circles.add(circle);
    }

    /**
     * adds a new triangle to the list
     * @param triangle
     */
    public void addTriangle(Triangle triangle)
    {
        triangles.add(triangle);
    }

    /**
     * adds a new rectangle to the list
     * @param rectangle
     */
    public void addRectangle(Rectangle rectangle)
    {
        rectangles.add(rectangle);
    }

    /**
     * draws all of the shapes in the lists
     */
    public void drawAll()
    {
        for(Circle c : circles)
        {
            c.draw();
        }
        for(Triangle t : triangles)
        {
            t.draw();
        }
        for(Rectangle r : rectangles)
        {
            r.draw();
        }
    }

    /**
     * prints all of the shapes details
     */
    public void printAll()
    {
        for(Circle c : circles)
        {
            System.out.println(c);
        }
        for(Triangle t : triangles)
        {
            System.out.println(t);
        }
        for(Rectangle r : rectangles)
        {
            System.out.println(r);
        }
    }
}
