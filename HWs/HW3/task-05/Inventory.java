import java.util.HashMap;

/**
 * This class contains the Inventory of the shop
 * 
 * @author Farhad Aman
 * @version 1.0
 */
public class Inventory 
{
    /**
     * the list of productions in inventory
     */
    HashMap<Product, Integer> productionsList;

    /**
     * creates a new Inventory
     */
    public Inventory()
    {
        productionsList = new HashMap<Product, Integer>();
    }

    /**
     * adds or removes some items from the inventory stock can be negative
     * @param product
     * @param stock
     */
    public boolean addProduct(Product product, int stock)
    {
        // this prevents to store object that production date is after expiration date
        if(product.getProductionDate().after(product.getExpirationDate()))
        {
            System.out.println("Poduction Date Is After Expiration Date.");
            return false;
        }

        if(productionsList.get(product) == null)
        {
            if(stock < 0)
            {
                System.out.println("Out Of Stock");
                return false;
            }
            else
            {
                productionsList.put(product, stock);
                return true;
            }
        }
        else
        {
            if(productionsList.get(product) + stock < 0)
            {
                System.out.println("Out Of Stock");
                return false; 
            }
            else
            {
                productionsList.replace(product, productionsList.get(product) + stock);
                return true;
            }
        }
    }

    /**
     * returns list of productions
     * @return productionsList
     */
    public HashMap<Product, Integer> getProductionsList()
    {
        return productionsList;
    }

    @Override
    public String toString() 
    {
        boolean isOutOfStock = true;
        int i = 1;
        StringBuilder s = new StringBuilder();
        for(Product p : productionsList.keySet())
        {
            if(productionsList.get(p) > 0)
            {
                isOutOfStock = false;
            }
            s.append(i + "){\n" + p.toString() + "}instock: " + productionsList.get(p) + "\n");
            i++;
        }
        if(isOutOfStock)
        {
            return "We are out of stock.\n";
        }
        return s.toString();
    }
}
