
/**
 * Write a description of class CardTester here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CardTester
{
     /**
     * Constructor for objects of class CardTester
     */
    public static void main(String[] args)
    {
        Card card1 = new Card(1, "Amy", 4, 5); // creating a new class obj  ect
        Card card2 = new Card(2, "Kane", 3, 15); // creating another class object
        Card card3 = new Card(3, "Cena", 7, 4); // creating another class object
        Card card4 = new Card(4, "Potter", 2, 20);// creating another class object
        
        //prints details of all cards
        System.out.println(card1.toString());
        System.out.println(card2.toString());
        System.out.println(card3.toString());
        System.out.println(card4.toString());
        
        card1.ChangeCredits(-5); // deducting 5 credits from card1
        card2.ConvertLPointsToCredits(); // converting loyalty points to credits for card2
        card3.ChangesAfterJourney(); // make changes to credits and loyalty points to card3
        
        //print card details to see changes
        System.out.println(card1.toString());
        System.out.println(card2.toString());
        System.out.println(card3.toString());
        
        //this gets the credit value of card4 and prints it out
        System.out.println(card4.CCredits());
    }
}
