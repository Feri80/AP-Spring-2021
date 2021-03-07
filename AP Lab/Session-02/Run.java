public class Run 
{


    public static void main(String[] args)
    {
        Student std1 = new Student("Farhad", "Aman", "9931006");
        Student std2 = new Student("Ali", "Mohammadi", "0031006");
        std1.setGrade(18.25);
        std2.setGrade(16.75);

        Lab ap = new Lab(10, "Sat");
        ap.enrollStudent(std1);
        ap.enrollStudent(std2);
        
        ap.calcAvg();
        System.out.println("\n" + ap.getAvg() + "\n");


        Department ce = new Department("CE", 10);

        ce.addLab(ap);

        ce.print();
    }
}
