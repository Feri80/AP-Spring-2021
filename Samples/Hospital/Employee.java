public class Employee extends Worker
{
    private Field field;
    private int workedHour;

    public Employee(String firstName, String lastName, String phone, String address, Field field)
    {
        super(firstName, lastName, phone, address);
        this.field = field;
        this.workedHour = 0;
    }

    public Field getField()
    {
        return field;
    }

    public void setField(Field field)
    {
        this.field = field;
    }

    public int getWorkedHour()
    {
        return workedHour;
    }

    public void setWorkedHour(int workedHour)
    {
        this.workedHour = workedHour;
    }

    @Override
    public void IncreaseSalary()
    {
        if(workedHour == 600)
        {
            super.setSalary(super.getSalary() + 100);
            workedHour = 0;
        }

    }

    @Override
    public String printInfo()
    {
        return "employee -> Full name: " +
                getFirstName() + " " + getLastName() +
                "Phone: " + getPhone();

    }
}
