public abstract class Element
{

    private int row;
    private int col;
    private char color;

    public Element(int row, int col, char color)
    {
        this.row = row;
        this.col = col;
        this.color = color;
    }

    public void setRow (int row) {
        this.row = row;
    }

    public void setCol (int col) {
        this.col = col;
    }

    public int getCol () {
        return col;
    }

    public int getRow () {
        return row;
    }

    public char getColor () {
        return color;
    }
}
