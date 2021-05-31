import java.util.ArrayList;

public class Main
{
    public static void main(String[] args)
    {

        Hospital hospital = new Hospital("Bahman");
        Doctor d1 = new Doctor("faraz", "farangizadeh", "09121231002", "Tehran");
        Doctor d2 = new Doctor("d1_firstName", "d1_lastName", "09102000278", "d1_address");
        Patient patient1 = new Patient("p1_firstName", "p1_lastName", "012345678","p1_address", Insurance.SocialSecurity,d1);
        Patient patient2 = new Patient("p2_firstName", "p2_lastName", "091539608","p2_address", Insurance.ArmedForcedServices,d1);
        Patient patient3 = new Patient("p3_firstName", "p3_lastName", "091323802","p3_address", Insurance.none,d2);

        /////////////////////////// Polymorphism ///////////////////////////////////
//
//      Person person = new Person("firstName", "lastname","094538829","address");

        Person doctor_in_person = d1;
        Person patient_in_person = patient1;
//
        Worker doctor_in_worker = d1;
//        Worker worker2 = patient1;
//
        hospital.addWorker(d2);
        hospital.addWorker(doctor_in_worker);

//        hospital.addWorker(doctor_in_person);
//
        hospital.addPatient(patient2);

//        hospital.addPatient(patient_in_person);

        hospital.addPatient((Patient)patient_in_person);
        hospital.addPatient(patient3);


        /////////////////////////////////// using printable ///////////////////////////////////////
        ArrayList<Object> objects = new ArrayList();
        objects.add(d1); objects.add(d2); objects.add(patient1); objects.add(patient2); objects.add(patient3);
        objects.add(22); objects.add("random string"); objects.add(hospital);
        for (Object obj :objects)
        {
            if (obj instanceof Printable)
                System.out.println(((Printable)obj).printInfo());
                // but not  (  obj.printInfo()  );
        }


//        for(Worker worker: hospital.getWorkers())
//            System.out.println(worker.printInfo());
    }

}
