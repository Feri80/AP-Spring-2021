import java.util.Date;

public class Match 
{
    private String opponent;
    private Date date;

    public Match(String opponent, Date date)
    {
        this.opponent = opponent;
        this.date = date;
    }

    public String getOpponent()
    {
        return opponent;
    }

    public Date getDate()
    {
        return date;
    }
}
