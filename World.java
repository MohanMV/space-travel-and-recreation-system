import java.util.ArrayList;
/**
 * Used to store information about world which includes world no, world name, world rating, world capacity and and a collection of cards currently on that world
 *
 * @author (Mohankumaar Maha Veerachakkravarthi)
 * @version (27/04/2020)
 */
public class World
{
    // instance variables 
    private int number;
    private String name;
    private int rating;
    private int capacity;
    private ArrayList<Card>cardList;
    
    /**
     * Constructor for objects of class World
     */
    public World(int Number, String Name, int Rating, int Capacity)
    {
        // initialise instance variables
        number = Number;
        name = Name;
        rating = Rating;
        capacity = Capacity;
        cardList = new ArrayList<Card>(); //call ArrayList to constructor
    }

    /**
     * Return int value of world rating
     * 
     * @return   world rating
     */
    public int WRating()
    {
        return rating;
    }
    
    /**
     * Return string value of world name
     * 
     * @return  world name
     */
    public String getWName()
    {
        return name;
    }
    
    /**
     * Return int value of world number
     * 
     * @return   world number
     */
    public int getWNo()
    {
        return number;
    }
    
    /**
     * adds a card object to card collection 
     * @param object of card class
     */
    public void enter(Card c)
    {
        cardList.add(c);        
    }
    
    /**
     * Removes a card from the card collection by using findCard method to get the card object 
     *
     * @param  int value of card id
     */
    public void leave(int cNo)
    {
        if (findCard(cNo) != null)
        {
            cardList.remove(findCard(cNo));
        }
    }
    
    /**
     * uses the parameter inputted to find a card in the card collection
     *
     * @param int value of card it
     * @return   Card object
     */
    public Card findCard(int cNo)
    {
        for(int indx=0; indx<cardList.size(); indx++)
        {
            if (cardList.get(indx).getCardID() == cNo)
            {
                return cardList.get(indx);
            }
        }
        return null;
    }
    
    /**
     *Checks if the capacity of a world is full or not by comparing the size of the card collection in that world to the capacity of the world
     * if number of card on world lesser than capacity return true else return false
    */
    public boolean CheckCapacity()
    {
        if(cardList.size() < capacity)
        {
            return true; 
        }
        else
        {
            return false;
        }
    }
    
    /**
     *Checks if a card is on a world
     * return true of card is on world else return false
     * @param int value of card id
    */
    public boolean IsOnWorld(int cID)
    {
        for(int indx=0; indx<cardList.size(); indx++)
        {
            if(cardList.get(indx).getCardID() == cID)
            {
                return true;
            }
        }
        return false;
    }
    
    /**
     * returns a string representation of all card on a world
    */
    public String CardsOnWorld()
    {
        String CardList = "";
        if (cardList.size() >0)
        {
            for(int indx = 0; indx<cardList.size(); indx++)
            {
                CardList += cardList.get(indx).toString();
            }
        }
        return CardList;
    }
    
    /** Returns a String representation of the world information
     *  @return the world information as a String
     */ 
    public String toString()
    {
        String info = "World Number: "+number+", World Name: "+name+", Rating: "+rating+", Capacity: "+capacity+"\n";
        return info;    
    }
        
}
