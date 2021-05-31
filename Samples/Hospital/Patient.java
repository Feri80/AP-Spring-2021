public class Patient extends Person
{

    private Insurance insurance;
    private Doctor doctor;
    public Patient(String firstName, String lastName, String phone, String address, Insurance insurance, Doctor doctor)
    {
        super(firstName, lastName, phone, address);
        this.insurance = insurance;
        this.doctor = doctor;
    }

    public Insurance getInsurance()
    {
        return insurance;
    }

    public void setInsurance(Insurance insurance)
    {
        this.insurance = insurance;
    }

    public Doctor getDoctor()
    {
        return doctor;
    }

    public void setDoctor(Doctor doctor)
    {
        this.doctor = doctor;
    }

    @Override
    public String printInfo()
    {
        return "Patient -> Full name: " +
                getFirstName() + " " + getLastName() +
                "Phone: " + getPhone();
    }
}
