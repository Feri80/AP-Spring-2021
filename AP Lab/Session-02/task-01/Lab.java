/**
 * This class contains a labratory details
 * 
 * @author Farhad Aman
 * @version 1.0
 */
public class Lab 
{
    // the student of lab
    private Student[] students;
    
    // the avg of lab grades
    private double avg;

    // the weekday of lab
    private String day;

    // the capacity of lab
    private int capacity;

    // the current size of lab
    private int currentSize = 0;

    /**
     * Create a new lab with a given capacity & weekday
     * 
     * @param c capacity of lab
     * @param d weekday of lab
     */
    public Lab(int c, String d)
    {
        capacity = c;
        day = d;
        students = new Student[capacity];
    }

    /**
     * Enrolls a new student to the lab
     * 
     * @param newStudent new student
     */
    public void enrollStudent(Student newStudent)
    {
        if(currentSize < capacity)
        {
            students[currentSize] = newStudent;
            currentSize++;
        } 
        else 
        {
            System.out.println("The Capacity I Full.");
        }
    }

    /**
     * Prints the list of students.
     */
    public void print() 
    {
        System.out.println("Sudents :");
        System.out.println("****************************");
        for(int i = 0 ; i < currentSize ; i++)
        {
            students[i].print();
        }    
        System.out.println("****************************");
    }

    /**
     * get students
     * 
     * @return students field
     */
    public Student[] getStudents()
    {
        return students;
    }

    /**
     * set new students list
     * 
     * @param newStudents new students list
     */
    public void setStudents(Student[] newStudents)
    {
        students = newStudents;
    }

    /**
     * get avg
     * 
     * @return avg field
     */
    public double getAvg()
    {
        return avg;
    }

    /**
     * Calculates the avg of student's grades.
     */
    public void calcAvg()
    {
        avg = 0;
        for(int i = 0 ;i < currentSize ;i++)
        {
            avg += students[i].getGrade();
        }
        avg /= currentSize;
    }

    /**
     * get day
     * 
     * @return day field
     */
    public String getDay()
    {
        return day;
    }

    /**
     * set weekday
     * 
     * @param d day
     */
    public void setDay(String d)
    {
        day = d;
    }

    /**
     * get capacity
     * 
     * @return capacity field
     */
    public int getCapacity()
    {
        return capacity;
    }

    /**
     * set capacity
     * 
     * @param c capacity
     */
    public void setCapacity(int c)
    {
        capacity = c;
    }
}
