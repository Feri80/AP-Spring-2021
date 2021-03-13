/**
 * This class contains the department details
 * 
 * @author Farhad Aman
 * @version 1.0
 */
public class Department 
{
    // the department labs
    private Lab[] labs;

    // the department name
    private final String name;

    // the maximum number of labs
    private int maxLabs;

    // the current number of labs
    private int labsCnt = 0;


    /**
     * Create a new department with a given name and maximum number of labs.
     * 
     * @param n nmae
     * @param mLabs maximum number of labs
     */
    public Department(final String n, int mLabs)
    {
        name = n;
        maxLabs = mLabs;
        labs = new Lab[maxLabs];
    }

    /**
     * Add a new lab
     * 
     * @param newLab new lab
     */
    public void addLab(Lab newLab)
    {
        if(labsCnt < maxLabs)
        {
            labs[labsCnt] = newLab;
            labsCnt++;
        } 
        else 
        {
            System.out.println("There isn't place for a new lab.");
        }
    }

    /**
     * get labs list
     * @return labs field
     */
    public Lab[] getLabs() 
    {
        return labs;
    }

    /**
     * set new labs list
     * 
     * @param newLabs new Labs list 
     */
    public void setLabs(Lab[] newLabs) 
    {
        labs = newLabs;
    }

    /**
     * get maximum number of labs
     * 
     * @return maxLabs field
     */
    public int getMaxLabs()
    {
        return maxLabs;
    }

    /**
     * get current number of labs
     * 
     * @return labsCnt field
     */
    public int getLabsCnt()
    {
        return labsCnt;
    }

    /**
     * get name
     * 
     * @return name field
     */
    public String getName()
    {
        return name;
    }

    /**
     * prints department details
     */
    public void print() 
    {
        System.out.println("Department's Name : " + name);
        System.out.println("Labs");
        System.out.println("--------------------------------------------------------");
        for(int i = 0 ;i < labsCnt ;i++)
        {
            labs[i].print();
        } 
        System.out.println("--------------------------------------------------------");
    }
}
