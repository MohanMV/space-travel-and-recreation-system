
/**
 * 
 *This is a tester for resort manager
 * @author (Mohankumaar Maha Veerachakkravarthi)
 * @version (28/04/2020)
 */
public class Tester
{
   public static void main(String[] args)
   {
       doTest1();
   }
   
   public static void doTest1()
   {
       ResortManager test1 = new ResortManager("Wayward");
       
       System.out.println(test1.toString()); // to test toString() method, to print world and card on each world if no card prints no card
       System.out.println(test1.getAllCardsOnEachWorld());// to test getAllCardsOnEachWorld() method, prints all cards on each world with cards
       System.out.println(test1.findCard(1000)); // to test findCard() method, prints the world name of where the card is currently in this case Home
       System.out.println(test1.getWorldNumber("Home"));// to test getWorldNumber() method, prints world no of Home which is 0
       System.out.println(test1.getAllCardsOnWorld("Home"));// to test getAllCardsOnWorld() method, prints cards currently on World Home
       System.out.println(test1.canTravel(1000,"ABC1"));// to test canTravel() method, check if card id 1000 can travel on ABC1 shuttle, in this case should return true
       System.out.println(test1.travel(1000,"ABC1"));
       
       // to test if card id 1002 can travel on shuttle with journey code CDE3, if yes print suitable messsage if not, print suitable message stating the reason
       // in this case card is not allowed to travel because it not registered on source world
       System.out.println(test1.canTravel(1002,"CDE3"));
       System.out.println(test1.travel(1002,"CDE3"));
       System.out.println(test1.getAllCardsOnEachWorld());
       
       // to test if card id 1002 can travel on shuttle with journey code ABC1, if yes print suitable messsage if not, print suitable message stating the reason,
       System.out.println(test1.canTravel(1002,"ABC1"));
       System.out.println(test1.travel(1002,"ABC1"));
       System.out.println(test1.getAllCardsOnEachWorld());
       
       // to test if card id 1002 can travel on shuttle with journey code CDE3, if yes print suitable messsage if not, print suitable message stating the reason
       System.out.println(test1.canTravel(1002,"CDE3"));
       System.out.println(test1.travel(1002,"CDE3"));
       System.out.println(test1.getAllCardsOnEachWorld());
       
       // to test if card id 1002 can travel on shuttle with journey code JKL8, if yes print suitable messsage if not, print suitable message stating the reason
       System.out.println(test1.canTravel(1002,"JKL8"));
       System.out.println(test1.travel(1002,"JKL8"));
       System.out.println(test1.getAllCardsOnEachWorld());
       
       // to test if card id 1004 can travel on shuttle with journey code ABC1, if yes print suitable messsage if not, print suitable message stating the reason
       System.out.println(test1.canTravel(1004,"ABC1"));
       System.out.println(test1.travel(1004,"ABC1"));
       System.out.println(test1.getAllCardsOnEachWorld());
       
       // to test if card id 1002 can travel on shuttle with journey code GHJ6, if yes print suitable messsage if not, print suitable message stating the reason
       // in this case, card is not allowed to travel because it has insufficient credits
       System.out.println(test1.canTravel(1004,"GHJ6"));
       System.out.println(test1.travel(1004,"GHJ6"));
       System.out.println(test1.getAllCardsOnEachWorld());
       
       // to test if card id 1002 can travel on shuttle with journey code CDE3, if yes print suitable messsage if not, print suitable message stating the reason
       // in this case card is not allowed to travel because it is not registered on source world.
       System.out.println(test1.canTravel(1002,"CDE3"));
       System.out.println(test1.travel(1002,"CDE3"));
       System.out.println(test1.getAllCardsOnEachWorld());
       
       //to test topUpCredits method and print card details, in this case add 10 credits to card id 1004
       test1.topUpCredits(1004, 10);
       System.out.println(test1.toString());
       
       //to test topUpCredits method and print card details, in this case add 5 credits to card id 1002
       test1.topUpCredits(1002, 5);
       System.out.println(test1.toString());
       
       // to test convertPoints() method, to convert loyalty points of card id 1002 to credits and print card details
       test1.convertPoints(1002);
       System.out.println(test1.toString());
       
       // to test convertPoints() method, to convert loyalty points of card id 1004 to credits and print card details
       test1.convertPoints(1004);
       System.out.println(test1.toString());
       
       // to test moveHome() method, to card id 1000 to world Home
       test1.moveHome(1000);
       System.out.println(test1.toString());
       
       // to test evacuateAll() method, moves all cards back to home
       test1.evacuateAll();
       System.out.println(test1.toString());
       
       //I have tested this individually and it works
       //however when testing all at once the console doesnt seem to fit
       //everything thats meant to print.
   }
}
