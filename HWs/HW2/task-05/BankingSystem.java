import java.util.ArrayList;
import java.util.Iterator;

public class BankingSystem 
{
    private ArrayList<User> users;
    private ArrayList<Account> accounts;

    public BankingSystem()
    {
        users = new ArrayList<User>();
        accounts = new ArrayList<Account>();
    }

    public void register(User user)
    {
        for(User u : users)
        {
            if(u.getId().equals(user.getId()))
            {
                System.out.println("User Already Exists.");
                return;
            }
        }
        users.add(user);
        System.out.println("User Created.");
    }

    public User login(String id, String password)
    {
        for(User u : users)
        {
            if(u.getId().equals(id))
            {
                if(u.getPassword().equals(password))
                {
                    System.out.println("Logged In Successfully.");
                    return u;
                }
                else
                {
                    System.out.println("Password Is Incorrect.");
                    return null;
                }
            }
        }
        System.out.println("This User Does Not Exist.");
        return null;
    }

    public void addUser(User user)
    {
        users.add(user);
    }

    public void removeUser(User user)
    {
        users.remove(user);
    }
    
    public void displayUsers()
    {
        for(int i=0; i<users.size(); i++)
        {
            System.out.print("User " + (i + 1) + ": ");
            users.get(i).printUserData();
        }
    }
    
    public void addAccount(Account account)
    {
        accounts.add(account);
    }

    public void removeAccount(Account account)
    {
        accounts.remove(account);
    }
    
    public void displayAccounts()
    {
        int i = 1;
        Iterator<Account> it = accounts.iterator();
        while(it.hasNext())
        {
            it.next().printAccountData();
        }
    }

    public Account findAccount(String serial)
    {
        Iterator<Account> it = accounts.iterator();
        while(it.hasNext())
        {
            Account a = it.next();
            if(a.getSerial().equals(serial))
            {
                return a;
            }
        }
        return null;
    }

    public ArrayList<User> getUsers()
    {
        return users;
    }

    public ArrayList<Account> getAccounts()
    {
        return accounts;
    }
}
