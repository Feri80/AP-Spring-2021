import java.util.Date;

public class Transaction 
{
    private final int amount;
    private final String date;

    public Transaction(int amount)
    {
        this.amount = amount;
        Date currentDate = new Date();
        date = currentDate.toString();
    }

    public void print()
    {
        System.out.println("amount = " + amount);
        System.out.println("date = " + date);
    }
    
    public int getAmount()
    {
        return amount;
    }

    public String getDate()
    {
        return date;
    }
}