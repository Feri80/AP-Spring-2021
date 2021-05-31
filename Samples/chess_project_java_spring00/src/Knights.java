public class Knights extends Element
    implements Actions
{

    public Knights (int row, int col, char color) {
        super (row, col, color);
    }

    @Override
    public boolean move (int dst_row, int dst_col, Board board) {
        Element dst_element = board.getElement (dst_row, dst_col);

        if (dst_element == null)
        {
            if ((getCol () - dst_col == 1 || getCol () - dst_col == -1) &&
                    (getRow () - dst_row == 2 || getRow () - dst_row == -2))
            {
                setCol (dst_col);
                setRow (dst_row);
                return true;
            }
            else if ((getRow () - dst_row == 1 || getRow () - dst_row == -1) &&
                    (getCol () - dst_col == 2 || getCol () - dst_col == -2))
            {
                setCol (dst_col);
                setRow (dst_row);
                return true;
            }
        }
        else if (dst_element.getColor () != getColor ())
        {
            if ((getCol () - dst_col == 1 || getCol () - dst_col == -1) &&
                    (getRow () - dst_row == 2 || getRow () - dst_row == -2))
            {
                setCol (dst_col);
                setRow (dst_row);
                if (getColor () == 'w')
                    board.removeBlackElement (dst_element);
                else
                    board.removeWhiteElement (dst_element);
                return true;
            }
            else if ((getRow () - dst_row == 1 || getRow () - dst_row == -1) &&
                    (getCol () - dst_col == 2 || getCol () - dst_col == -2))
            {
                setCol (dst_col);
                setRow (dst_row);
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
            return "♞";
        else
            return "♘";
    }
}
