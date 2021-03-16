package edu.amirkabir.ap.Clock;

public class ClockDisplaySimple {
    private NumberDisplay hours;
    private NumberDisplay minutes;
    private String displayString; // simulates the actual display

    /**
     * Constructor for ClockDisplay objects. This constructor creates a new clock
     * set at 00:00.
     */
    public ClockDisplaySimple() {
        hours = new NumberDisplay(24);
        minutes = new NumberDisplay(60);
        updateDisplay();
    }

    /**
     * Constructor for ClockDisplay objects. This constructor creates a new clock
     * set at the time specified by the parameters.
     */
    public ClockDisplaySimple(int hour, int minute) {
        hours = new NumberDisplay(24);
        minutes = new NumberDisplay(60);
        setTime(hour, minute);
        updateDisplay();
    }

    /**
     * This method should get called once every minute - it makes the clock display
     * go one minute forward.
     */
    public void timeTick() {

        minutes.increment();    // External method call
        if (minutes.getValue() == 0) { // it just rolled over!
            hours.increment();
        }

        updateDisplay();        // Internal method call
    }

    /**
     * Set the time of the display to the specified hour and minute.
     */
    public void setTime(int hour, int minute) {
        hours.setValue(hour);
        minutes.setValue(minute);  // External method call
        updateDisplay();           // Internal method call
    }

    /**
     * Return the current time of this display in the format HH:MM.
     */
    public String getTime() {
        return displayString;
    }

    /**
     * Update the internal string that represents the display.
     */
    private void updateDisplay() {
        displayString = hours.getDisplayValue() + ":" + minutes.getDisplayValue();
    }

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
