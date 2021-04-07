import java.util.ArrayList;

public class User 
{
    private String firstName;
    private String lastName;
    private final String id;
    private String password;
    private ArrayList<Account> accountList;

    public User(String id, String firstName, String lastName, String password)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.password= password;
        accountList = new ArrayList<Account>();
    }

    public void addAccount(Account account)
    {
        accountList.add(account);
    }

    public void removeAccount(Account account)
    {
        accountList.remove(account);
    }

    public void deposit(Account account, int amount)
    {
        if(accountList.contains(account))
        {
            account.updateBalance(amount);
            Transaction newTransaction = new Transaction(amount);
            account.addTransaction(newTransaction);
            System.out.println("Transaction Completed.");
        }
        else
        {
            System.out.println("This account does not exist.");
            return;
        }
    }
    
    public void withdrawal(Account account, int amount)
    {
        if(accountList.contains(account))
        {
            if(amount > account.getBalance())
            {
                System.out.println("There Is Not Enough Balance In This Account.");
                return;
            }
            account.updateBalance(-1 * amount);
            Transaction newTransaction = new Transaction(-1 * amount);
            account.addTransaction(newTransaction);
            System.out.println("Transaction Completed.");
        }
        else
        {
            System.out.println("This account does not exist.");
            return;
        }
    }
    
    public void transfer(Account srcAccount, Account destAccount, int amount)
    {
        if(accountList.contains(srcAccount) && destAccount != null)
        {
            if(amount > srcAccount.getBalance())
            {
                System.out.println("There is not enough balance in this account.");
                return;
            }
            srcAccount.updateBalance(-1 * amount);
            destAccount.updateBalance(amount);
            Transaction newTransaction = new Transaction(-1 * amount);
            srcAccount.addTransaction(newTransaction);
        }
        else
        {
            System.out.println("This account does not exist");
            return;
        }
    }

    public void checkBalance(Account account)
    {
        if(accountList.contains(account))
        {
            System.out.println("Your account balance is : " + account.getBalance());
        }
        else
        {
            System.out.println("This account does not exist");
            return;
        }
    }

    public void printAllAvailableAccounts()
    {
        for(Account a : accountList)
        {
            a.printAccountData();
        }
    }
    
    public void printUserData()
    {
        System.out.println(firstName + " " + lastName + " " + id);
    }

    public String getId()
    {
        return id;
    }

    public String getPassword()
    {
        return password;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public ArrayList<Account> getAccountList()
    {
        return accountList;
    }
}
