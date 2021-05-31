public abstract class Worker extends Person
{
    private int salary;
    public Worker(String firstName, String lastName, String phone, String address)
    {
        super(firstName, lastName, phone, address);
    }

    public int getSalary()
    {
        return salary;
    }

    public void setSalary(int salary)
    {
        this.salary = salary;
    }

    public abstract void IncreaseSalary();
}
