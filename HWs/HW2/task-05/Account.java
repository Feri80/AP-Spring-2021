import java.util.ArrayList;
import java.util.UUID;

public class Account 
{
    private UUID serial;
    private String id;
    private String firstName;
    private String lastName;
    private String type;
    private int balance;
    private ArrayList<Transaction> transactionList;
    
    public Account(String id, String firstName, String lastName, String type, int balance)
    {
        this.serial = UUID.randomUUID();
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.type = type;
        this.balance = balance;
        transactionList = new ArrayList<Transaction>();
    }

    public void updateBalance(int amount)
    {
        balance += amount;
    }

    public int getBalance()
    {
        return balance;
    }

    public String getSerial()
    {
        return serial.toString();
    }

    public String getType()
    {
        return type;
    }

    public String getId()
    {
        return id;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void addTransaction(Transaction transaction)
    {
        transactionList.add(transaction);
    }

    public void printTransactions()
    {
        for(Transaction t : transactionList)
        {
            t.print();
            System.out.println("-----------------------------------------");
        }
        System.out.println();
    }

    public void printAccountData()
    {
        System.out.println();
        System.out.println("Serial = " + serial);
        System.out.println("ID = " + id);
        System.out.println("First Name = " + firstName);
        System.out.println("Last Name = " + lastName);
        System.out.println("Type = " + type);
        System.out.println("Balance = " + balance);
        System.out.println();
    }
}
