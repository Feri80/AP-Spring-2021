public class Main
{


    public static void main(String[] args) 
    {
        Paint paint = new Paint();

        Shape s1 = new Circle(4);
        Shape s2 = new Circle(7);

        Shape s3 = new Triangle(3,4,5);
        Shape s4 = new Triangle(6,6,6);

        Shape s5 = new Rectangle(4,5,4,5);
        Shape s6 = new Rectangle(3,3,3,3);

        paint.addShape(s1);
        paint.addShape(s2);
        paint.addShape(s3);
        paint.addShape(s4);
        paint.addShape(s5);
        paint.addShape(s6);

        paint.drawAll();
        paint.printAll();
        paint.describeEqualSides();
    }
}