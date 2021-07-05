
/** 
 * The card class is used to store information about a patient including CardID, Name, luxuring rating, credits and loyalty points.
 * The constructor for this class uses appropriate paramters to set field values and sets loyalty points to zero.
 * @author (Mohankumaar Maha Veerachakkravarthi)
 * @version (27/04/2020)
 */
public class Card
{
    // instance variables used to hold information
    private int cardID;
    private String name;
    private int luxuryrating;
    private int credits;
    private int loyaltypoints;
     
    /**
     * Constructor for objects of class Card
     */
    public Card(int CardID, String Name, int LuxuryRating, int Credits)
    {
        cardID = CardID;
        name = Name;
        luxuryrating = LuxuryRating;
        credits = Credits;
        loyaltypoints = 0;
    }
   
    /**
     * Returns card's luxury rating
     * @return luxury rating
     */
    public int CLuxuryRating()
    {
        return luxuryrating;
    }
    
 
    /**
     * Returns card's credits
     * 
     * @return credits
     */
    public int CCredits()
    {
         return credits;
    }
    
    /**
     * tops up credits
     * @param the value intended to add to credits
     */
    public void ChangeCredits(int x)
    {
        credits += x;
    }

    /**
     * converts loyalty points to credits by first checking if loyalty points is sufficient
     * then add the value of loyalty points divided by 4 to credits(4 loyalty points = 1 credits)
     * using modulus to change current loyalty points to the remainder to loyalty points 
     */
    public void ConvertLPointsToCredits()
    {
        if(loyaltypoints>3){
            credits += loyaltypoints/4;
            loyaltypoints = loyaltypoints % 4;
           
        }
    }
    
    /**
     * changes to card's credits and loyalty points after every journey made
     * add 2 loyalty points and deduct 3 credits
     */
    public void ChangesAfterJourney()
    {
        credits += (-3);
        loyaltypoints += 2;
    }
    
    /**
     * Checks if the card's credits is higher or equal to the cost of a journey
     * 
     * @param int value of the cost of a journey
     * @return true or false depending on the condition is met ot not
     */
    public boolean CheckShuttleJourney(int CostOfJourney)
    {
        if(credits >= CostOfJourney){
            return true;
        }
        else
        {
            return false;
        }
    }
    
    /**
   `  * checks if the paramter is the same as the card ID is same return true else return false
     */
    public boolean CheckCardID(int p)
    {
        if(cardID == p){
            return true;
        }
        else
        {
            return false;
        }
    }
    
    /**
     * Returns cardID
     * @return    Card ID
     */
    public int getCardID()
    {
        return cardID;
    }
    
    /** Returns a String representation of the card information
     *  @return the card information as a String
     */ 
    public String toString()
    {
       String info ="Card ID: "+cardID+", Name: "+name+", Rating: "+luxuryrating+", Credits: "+credits+", Loyalty Points: "+loyaltypoints+"\n";
       return info;    
    }
}
