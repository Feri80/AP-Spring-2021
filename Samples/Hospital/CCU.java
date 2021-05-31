import java.util.ArrayList;

public class CCU extends Room
{

    private ArrayList<Patient> patients;

    public CCU(int code)
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
        return "CCU-" + super.getCode();
    }
}
