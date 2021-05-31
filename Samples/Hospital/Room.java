public abstract class Room implements Printable
{
    private int Code;

    public Room(int code)
    {
        Code = code;
    }

    public int getCode()
    {
        return Code;
    }

    public void setCode(int code)
    {
        Code = code;
    }
}
