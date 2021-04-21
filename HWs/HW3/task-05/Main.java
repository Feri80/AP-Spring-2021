import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main 
{


    public static void main(String[] args) throws ParseException
    {
        Inventory inventory = new Inventory();

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

        inventory.addProduct(new Product("Carrot", "Vegetables", 5, 20, formatter.parse("15-3-2020"), formatter.parse("15-3-2021")), 10);
        inventory.addProduct(new Product("Apple", "Fruits", 10, 50, formatter.parse("1-4-2020"), formatter.parse("1-8-2020")), 50);
        inventory.addProduct(new Product("12xEggs", "Egg", 100, 40, formatter.parse("1-1-2020"), formatter.parse("1-6-2020")), 20);
        inventory.addProduct(new Product("Oats", "Grains", 70, 100, formatter.parse("1-6-2020"), formatter.parse("1-1-2021")), 45);
        inventory.addProduct(new Product("Salmon", "Seafood", 150, 250, formatter.parse("1-1-2020"), formatter.parse("1-2-2020")), 5);
        inventory.addProduct(new Product("ُStake", "Meat", 800, 1000, formatter.parse("1-3-2020"), formatter.parse("1-9-2020")), 5);
        inventory.addProduct(new Product("Milk", "Dairy", 100, 20, formatter.parse("10-1-2020"), formatter.parse("25-1-2020")), 20);
        inventory.addProduct(new Product("Cheese", "Dairy", 150, 10, formatter.parse("1-2-2020"), formatter.parse("15-3-2020")), 50);

        Basket basket = new Basket();
        
        System.out.println(inventory);

        Scanner input = new Scanner(System.in);
        String command;

        while(true)
        {
            command = input.nextLine();
            if(command.equals("checkout"))
            {
                System.out.println("It was a pleasure doing business with you.");
                System.exit(0);
            }
            else if(command.equals("products"))
            {
                System.out.println(inventory);
            }
            else if(command.equals("cart"))
            {
                System.out.println(basket);
            }
            else
            {
                String firstCommand = command.split(" ")[0];
                if(!(firstCommand.equals("add") || firstCommand.equals("remove")))
                {
                    continue;
                }
                int index = Integer.parseInt(command.split(" ")[1]);
                
                if(firstCommand.equals("add"))
                {
                    if(index > inventory.getProductionsList().size())
                    {
                        continue;
                    }
                    int i = 1;
                    for(Product p : inventory.getProductionsList().keySet())
                    {
                        if(i == index)
                        {
                            if(inventory.addProduct(p, -1))
                            {
                                basket.addProduct(p);
                            }
                        }
                        i++;
                    }
                }
                else if(firstCommand.equals("remove"))
                {
                    if(index > basket.getCart().size())
                    {
                        continue;
                    }
                    inventory.addProduct(basket.getCart().get(index - 1), 1);
                    basket.removeProduct(index -1 );
                }
            }
        }
    }
}
