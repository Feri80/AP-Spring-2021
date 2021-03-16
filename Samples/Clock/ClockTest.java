package edu.amirkabir.ap.Clock;

public class ClockTest {
    public static void main(String[] args) {
        ClockDisplaySimple clockDisplay = new ClockDisplaySimple();
        System.out.println(clockDisplay.getTime());
        clockDisplay.timeTick();
        System.out.println(clockDisplay.getTime());

        for (int j = 0; j < 25; j++) {
            for (int k = 0; k < 60; k++) {
                System.out.println(clockDisplay.getTime());
                clockDisplay.timeTick();
            }

        }
    }
}
