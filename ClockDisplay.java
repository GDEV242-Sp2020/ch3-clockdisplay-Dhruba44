
/**
 * The ClockDisplay class implements a digital clock display for a
 * European-style 24 hour clock. The clock shows hours and minutes. The 
 * range of the clock is 00:00 (midnight) to 23:59 (one minute before 
 * midnight).
 * 
 * The clock display receives "ticks" (via the timeTick method) every minute
 * and reacts by incrementing the display. This is done in the usual clock
 * fashion: the hour increments when the minutes roll over to zero.
 * 
 * This is meant for 12hoursInternal - Again 12hoursInternal
 * @Dhruba Dey
 * @version 02/14/2020
 */

import java.io.*;

public class ClockDisplay
{
    private NumberDisplay hours;
    private NumberDisplay minutes;
    private String ampm;
    private String displayString;    // simulates the actual display
    
    
    /**
     * Constructor for ClockDisplay objects. This constructor
     * creates a new clock set at the time specified by the 
     * parameters.
     * Turn the clock for 12 hours only
     * Added one additional parameter for AM or PM
     */
    public ClockDisplay(int hour, int minute,String amOrpm)
    {
        hours = new NumberDisplay(12);
        minutes = new NumberDisplay(60);
        ampm = amOrpm;
        setTime(hour, minute);
    }

    /**
     * This method should get called once every minute - it makes
     * the clock display go one minute forward.
     */
    public void timeTick()
    {
        this.minutes.increment();
        if(this.minutes.getValue() == 0) {  // it just rolled over!
            this.hours.increment();
        }
        updateDisplay();
    }

    /**
     * Set the time of the display to the specified hour and
     * minute.
     */
    public void setTime(int hour, int minute)
    {
        this.hours.setValue(hour);
        this.minutes.setValue(minute);
        updateDisplay();
    }

    /**
     * Return the current time of this display in the format HH:MM.
     */
    public String getTime()
    {
        return displayString;
    }
    
    /**
     * Update the internal string that represents the display.
     */
    private void updateDisplay()
    {
        //Get the current hour
        int currHour = hours.getValue();
        // check the condition for am or pm
        if (currHour >= 12 && this.ampm.toLowerString = "am") {
            ampm = "pm";
            currHour = 0;
        }
        
        if (currHour >= 12 && this.ampm.toLowerString = "pm") {
            ampm = "am";
            currHour = 0;
        }
        
        displayString = currHour + ampm + ":" + 
                        minutes.getDisplayValue();
    }
}
