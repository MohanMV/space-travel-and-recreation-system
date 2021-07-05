    import java.util.*;
    import java.util.ArrayList;
    /**This class implements Cwk 2
     *
     * @author Mohankumaar Maha Veerachakkravarthi 
     * @version 27/04/2020
     **/
    public class ResortManager 
    {
       //ResortManager Fields 
        private String locationName; 
        private ArrayList<World>wList = new ArrayList<World>();
        private ArrayList<Shuttle>sList = new ArrayList<Shuttle>();
        private ArrayList<Card>cList = new ArrayList<Card>();
        
    
        public ResortManager (String location)
        {
            locationName = location;
            loadCards();
            loadWorlds();
            setUpShuttles();
            for(int indx=0; indx<cList.size(); indx++)
            {
                Card temp = cList.get(indx);
                wList.get(0).enter(temp);           
            }       
        }
        /**
         * Returns all of the data about all worlds including the cards
         * currently on each world, r "No cards"
         * @return all of the details of all worlds including  
         * and all cards currently on each world, or "No cards" 
         */
        public String toString()
        {
            String CW = "";
            for(int indx = 0; indx<wList.size(); indx ++)
            {
                if(wList.get(indx).CardsOnWorld() == "")
                {
                    CW += wList.get(indx).toString() + "No Cards\n\n";
                }
                else
                {
                    CW += wList.get(indx).toString()+wList.get(indx).CardsOnWorld()+"\n" ;
                }
            }
            return CW;
        }
    
        /**Returns a String representation of all the cards on all worlds, listed 
         * by world 
         * @return a String representation of all cards on all worlds
         **/
        public String getAllCardsOnEachWorld()
        {
            String CardsOnAllWorlds ="";
            for(int indx = 0; indx<wList.size(); indx ++)
            {
                if(wList.get(indx).CardsOnWorld() != "")
                {
                    CardsOnAllWorlds += wList.get(indx).toString()+wList.get(indx).CardsOnWorld()+"\n";   
                }
                else
                {
                    CardsOnAllWorlds += wList.get(indx).toString();   
                }
            }
            return CardsOnAllWorlds;
        }
        
        
        /**Returns the name of the world which contains the specified card or null
         * @param cr - the specified card
         * @return the name of the World which contains the card, or null
         **/
        public String findCard(int cr)
        {
            String WName = "";
            for(int indx=0; indx<wList.size(); indx++)
            {
                 if(wList.get(indx).IsOnWorld(cr) == true)
                 {
                     WName = wList.get(indx).getWName();
                     break;
                 }
            }
            return WName;
        }
        
        
        /** Given the name of a world, returns the world id number
         * or -1 if world does not exist
         * @param name of world
         * @return id number of world
         */
        public int getWorldNumber(String ww)
        {
            int wNo = -1;
            for (int indx=0; indx<wList.size(); indx++)
            {
                if(wList.get(indx).getWName() == ww)
                {
                    wNo = wList.get(indx).getWNo();
                    break;
                }
            }
            return wNo;
        }
        
                    
        /**Returns a String representation of all the cards on specified world
         * @return a String representation of all cards on specified world
         **/
        public String getAllCardsOnWorld(String world)
        {
            String cWList = "";
            for(int indx = 0; indx<wList.size(); indx++)
            {
                if(wList.get(indx).getWName().equals(world))
                {
                    cWList += "\n"+wList.get(indx).CardsOnWorld();
                }
            }
            return cWList;
        }
        
         /**Returns true if a Card is allowed to move using the shuttle, false otherwise
         * A move can be made if:  
         * the rating of the card  >= the rating of the destination world
         * AND the destination world is not full
         * AND the card has sufficient credits
         * AND the card is currently in the source world
         * AND the card id is for a card on the system
         * AND the shuttle code is the code for a shuttle on the system
         * @param crId is the id of the card requesting the move
         * @param shtlCode is the code of the shuttle journey by which the card wants to pCardel
         * @return true if the card is allowed on the shuttle journey, false otherwise 
         **/
        public boolean canTravel(int crId, String shtlCode)
        {
            Shuttle sInfo = getShuttle(shtlCode);
            Card cInfo = getCard(crId);
            while(sInfo != null && cInfo != null)
            {
                if (sInfo.AllowedToTravel(cInfo) == true)
                {
                    return true;
                }
                else
                {
                    return false;
                }
            }
            return false;
        }
        

        /**Returns the result of a card requesting to move by Shuttle.
         * A move will be successful if:  
         * the luxury rating of the card  >= the luxury rating of the destination world
         * AND the destination world is not full
         * AND the card has sufficient credits
         * AND the card is currently in the source world
         * AND the card id is for a card on the system
         * AND the shuttle code is the code for a shuttle on the system
         * If the shuttle journey can be made, the card information is removed from the source
         * world, added to the destination world and a suitable message returned.
         * If shuttle journey cannot be made, the state of the system remains unchanged
         * and a message specifying the reason is returned.
         * @param pCardId is the id of the card requesting the move
         * @param shtlCode is the code of the shuttle journey by which the card wants to pCardel
         * @return a String giving the result of the request 
         **/
        public String travel(int pCardId, String shtlCode )
        {
            Card cInfo = getCard(pCardId);
            Shuttle sInfo = getShuttle(shtlCode);
            if(canTravel(pCardId, shtlCode) == true)
            {
                return sInfo.ModifyDetails(cInfo);
            } 
            else if(sInfo == null)
            {
                return "Shuttle Code not registered";
            }
            else if(cInfo == null)
            {
                return "Card ID not registered";
            }
            else
            {  
                return sInfo.ModifyDetails(cInfo);
            }
        }
    
     
        // These methods are for Task 6 only and not required for the Demonstration 
        // If you choose to implement them, uncomment the following code    
         /** Allows a card to top up their credits.This method is not concerned with 
         // *  the cost of a credit as currency and prices may vary between resorts.
         // *  @param id the id of the card toping up their credits
         // *  @param creds the number of credits purchased to be added to cards information
         // */
         public void topUpCredits(int id, int creds)
         {
             getCard(id).ChangeCredits(creds);
         }
    
         /** Moves a card directly back to the home world without affecting credits
         // *  and not using existing shuttles
         // */
         public void moveHome(int id)
         {
             for(int indx = 0; indx<wList.size(); indx++)
             {
                 if(wList.get(indx).IsOnWorld(id) == true)
                 {
                     wList.get(indx).leave(id);
                     wList.get(0).enter(getCard(id));
                 }
             }
         }
  
         /** Converts a card's loyalty points into credits
         // * @param tr the id of the card whose points are to be converted
         // */
         public void convertPoints(int id)
         {
             getCard(id).ConvertLPointsToCredits();
         }
    
         /** In an emergency, evacuates all cards directly back to the home world without 
         // * affecting credits or other information and not using existing shuttles
         // */
         public void evacuateAll()
         { 
             for(int indx = 0; indx<wList.size(); indx++)
             {
                 for(int j= 0;  j<cList.size(); j++)
                 {
                     if(wList.get(indx).IsOnWorld(cList.get(j).getCardID()) == true)
                     {
                     wList.get(indx).leave(cList.get(j).getCardID());
                     wList.get(0).enter(cList.get(j));
                    }
                 }
             }
             
         }
    
   
    
    
    //***************private methods**************
    // create all cards in Appendix A and addthem to their collection
        private void loadCards()
        {
            Card c1 = new Card(1000, "Lynn", 5, 10);
            Card c2 = new Card(1001, "May", 3, 30);
            Card c3 = new Card(1002, "Nils", 10, 25);
            Card c4 = new Card(1003, "Olek", 2,12);
            Card c5 = new Card(1004, "Pan", 3, 3);
            Card c6 = new Card(1005, "Quin", 1, 30);
            Card c7 = new Card(1006, "Raj", 10, 6);
            Card c8 = new Card(1007, "Sol", 7, 20);
            Card c9 = new Card(1008, "Tel", 6, 30);
            Card c10 = new Card(8765, "Tom", 5, 8);
           
            cList.add(c1);
            cList.add(c2);
            cList.add(c3);
            cList.add(c4);
            cList.add(c5);
            cList.add(c6);
            cList.add(c7);
            cList.add(c8);
            cList.add(c9);
            cList.add(c10);
        }
        
        // create all worlds in Appendix A and addthem to their collection
        private void loadWorlds()
        {
            World w1 = new World(0, "Home", 0, 1000);
            World w2 = new World(1, "Sprite", 1, 100);
            World w3 = new World(2, "Tropicana", 3, 10);
            World w4 = new World(3, "Fantasia", 5, 2);
            World w5 = new World(4, "Solo", 1, 1);
            World w6 = new World(5, "Cola", 6, 10);
            
            wList.add(w1);
            wList.add(w2);
            wList.add(w3);
            wList.add(w4);
            wList.add(w5);
            wList.add(w6);
        }
        
        // create all shuttles in Appendix A and addthem to their collection
        private void setUpShuttles()
        {
            Shuttle s1 = new Shuttle("ABC1", wList.get(0), wList.get(1));
            Shuttle s2 = new Shuttle("BCD2", wList.get(1), wList.get(0));
            Shuttle s3 = new Shuttle("CDE3", wList.get(1), wList.get(2));
            Shuttle s4 = new Shuttle("DEF4", wList.get(2), wList.get(1));
            Shuttle s5 = new Shuttle("EFG5", wList.get(3), wList.get(1));
            Shuttle s6 = new Shuttle("GHJ6", wList.get(1), wList.get(4));
            Shuttle s7 = new Shuttle("HJK7 ", wList.get(4), wList.get(1));
            Shuttle s8 = new Shuttle("JKL8", wList.get(2), wList.get(3));
            Shuttle s9 = new Shuttle("YYY", wList.get(3), wList.get(6));
            Shuttle s10 = new Shuttle("ZZZ", wList.get(6), wList.get(3));
            
            sList.add(s1);
            sList.add(s2);
            sList.add(s3);
            sList.add(s4);
            sList.add(s5);
            sList.add(s6);
            sList.add(s7);
            sList.add(s8);
            sList.add(s9);
            sList.add(s10);
        }
        
        
     
        /** Returns the card with the card id specified by the parameter      
         * @return the card with the specified name
        **/
        private Card getCard(int id)
        {
             for(int indx = 0; indx<cList.size(); indx ++)
             {
                 if(cList.get(indx).getCardID() == id)
                 {  
                     return cList.get(indx);
                 }
             }
             return null;
        }
         
         /** Returns the world with the name specified by the parameter
          * @return the world with the specified name
          **/
        private World getWorld(String worldName)
        {            
             for(int indx = 0; indx<wList.size(); indx ++)
             {
                 if(wList.get(indx).getWName().equals(worldName))
                 {  
                     return wList.get(indx);
                 }
             }
             return null;
        }
         
         /** Returns the world with the name specified by the parameter
          * @return the world with the specified name
         **/
        private Shuttle getShuttle(String shut)
        {
             for(int indx = 0; indx<sList.size(); indx ++)
             {
                 if(sList.get(indx).getShuttleID().equals(shut))
                 {
                     return sList.get(indx);
                 }
             }
             return null;
        }
    }