import java.util.ArrayList;

public class Hospital
{
    private String name;
    private ArrayList<Worker> workers;
    private ArrayList<Patient> patients;
    private ArrayList<Room> rooms;

    public Hospital(String name)
    {
        this.name = name;
        workers = new ArrayList<>();
        patients = new ArrayList<>();
        rooms = new ArrayList<>();
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public ArrayList<Worker> getWorkers()
    {
        return workers;
    }

    public void addWorker(Worker worker)
    {
        workers.add(worker);
    }

    public ArrayList<Patient> getPatients()
    {
        return patients;
    }

    public void addPatient(Patient patient)
    {
        patients.add(patient);
    }

    public ArrayList<Room> getRooms()
    {
        return rooms;
    }

    public void addRoom(Room room)
    {
        rooms.add(room);
    }
}
