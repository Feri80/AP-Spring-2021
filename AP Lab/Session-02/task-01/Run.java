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
        
        Student std3 = new Student("Amir", "Hosseini", "0031007");
        Student std4 = new Student("Mohammad", "Hasani", "0031008");
        std3.setGrade(16.50);
        std4.setGrade(15.75);

        Lab lc = new Lab(10, "Sat");
        lc.enrollStudent(std3);
        lc.enrollStudent(std4);
        lc.calcAvg();
        System.out.println("\n" + lc.getAvg() + "\n");


        Department ce = new Department("CE", 10);

        ce.addLab(ap);
        ce.addLab(lc);

        ce.print();
    }
}
