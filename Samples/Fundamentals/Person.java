
public class Person {
    private String name;
    private int ageOfPerson;
    
    public Person(String personName, int howOld) {
        name = personName;
        ageOfPerson = howOld;
    }
    
    public String getName() {
        return name;
    }
    
    public int getAge() {
        return ageOfPerson;
    }
}
