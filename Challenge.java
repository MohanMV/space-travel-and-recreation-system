
/**
 * Write a description of class Challenge here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Challenge
{
    // instance variables - replace the example below with your own
    private int number;
    private float distance;
    private String method;
    private int doneBy;
    private boolean available;

    /**
     * Constructor for objects of class Challenge
     */
    public Challenge(int no, float dist, String Method)
    {
        number = no;
        distance = dist;
        method = Method;
        doneBy = 0;
        available = true;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void addDone(int x)
    {
        doneBy += x;
    }
    
    public float getDistance()
    {   
        distance = distance/1000;
        return distance;
    }
    
    public String toString()
    {
       String ChalInfo ="Number: "+number+", Distance: "+distance+", Method: "+method+", Done By: "+doneBy+", Available: "+available+"\n";
       return ChalInfo;    
    }
    
}
