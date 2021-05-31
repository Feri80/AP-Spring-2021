
public class King extends Element
    implements Actions
{
    public King (int row, int col, char color) {
        super (row, col, color);
    }

    @Override
    public boolean move (int dst_row, int dst_col, Board board) {

        Element dst_element = board.getElement (dst_row, dst_col);
        if (dst_element == null)
        {
            if ((getRow () == dst_row) && (getCol () - dst_col == 1 || getCol () - dst_col == -1))
            {
                setRow (dst_row);
                setCol (dst_col);
                return true;
            }
            else if ((getCol () == dst_col) && (getRow () - dst_row == 1 || getRow () - dst_row == -1))
            {
                setRow (dst_row);
                setCol (dst_col);
                return true;
            }
        }
        else if (dst_element.getColor () != getColor ())
        {
            if ((getRow () == dst_row) && (getCol () - dst_col == 1 || getCol () - dst_col == -1))
            {
                setRow (dst_row);
                setCol (dst_col);
                if (getColor () == 'w')
                    board.removeBlackElement (dst_element);
                else
                    board.removeWhiteElement (dst_element);
                return true;
            }
            else if ((getCol () == dst_col) && (getRow () - dst_row == 1 || getRow () - dst_row == -1))
            {
                setRow (dst_row);
                setCol (dst_col);
                if (getColor () == 'w')
                    board.removeBlackElement (dst_element);
                else
                    board.removeWhiteElement (dst_element);
                return true;
            }
        }

        return false;

    }

    @Override
    public String toString () {
        if (getColor () == 'w')
            return "♚";
        else
            return "♔";
    }
}
