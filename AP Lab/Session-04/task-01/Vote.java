import ir.huri.jcal.JalaliCalendar;

/**
 * This class contains a vote details
 * 
 * @author Farhad Aman
 * @version 1.0
 */
public class Vote 
{
    /**
     * the voter person
     */
    private Person person;
    /**
     * the date of vote
     */
    JalaliCalendar date;

    /**
     * creates a new vote
     * @param person voter person
     */
    public Vote(Person person)
    {
        this.person = person;
        date = new JalaliCalendar();
    }

    /**
     * returns person
     * @return person
     */
    public Person getPerson()
    {
        return person;
    }

    /**
     * returns date
     * @return date
     */
    public String getDate()
    {
        return date.toString();
    }

    @Override
    public boolean equals(Object obj) {
        // TODO Auto-generated method stub
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        // TODO Auto-generated method stub
        return super.hashCode();
    }
}
