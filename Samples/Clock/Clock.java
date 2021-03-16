package edu.amirkabir.ap.Clock;

public class Clock {

    private int min;
    private int hour;

    public Clock() {
        min = 0;
        hour = 0;
    }

    public Clock(int minValue, int hourValue) {
        min = minValue;
        hour = hourValue;
    }

    public void incrementMin() {
        min += 1;
        if (min == 60) {
            min = 0;
            hour += 1;
            if (hour == 12) {
                hour = 0;
            }
        }
    }

    public void displayTime() {
//        System.out.println(hour + ":" + min);
//        System.out.println((hour < 10 ? ("0" + hour) : hour) + ":" + (min < 10 ? ("0" + min) : min));
        System.out.println(String.format("%02d", hour) + ":" + String.format("%02d", min));
    }
//}
    
    
    
    
    
    
    public static void main(String[] args) {

        Clock ourClock = new Clock();
        ourClock.displayTime();
        ourClock.incrementMin();
        ourClock.displayTime();

        for (int j = 0; j < 13; j++) {
            for (int i = 0; i < 58; i++) {
                ourClock.incrementMin();
            }
            ourClock.displayTime();
            ourClock.incrementMin();
            ourClock.displayTime();
            ourClock.incrementMin();
            ourClock.displayTime();
        }

    }

}
