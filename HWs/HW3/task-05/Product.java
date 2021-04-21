import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This class contains a product details
 * 
 * @author Farhad Aman 
 * @version 1.0
 */
public class Product
{   
    /**
     * the name of product
     */
    private String name;

    /**
     * the category of product
     */
    private String category;

    /**
     * the weight of product
     */
    private double weight;

    /**
     * the price of product
     */
    private double price;

    /**
     * the production date of product
     */
    private Date productionDate;

    /**
     * the expiration date of product
     */
    private Date expirationDate;

    /**
     * creates a new product
     * @param name
     * @param category
     * @param weight
     * @param price
     * @param productDate
     * @param expirationDate
     */
    public Product(String name, String category, double weight, double price, Date productDate, Date expirationDate)
    {
        this.name = name;
        this.category = category;
        this.weight = weight;
        this.price= price;
        this.productionDate = productDate;
        this.expirationDate= expirationDate;
    }

    /**
     * return the price of product
     * @return price
     */
    public double getPrice()
    {
        return price;
    }

    @Override
    public String toString() 
    {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        return "  \"Product\": {\n" +
               "    \"NAME\": \"" + name + "\",\n" +
               "    \"CATEGORY\": \"" + category + "\",\n" +
               "    \"WEIGHT\": \"" + weight + "\",\n" +
               "    \"PRICE\": \"" + price + "\",\n" +
               "    \"MANUFACTURE_DATE\": \"" + formatter.format(productionDate) + "\",\n" +
               "    \"EXPIRATION_DATE\": \"" + formatter.format(expirationDate) + "\"\n  }\n";
    }
    
}