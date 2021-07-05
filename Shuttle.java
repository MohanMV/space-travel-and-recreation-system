import java.util.ArrayList;

/**
 * Used to store information about Shuttles which includes journey codes, source world and destination world
 * Has methods that update details on world and card if a journey is made
 * @author (Mohankumaar Maha Veerachakkravarthi)
 * @version (27/04/2020)
 */

public class Shuttle
{
    // instance variables
    private String journeyCode;
    private World sourceWorld;
    private World destinationWorld;
       
    /**
     * Constructor for objects of class Shuttle
    */
    public Shuttle(String JourneyCode, World SourceWorld, World DestinationWorld)
    {
        journeyCode = JourneyCode;
        sourceWorld = SourceWorld;
        destinationWorld = DestinationWorld;
    }
    
    /**
     * Return string value journey code
     * @return  journey code
     */
    public String getShuttleID()
    {
        return journeyCode;
    }
    

    /**
     * To check if a card is allowed to travel
     *
     * @param  Card object
     * @return    true if all conditions are met else return false;
     */
    public boolean AllowedToTravel(Card c)
    {
        if(c.CLuxuryRating() >= destinationWorld.WRating() && c.CheckShuttleJourney(3) == true && destinationWorld.CheckCapacity() == true && sourceWorld.IsOnWorld(c.getCardID()) == true)   
        {
            return true;
        } 
        else
        {
            return false;
        }
    }  
    
    /**
     * Makes appropriate changes to card details and world if a card(parameter) is allowed to travel 
     * and returns a suitable message stating changes have been made.
     * or returns suitable message is card(parameter) is not allowed to travel
     * @param Card object
     * @return String message 
     */
    public String ModifyDetails(Card c)
    {
        if(AllowedToTravel(c) == true) 
        {
           c.ChangesAfterJourney();
           sourceWorld.leave(c.getCardID());
           destinationWorld.enter(c);
           return "Allowed to travel. Card details updated\n";
        }
        else
        {
            String Message = "";
            if (c.CLuxuryRating() < destinationWorld.WRating())
            {
                Message = "Not allowed to travel. Luxury Rating is insufficient.\n";
            }
            else if(c.CheckShuttleJourney(3) == false)
            {
                Message = "Not allowed to travel. Insufficient credits\n";
            }
            else if(destinationWorld.CheckCapacity() == false)
            {
                Message = "Not allowed to travel. Destination World has reached full capacity\n";
            }
            else if(sourceWorld.IsOnWorld(c.getCardID()) == false)
            {
                Message = "Not allowed to travel. This card is not registered on source world\n";
            }
            return Message;
        }
    }
    
    
    /** Returns a String representation of the Shuttle information
     *  @return the shuttle information as a String
     */ 
    public String toString()
    {
       String info = "Journey Code: "+journeyCode+"\nSource World: "+sourceWorld+"Destination World: "+destinationWorld;
       return info;    
    }
        
}
