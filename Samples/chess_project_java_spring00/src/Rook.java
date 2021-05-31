public class Rook extends Element
    implements Actions

{

    public Rook (int row, int col, char color) {
        super (row, col, color);
    }

    @Override
    public boolean move (int dst_row, int dst_col, Board board) {


        if ((getRow () == dst_row) && (dst_col > getCol ()))
        {
            int col = getCol () + 1;
            for (; col <= dst_col; col++)
            {
                int result = step_move (getRow (), col, board);

                if (result == 1)
                {
                    col++;
                    break;
                }
                else if (result == -1)
                    return false;
            }
            setRow (getRow ());
            setCol (col - 1);
            return true;
        }
        else if ((getRow () == dst_row) && (dst_col < getCol ()))
        {
            int col = getCol () - 1;
            for (; col >= dst_col; col--)
            {
                int result = step_move (getRow (), col, board);
                if (result == 1)
                {
                    col--;
                    break;
                }
                else if (result == -1)
                    return false;
            }
            setRow (getRow ());
            setCol (col + 1);
            return true;
        }
        else if ((getCol () == dst_col) && (dst_row > getRow ()))
        {
            int row = getRow () + 1;
            for (; row <= dst_row; row++)
            {
                int result = step_move (row, getCol (), board);
                if (result == 1)
                {
                    row++;
                    break;
                }
                else if (result == -1)
                    return false;
            }
            setRow (row - 1);
            setCol (getCol ());
            return true;
        }
        else if ((getCol () == dst_col) && (dst_row < getRow ()))
        {
            int row = getRow () - 1;
            for (; row >= dst_row; row--)
            {
                int result = step_move (row, getCol (), board);
                if (result == 1)
                {
                    row--;
                    break;
                }
                else if (result == -1)
                    return false;
            }
            setRow (row + 1);
            setCol (getCol ());
            return true;
        }

        return false;
    }


    private int step_move(int row, int col, Board board)
    {
        Element dst_element = board.getElement (row, col);

        if (dst_element == null)
        {
            return 0;
        }
        else if (dst_element.getColor () != getColor ())
        {
            if (getColor () == 'w')
                board.removeBlackElement (dst_element);
            else
                board.removeWhiteElement (dst_element);
            return 1;
        }
        else
            return -1;
    }


    @Override
    public String toString () {
        if (getColor () == 'w')
            return "♜";
        else
            return "♖";
    }
}
