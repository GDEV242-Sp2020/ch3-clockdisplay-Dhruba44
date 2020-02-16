
/**
 * This 12 hours clock which is designed to show 1 to 12 for am and pm. 
 * The limit is set at 13 hours so that 12 can be displayed when the clock is ticked from am to pm or vice versa. 
 * However, the clocked will be set to 1 hour when it is ticked from 12:59 keeping am and pm intact.
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
import java.lang.*;

public class ClockDisplay
{
    private NumberDisplay hours;
    private NumberDisplay minutes;
    private String ampm;             // Added field to AM/PM value
    private String displayString;    // simulates the actual display
    
    
    /**
     * Constructor for ClockDisplay objects. This constructor
     * creates a new clock set at the time specified by the 
     * parameters.
     * Turn the clock for 12 hours only
     * Added one additional parameter for AM or PM
     */
    public ClockDisplay(int hour, int minute,String amOrPM)
    {
        hours = new NumberDisplay(12);
        minutes = new NumberDisplay(60);
        this.ampm = amOrPM;
        setTime(hour, minute,this.ampm);
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
    public void setTime(int hour, int minute,String amOrPM)
    {
        this.hours.setValue(hour);
        this.minutes.setValue(minute);
        this.ampm = amOrPM;
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
     * This 12 hours clock which is designed to show 1 to 12 for am and pm. 
     * The limit is set at 13 hours so that 12 can be displayed when the clock is ticked from am to pm or vice versa. 
     * However, the clocked will be set to 1 hour when it is ticked from 12:59 keeping am and pm intact.
     */
    private void updateDisplay()
    {
        //Get the current hour
        int currHour = hours.getValue();
        int currMinute = minutes.getValue();
        String displayString1;// intermediate string for displaying time without leading zero
        String ampm1; // local field to store intermediate value for displaying
        // check the condition for am or pm               
        if (this.ampm.toLowerCase().equals ("am") && currHour == 0 && currMinute == 0) {
            this.ampm = "pm";
        }  
        
        ampm1 = this.ampm;
        //System.out.println(this.ampm); // this is for debugging
                        
         if (this.ampm.toLowerCase().equals ("pm") && currHour == 0 && currMinute == 0) {
            this.ampm = "am";
        }         
        
        // System.out.println(this.ampm); // this is for debugging
        
        if(currHour == 0){
           currHour = 12;        
           displayString1 = currHour + ":" + minutes.getDisplayValue()+ " " + ampm1.toLowerCase();
        }else {
           displayString1 = currHour + ":" + minutes.getDisplayValue() + " " +this.ampm.toLowerCase();
        }
              
        //System.out.println(displayString1); // this is for debuggin
        
        // Add the leading zero when the hour is single digit
        
        if(currHour <10){
            displayString = "0" + displayString1;
            
        }  else{
            displayString = displayString1;
        }
        
        //System.out.println(displayString);// this is for debugging
    }
}

