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
     * the list of shapes
     */
    private ArrayList<Shape> shapes;

    /**
     * creates a new paint
     */
    public Paint()
    {
        shapes = new ArrayList<Shape>();
    }

    /**
     * adds a new shape to the list
     * @param shape
     */
    public void addShape(Shape shape)
    {
        shapes.add(shape);
    }

    /**
     * draws all of the shapes in the list
     */
    public void drawAll()
    {
        for(Shape s : shapes)
        {
            s.draw();
        }
    }

    /**
     * prints all of the shapes details
     */
    public void printAll()
    {
        for(Shape s : shapes)
        {
            System.out.println(s);
        }
    }

    /**
     * find if the shape is square or equilateral triangle
     */
    public void describeEqualSides()
    {
        for(Shape s : shapes)
        {
            if(s instanceof Triangle)
            {
                Triangle t = (Triangle)s;
                if(t.isEquilateral())
                {
                    System.out.println(t);
                }
            }
            if(s instanceof Rectangle)
            {
                Rectangle r = (Rectangle)s;
                if(r.isSquare())
                {
                    System.out.println(r);
                }
            }
        }
    }
}
