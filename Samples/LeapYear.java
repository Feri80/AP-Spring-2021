
public class LeapYear {

    public static void main(String[] args) {

        int year = 1397;
        int remainder = year % 33;
        if (remainder == 1 || remainder == 5 || remainder == 9 || remainder == 13 || remainder == 17 || remainder == 22
                || remainder == 26 || remainder == 30) {
            System.out.println("Leap year!");
        } else {
            System.out.println("Not a leap year.");
        }
    }

}
