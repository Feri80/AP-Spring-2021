
public class LeapYear2 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        IsLeapYear(1397);
        IsLeapYear(1398);
        IsLeapYear(1399);
    }

    static void IsLeapYear(int year) {
        int remainder = year % 33;
        switch (remainder) {
        case 1:
        case 5:
        case 9:
        case 13:
        case 17:
        case 22:
        case 26:
        case 30:
            System.out.println(year + " is a leap year!");
            break;
        default:
            System.out.println(year + " is not a leap year.");
        }
    }

}
