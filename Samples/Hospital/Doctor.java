import java.util.HashSet;
import java.util.Iterator;

public class Doctor extends Worker
{

    private HashSet<Patient> patients;
    private int visitedPatientNum;

    public Doctor(String firstName, String lastName, String phone, String address)
    {
        super(firstName, lastName, phone, address);
        patients = new HashSet<>();
        this.visitedPatientNum = 0;
    }

    @Override
    public void IncreaseSalary()
    {
        if(visitedPatientNum == 100)
        {
            super.setSalary(super.getSalary() + 100);
            visitedPatientNum = 0;
        }
    }

    public void addPatient(Patient patient)
    {
        patients.add(patient);
    }

    public HashSet<Patient> getPatients()
    {
        return patients;
    }

    public void setPatients(HashSet<Patient> patients)
    {
        this.patients = patients;
    }

    public int getVisitedPatientNum()
    {
        return visitedPatientNum;
    }

    public void setVisitedPatientNum(int visitedPatientNum)
    {
        this.visitedPatientNum = visitedPatientNum;
    }

    public void PrintPatients()
    {
        Iterator<Patient> it = patients.iterator();
        while(it.hasNext())
        {
            Patient patient = it.next();
            System.out.println(patient.toString());
        }
    }

    @Override
    public String printInfo()
    {
        return "Doctor -> Full name: " +
                getFirstName() + " " + getLastName() +
                "Phone: " + getPhone();
    }
}
