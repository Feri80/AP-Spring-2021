import java.util.ArrayList;

/**
 * This class contains your cart details
 * 
 * @author Farhad Aman
 * @version 1.0
 */
public class Basket 
{
    /**
     * list of items in the cart 
     */
    private ArrayList<Product> cart;

    /**
     * creates a new basket
     */
    public Basket()
    {
        cart = new ArrayList<Product>();
    }

    /**
     * returns the sum of prices in your cart
     * @return sumOfPrices
     */
    public double getSumOfPrices()
    {
        double sumOfPrices = 0;
        for(Product p : cart)
        {
            sumOfPrices += p.getPrice();
        }
        return sumOfPrices;
    }

    /**
     * adds a new product to the cart
     * @param product
     */
    public void addProduct(Product product)
    {
        cart.add(product);
    }

    /**
     * removes a product from the cart
     * @param index
     */
    public void removeProduct(int index)
    {
        cart.remove(index);
    }

    /**
     * returns cart
     * @return cart
     */
    public ArrayList<Product> getCart()
    {
        return cart;
    }    

    @Override
    public String toString() 
    {
        if(cart.isEmpty())
        {
            return "List is empty.\n";
        }
        int i = 1;
        StringBuilder s = new StringBuilder();
        s.append("Itemsincart:\n");
        for(Product p : cart)
        {
            s.append(i + "){\n" + p.toString() + "}\n");
            i++;
        }
        return s.toString();
    }
}
