
/**
 * Write a description of class DemoCardTest here.
 *
 * @author (Mohankumaar Maha Veerachakkravarthi)
 * @version (a version number or a date)
 */
public class DemoCardTester
{
    public static void main(String[] args)
    {
        Card cc1 = new Card(666, "Anna", 4, 10);
        
        System.out.println("Credits of cc1 is: " + cc1.CCredits());
        cc1.ChangeCredits(-5);
        System.out.println(cc1.toString());
        
        
    }
}
