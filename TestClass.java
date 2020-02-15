
/**
 * Write a description of class TestClass here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */



public class TestClass
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class TestClass
     */
    public TestClass()
    {
        
    }

    // create a method to test
    
    public void testResults()
    {
        ClockDisplay testClock = new ClockDisplay(2,2);
        
        testClock.setTime (10,35);
        System.out.println (testClock.getTime());
        
        testClock.setTime (15,35);
        System.out.println (testClock.getTime());
        
        testClock.setTime (12,00);
        System.out.println (testClock.getTime());
        
        testClock.setTime (23,59);
        System.out.println (testClock.getTime());
                
    }
}
