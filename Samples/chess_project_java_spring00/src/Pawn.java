public class Pawn extends Element
    implements Actions

{

    public Pawn (int row, int col, char color) {
        super (row, col, color);
    }

    @Override
    public boolean move (int dst_row, int dst_col, Board board) {
        Element dst_element = board.getElement (dst_row, dst_col);

        if (dst_element == null)
        {
            if ((getColor () == 'b' && (getRow () - 1 == dst_row && getCol () == dst_col)) ||
                    (getColor () == 'w' && (getRow () + 1 == dst_row && getCol () == dst_col)))
            {
                setRow (dst_row);
                setCol (dst_col);
                return true;
            }
        }
        else if (dst_element.getColor () != getColor ())
        {
            if ((getColor () == 'b' && (getRow () - 1 == dst_row && getCol () == dst_col)) ||
                    (getColor () == 'w' && (getRow () + 1 == dst_row && getCol () == dst_col)))
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
            return "♟";
        else
            return "♙";
    }
}
