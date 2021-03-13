/**
 * This class contains a student datails
 * 
 * @author Farhad Aman
 * @version 1.0
 */
public class Student 
{
    // the student's first name
    private String firstName;

    // the student's last name
    private String lastName;

    // the student's ID
    private String id;

    // the student's grade
    private double grade;

    /**
     * Create a new student with a given name and ID number.
     * 
     * @param fName first name of student
     * @param lName last name of student
     * @param sId student's ID
     */
    public Student(String fName, String lName, String sId)
    {
        firstName = fName;
        lastName = lName;
        id = sId;
        grade = 0;
    }

    /**
     * get first name of student
     * 
     * @return firstName field
     */
    public String getFirstName()
    {
        return firstName;
    }

    /**
     * set first name of student
     * 
     * @param fName first name of student 
     */
    public void setFirstName(String fName)
    {
        firstName = fName;    
    }

    /**
     * get the last name of student
     * 
     * @return lastName field
     */
    public String getLastName()
    {
        return lastName;
    }

    /**
     * set last name of student
     * 
     * @param lName last name of student
     */
    public void setLastName(String lName)
    {
        lastName = lName;    
    }

    /**
     * get id of student
     * 
     * @return id feild
     */
    public String getId()
    {
        return id;
    }

    /**
     * set id of student
     * 
     * @param sId id of student
     */
    public void setId(String sId)
    {
        if(sId.length() != 7)
        {
            System.out.println("Invalid ID");
        }
        else
        {
            id = sId;
        }
    }

    /**
     * get grade of student
     * 
     * @return grade field
     */
    public double getGrade()
    {
        return grade;
    }

    /**
     * set grade of student
     * 
     * @param sGrade grade of student
     */
    public void setGrade(double sGrade)
    {
        if(sGrade > 20 || sGrade < 0)
        {
            System.out.println("Invalid Grade");
        }
        else
        {
            grade = sGrade;
        }    
    }

    /**
     * Prints the student last name & id 
     */
    public void print()
    {
        System.out.println(lastName + ", student ID: " + id + ", grade: " + grade);
    }
}
