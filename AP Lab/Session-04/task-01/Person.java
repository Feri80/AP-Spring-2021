/**
 * This class contains a person and its information
 * 
 * @author Farhad Aman
 * @version 1.0
 */
public class Person 
{
    /**
     * peson first name
     */
    private String firstName;
    /**
     * person last name
     */
    private String lastName;

    /**
     * Creates a new person
     * @param firstName first name
     * @param lastName last name
     */
    public Person(String firstName, String lastName)
    {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * returns first name
     * @return firstName
     */
    public String getFirstName()
    {
        return firstName;
    }

    /**
     * returns last name
     * @return lastName
     */
    public String getLastName()
    {
        return lastName;
    }

    @Override
    public String toString() 
    {
        // TODO Auto-generated method stub
        return super.toString();
    }
}
