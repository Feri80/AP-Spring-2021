import java.util.ArrayList;

public class ICU extends Room
{

    private ArrayList<Patient> patients;

    public ICU(int code)
    {
        super(code);
        patients = new ArrayList<>();
    }

    public ArrayList<Patient> getPatients()
    {
        return patients;
    }

    public void AddPatients(Patient patient)
    {
        patients.add(patient);
    }

    @Override
    public String printInfo()
    {
        return "ICU-" + super.getCode();
    }
}
