import java.util.ArrayList;

public class Board
{
    private ArrayList<Element> whiteElements;
    private ArrayList<Element> blackElements;


    public Board()
    {

        whiteElements = new ArrayList<> ();
        blackElements = new ArrayList<> ();

        for (int i = 0; i < 5; i++)
            whiteElements.add (new Pawn (1, i, 'w'));

        whiteElements.add (new Rook (0, 0, 'w'));
        whiteElements.add (new Rook (0, 4, 'w'));

        whiteElements.add (new Knights (0, 1, 'w'));
        whiteElements.add (new Knights (0, 3, 'w'));

        whiteElements.add (new King (0, 2, 'w'));


        for (int i = 0; i < 5; i++)
            blackElements.add (new Pawn (8, i, 'b'));

        blackElements.add (new Rook (9, 0, 'b'));
        blackElements.add (new Rook (9, 4, 'b'));

        blackElements.add (new Knights (9, 1, 'b'));
        blackElements.add (new Knights (9, 3, 'b'));

        blackElements.add (new King (9, 2, 'b'));



    }

    public void print_map()
    {
        System.out.println ("\tA\t\tB\t\tC\t\tD\t\tE");
        for (int row = 0; row < 10; row++)
        {
            System.out.print (row + "\t");
            for (int col = 0; col < 5; col++)
            {
                Element element = getElement (row, col);

                if (element == null)
                    System.out.print ('.');
                else
                    System.out.print (element);

                System.out.print ("\t\t");
            }
            System.out.print ("\n");
        }
    }

    public Element getElement (int row, int col)
    {
        for (Element element : whiteElements)
            if (element.getCol () == col && element.getRow () == row)
                return element;

        for (Element element : blackElements)
            if (element.getCol () == col && element.getRow () == row)
                return element;

        return null;
    }

    public void removeBlackElement(Element element)
    {
        blackElements.remove (element);
    }

    public void removeWhiteElement(Element element)
    {
        whiteElements.remove (element);
    }

    public boolean isWhiteElementsEmpty()
    {
        return (whiteElements.size () == 0);
    }

    public boolean isBlackElementsEmpty()
    {
        return (blackElements.size () == 0);
    }
}
