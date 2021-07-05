
/**
 * Write a description of class Demo here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Demo
{
    public static void main(String[] args)
    {
        //task 2.1
        ResortManager planet = new ResortManager("Jupiter");
        // task 2.2
        System.out.println(planet.toString());
        // task 2.3 
        //a
        System.out.println(planet.canTravel(1008,"ABC1"));
        System.out.println(planet.travel(1000,"ABC1"));
        System.out.println(planet.getAllCardsOnEachWorld());
        //b
        System.out.println(planet.canTravel(1008,"CDE3"));
        System.out.println(planet.travel(1008,"CDE3"));
        System.out.println(planet.getAllCardsOnEachWorld());
        //c
        System.out.println(planet.canTravel(1005,"ABC1"));
        System.out.println(planet.travel(1005,"ABC1"));
        System.out.println(planet.getAllCardsOnEachWorld());
        //d
        //move 1001 from home to sprite
        System.out.println(planet.canTravel(1001,"ABC1"));
        System.out.println(planet.travel(1001,"ABC1"));
        //move 1001 from sprite to solo
        System.out.println(planet.canTravel(1001,"GHJ6"));
        System.out.println(planet.travel(1001,"GHJ6"));
        System.out.println(planet.getAllCardsOnEachWorld());
        //e
        // move 1003 from home to sprite
        System.out.println(planet.canTravel(1003,"ABC1"));
        System.out.println(planet.travel(1003,"ABC1"));
        //move 1003 from sprite to tropicana
        System.out.println(planet.canTravel(1003,"CDE3"));
        System.out.println(planet.travel(1003,"CDE3"));
        System.out.println(planet.getAllCardsOnEachWorld());
        //f
        System.out.println(planet.canTravel(1005,"GHJ6"));
        System.out.println(planet.travel(1005,"GHJ6"));
        System.out.println(planet.getAllCardsOnEachWorld());
        //2.4
        //a
        System.out.println(planet.getAllCardsOnEachWorld());
        //b
        System.out.println(planet.findCard(1008));
        //c
        System.out.println(planet.canTravel(1005, "CDE3"));

    }
}
