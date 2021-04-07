import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
    public static void sleep(int t)
    {
        try
        {
            Thread.sleep(t * 1000);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    }

    public static void clearScreen() throws InterruptedException, IOException
    {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }

    
    public static void showMenu()
    {
        System.out.println("BANK");
        System.out.println("-------------------------------");
        System.out.println("1.Sign Up");
        System.out.println("2.Log In");
        System.out.println("3.System Admin");
        System.out.println("4.Exit");
        System.out.println("-------------------------------");
    }



    public static void main(String[] args) throws InterruptedException, IOException 
    {
        BankingSystem bankingSystem = new BankingSystem();

        Scanner input = new Scanner(System.in);

        while(true)
        {
            clearScreen();
            showMenu();
            int choice = input.nextInt();
            if(choice == 1)
            {
                input.nextLine();
                clearScreen();

                String firstName;
                String lastName;
                String id;
                String password;

                System.out.print("First Name : ");
                firstName = input.nextLine();

                System.out.print("Last Name : ");
                lastName = input.nextLine();

                System.out.print("ID : ");
                id = input.nextLine();

                System.out.print("Password : ");
                password = input.nextLine();

                User user = new User(id, firstName, lastName, password);
                bankingSystem.register(user);

                sleep(2);
            }
            else if(choice == 2)
            {
                input.nextLine();
                clearScreen();

                String id;
                String password;

                System.out.print("ID : ");
                id = input.nextLine();

                System.out.print("Password : ");
                password = input.nextLine();

                User loggedUser = bankingSystem.login(id, password);
                sleep(2);
                if(loggedUser != null)
                {
                    while(true)
                    {
                        clearScreen();
                        System.out.println("-------------------------------");
                        System.out.println("1.Existing Accounts");
                        System.out.println("2.Add New Account");
                        System.out.println("3.Log Out");
                        System.out.println("-------------------------------");
                        choice = -1;
                        choice = input.nextInt();
                        if(choice == 1)
                        {
                            input.nextLine();
                            clearScreen();
                            choice = -1;
                            for(int i=0; i<loggedUser.getAccountList().size(); i++)
                            {
                                System.out.println("Account " 
                                    + (i + 1) 
                                    + ": " 
                                    + loggedUser.getAccountList().get(i).getSerial()
                                    + ", " 
                                    + loggedUser.getAccountList().get(i).getId()
                                    + ", "
                                    + loggedUser.getAccountList().get(i).getFirstName()
                                    + ", " 
                                    + loggedUser.getAccountList().get(i).getLastName()
                                    + ", "
                                    + loggedUser.getAccountList().get(i).getBalance());
                            }
                            System.out.println("Account Number : ");
                            choice = input.nextInt();

                            if(choice < 1 || choice > loggedUser.getAccountList().size())
                            {
                                System.out.println("Invalid Account");
                                sleep(2);
                            }
                            else
                            {
                                input.nextLine();
                                Account loggedAccount = loggedUser.getAccountList().get(choice - 1);
                                System.out.println("Log Into Account");
                                sleep(2);
                                
                                while(true)
                                {
                                    clearScreen();
                                    choice = -1;
                                    System.out.println("-------------------------------");
                                    System.out.println("1.Withdrawal");
                                    System.out.println("2.Deposit");
                                    System.out.println("3.Transfer");
                                    System.out.println("4.Check Balance");
                                    System.out.println("5.Back");
                                    System.out.println("-------------------------------");

                                    choice = input.nextInt();

                                    if(choice == 1)
                                    {
                                        clearScreen();
                                        System.out.println("Amount : ");
                                        int amount = input.nextInt();
                                        loggedUser.withdrawal(loggedAccount, amount);
                                        sleep(2);
                                    }
                                    else if(choice == 2)
                                    {
                                        clearScreen();
                                        System.out.println("Amount : ");
                                        int amount = input.nextInt();
                                        loggedUser.deposit(loggedAccount, amount);
                                        sleep(2);
                                    }
                                    else if(choice == 3)
                                    {
                                        clearScreen();
                                        input.nextLine();
                                        System.out.println("Destination Serial : ");
                                        String serial = input.nextLine();
                                        System.out.println("Amount : ");
                                        int amount = input.nextInt();
                                        Account dest = bankingSystem.findAccount(serial);
                                        loggedUser.transfer(loggedAccount, dest, amount);
                                        sleep(2);
                                    }
                                    else if(choice == 4)
                                    {
                                        System.out.println("Balance : " + loggedAccount.getBalance());
                                        sleep(2);
                                    }
                                    else if(choice == 5)
                                    {
                                        break;
                                    }
                                    else
                                    {
                                        continue;
                                    }
                                }
                            }
                        }
                        else if(choice == 2)
                        {
                            input.nextLine();
                            clearScreen();

                            String type;
                            int initAmount;
                            
                            System.out.print("Type : ");
                            type = input.nextLine();

                            System.out.print("Initial Anount : ");
                            initAmount = input.nextInt();

                            Account newAccount = new Account(loggedUser.getId(), 
                                loggedUser.getFirstName(), 
                                loggedUser.getLastName(), 
                                type, 
                                initAmount);

                            loggedUser.addAccount(newAccount);
                            bankingSystem.addAccount(newAccount);

                            System.out.println("New Account Opened.");
                            sleep(2);
                        }
                        else if(choice == 3)
                        {
                            break;
                        }
                        else
                        {
                            continue;
                        }
                    }
                }
                else
                {
                    continue;
                }
            }
            else if(choice == 3)
            {
                input.nextLine();
                clearScreen();

                String username;
                String password;

                System.out.print("Username : ");
                username = input.nextLine();

                System.out.print("Password : ");
                password = input.nextLine();

                if(username.equals("sysadmin") && password.equals("1234"))
                {
                    System.out.println("Logged In As Sysadmin.");
                    sleep(2);
                    while(true)
                    {
                        clearScreen();
                        System.out.println("SYS ADMIN");
                        System.out.println("-------------------------------");
                        System.out.println("1.Display Users");
                        System.out.println("2.Display Accounts");
                        System.out.println("3.Remove User");
                        System.out.println("4.Remove Account");
                        System.out.println("5.Log Out");
                        System.out.println("-------------------------------");
                        choice = -1;
                        choice = input.nextInt();
                        if(choice == 1)
                        {
                            clearScreen();
                            bankingSystem.displayUsers();
                            sleep(5);
                        }
                        else if(choice == 2)
                        {
                            clearScreen();
                            for(int i=0; i<bankingSystem.getAccounts().size(); i++)
                            {
                                System.out.println("Account " 
                                    + (i + 1) 
                                    + ": " 
                                    + bankingSystem.getAccounts().get(i).getSerial()
                                    + ", " 
                                    + bankingSystem.getAccounts().get(i).getType()
                                    + ", " 
                                    + bankingSystem.getAccounts().get(i).getBalance());
                            }
                            sleep(7);
                        }
                        else if(choice == 3)
                        {
                            clearScreen();
                            input.nextLine();
                            System.out.println("ID : ");
                            String id = input.nextLine();
                            boolean checkValid = false;
                            User user = null;
                            for(User u : bankingSystem.getUsers())
                            {
                                if(u.getId().equals(id))
                                {
                                    for(Account a : u.getAccountList())
                                    {
                                        bankingSystem.removeAccount(a);
                                    }
                                    user = u;
                                }
                            }
                            if(user == null)
                            {
                                System.out.println("User doesn’t exist.");
                                sleep(2);
                            }
                            else
                            {
                                System.out.println("User removed.");
                                bankingSystem.removeUser(user);
                                sleep(2);
                            }
                        }
                        else if(choice == 4)
                        {
                            clearScreen();
                            input.nextLine();
                            System.out.println("Serial : ");
                            String serial = input.nextLine();
                            Account account = bankingSystem.findAccount(serial);
                            if(account == null)
                            {
                                System.out.println("Account Doesn’t Exist.");
                            }
                            else
                            {
                                for(User u : bankingSystem.getUsers())
                                {
                                    if(u.getId().equals(account.getId()))
                                    {
                                        u.removeAccount(account);
                                    }
                                }
                                bankingSystem.removeAccount(account);
                                System.out.println("Account removed.");
                            }
                            sleep(2);
                        }
                        else if(choice == 5)
                        {
                            break;
                        }
                        else
                        {
                            continue;
                        }
                    }
                }   
                else
                {
                    System.out.println("Username Or Password Is Incorrect.");
                    sleep(2);
                    continue;
                }
            }
            else if(choice == 4)
            {
                System.exit(0);
            }
            else
            {
                continue;
            }
        }
    }
}
