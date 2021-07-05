import java.util.*;
/**
 * Write a description of class ResortUI here.
 * 
 * @author (Mohankumaar Maha Veerachakkravarthi) 
 * @version (27/04/2020)
 */
public class ResortUI
{
    // resort UI fields, create and instance of resortmanager called wayward
    private Scanner reader = new Scanner(System.in);
    private ResortManager wayward; 
    
    public void runUI()
    {   
        wayward = new ResortManager("wayward");
        int choice = getOption();        
        while (choice != 0)
        {            
            // process choice
            if      (choice == 1){listAllWorlds();}
            else if (choice == 2){listAllCardsbyWorld();}
            else if (choice == 3){listOneWorld();}
            else if (choice == 4){findACard();}
            else if (choice == 5){tryTravel();}
            else if (choice == 6){travelNow();}
            else if (choice == 7){updateCredits();}
            else if (choice == 8){goHome();}
            else if (choice == 9){convertPts();}
            else if (choice == 10){evacuate();}
            // output menu & get choice
            choice = getOption();
        }
        System.out.println("\nThank-you");
    }
    
    /** get input from user and store it in variable option
     * return variable option
     * 
     */
    private int getOption()
    {
       System.out.println("What would you like to do ?");
       System.out.println("0. Quit");
       System.out.println("1. List all world details");
       System.out.println("2. List all cards on each worlds");
       System.out.println("3. List all cards on one world");
       System.out.println("4. Find a card");
       System.out.println("5. Say if card can move by shuttle");
       System.out.println("6. Move a card by shuttle");
       System.out.println("7. Top up credits");
       System.out.println("8. Move a card to home world");
       System.out.println("9. Convert points to credits ");
       System.out.println("10. Evacuate all");

       System.out.println("Enter your choice");
       // read choice
       int option = reader.nextInt();
       reader.nextLine();
       return option;
    }
    
    // This one has been done for you 
    private void listAllWorlds()
    {
        System.out.println(wayward.toString());
    }
    
    // provide the code here
    /**
     * print all cards on all worlds by world
     */
    private void listAllCardsbyWorld()
    {
        System.out.println(wayward.getAllCardsOnEachWorld());        
    }
   
    // This one has been done for you 
    private void listOneWorld()
    {
        System.out.println("Enter name of world");
        String ww = reader.nextLine();
        System.out.println(wayward.getAllCardsOnWorld(ww));
    }
    
    // provide the code here
    /**
     * print world where card is on
     */
    private void findACard()
    {
       System.out.println("Enter Card ID");
       int cID = reader.nextInt();
       System.out.println(wayward.findCard(cID));
    }
    
    // This one has been done for you 
    private void tryTravel()
    {
        System.out.println("Enter card id");
        int trav = reader.nextInt();
        reader.nextLine();
        System.out.println("Enter shuttle code");
        String shuttle = reader.nextLine();
        System.out.println(wayward.canTravel(trav,shuttle));
    }
    
    
    // provide the code here
    /**
     * using card id and shuttle journey code inputted by user
     * call methods to make journey and print suitbale message
     */
    private void travelNow()
    {
        System.out.println("Enter card id");
        int crdID = reader.nextInt();
        reader.nextLine();
        System.out.println("Enter shuttle code");
        String shuttle = reader.nextLine();
        System.out.println(wayward.travel(crdID,shuttle));
 
    }
    
     // provide the code here if you have done Task 7
     /**
     * using input from user top up credits of specified card
     */
     private void updateCredits()
     {
        System.out.println("Enter card id");
        int crdID = reader.nextInt();
        reader.nextLine();
        System.out.println("Enter top up amount:");
        int topUp = reader.nextInt();
        wayward.topUpCredits(crdID,topUp);
        System.out.println("Card's credits updated");
     }
     
     // provide the code here
     /**
     * move card specified by user to home
     */
     private void goHome()
     {
        System.out.println("Enter card id");
        int crdID = reader.nextInt();
        wayward.moveHome(crdID);
        System.out.println("Card succesfully moved to Home World");
     }
     
     // provide the code here
     /**
     * convert loyalty points to credits of specified card
     */
     private void convertPts()
     {
        System.out.println("Enter card id");
        int crdID = reader.nextInt();
        wayward.convertPoints(crdID);
        System.out.println("Card's credits and loyalty points updated");
     }
     
     // provide the code here
     /**
     * move all cards to world "Home"
     */
     private void evacuate()
     {
         wayward.evacuateAll();
         System.out.println("All cards moved to Home");
     }
    
    
}
