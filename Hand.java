import java.util.ArrayList;
import java.util.*;
/**
 * Write a description of class Hand here.
 * 
 * @author Mr. Gumminger
 * @version (2021)
 */
public class Hand
{
    private ArrayList<Card> myHand;
    private int[] totalNumber;
    public Hand()
    {
        myHand = new ArrayList<Card>();
        totalNumber = new int[15];
    }
    //return the top card
    public Card getCard ()
    {
        return myHand.remove(0);
    }
    //returns a copy of the card at position x, does not remove it
    public Card getCard(int x)
    {
        return myHand.get(x);
    }
    //returns the number of cards currently in the hand
    public int getHandSize()
    {
        return myHand.size();
    }
    //add a card to the hand
    public void addCard(Card c)
    {
        int i = 0;
        while(i < myHand.size() && c.getValue() > myHand.get(i).getValue())
        {
            i++;
        }
        myHand.add(i,c);
        totalNumber[c.getValue()]++;
    }
    public Card discardCard(int card)
    {
        Card i = myHand.remove(card);
        totalNumber[i.getValue()]--;
        return i;
    }
    public boolean checkRoyal()
    {
      ArrayList <Integer> cards = new ArrayList<Integer>();
        for(int i = 0; i < myHand.size(); i++)
        {
            cards.add(myHand.get(i).getValue());
        }
        for(int i = 10; i <= 14; i++)
        {
            if(cards.indexOf(i) == -1)
            {
                return false;
            }
        }
      return true;
    }
    public boolean checkFlush()
    {
        String one = myHand.get(0).getSuit();
        for(Card c : myHand)
        {
            if(!(c.getSuit().equals(one)))
            {
                return false;
            }
        }
        return true;
    }
    public boolean checkStraight()
    {
         for(int i = 0; i < myHand.size()-1; i++)
         {
             if(myHand.get(i).getValue() != myHand.get(i+1).getValue()-1)
             {
                 return false;
             }
         }
         return true;
    }
    /*# The following method is for testing purposes. It should
     * not be changed. It will compile when the totalNumber
     * instance variable has been added.
     */
    public String totalNumber()
    {
        String s = "";
        for (int i: totalNumber)
        {
            s += i;
        }
        return s;
    }
    public void printHand()
    {
        for(int i = 0; i <myHand.size(); i++)
        {
            System.out.println(i + "." + myHand.get(i));
        }
    }
    public int numberOfAKind()
    {
        int max = totalNumber[0];
        for(int i = 0; i < totalNumber.length; i++)
        {
            if(totalNumber[i] > max)
            {
                max = totalNumber[i];
            }
        }
        return max;
    }
    public boolean checkFullHouse()
    {
        if(myHand.size() != 5)
        {
            return false;
        }
        if(myHand.get(0).getRank().equals(myHand.get(1).getRank()) && myHand.get(1).getRank().equals(myHand.get(2).getRank()) && myHand.get(3).getRank().equals(myHand.get(4).getRank()))
        {
            return true;
        }
        if(myHand.get(0).getRank().equals(myHand.get(1).getRank()) && myHand.get(2).getRank().equals(myHand.get(3).getRank()) && myHand.get(3).getRank().equals(myHand.get(4).getRank()))
        {
            return true;
        }
        return false;
    }
    public boolean checkTwoPair()
    {
        if(myHand.get(0).getRank().equals(myHand.get(1).getRank()) && myHand.get(2).getRank().equals(myHand.get(3).getRank()))
        {
            return true;
        }
        return false;
    }
    public int checkBestHand()
    {
        if(checkFlush () && checkRoyal())
        {
            System.out.println("You have a royal flush!");
            return 1;
        }
        if(checkFlush() && checkStraight())
        {
            System.out.println("You have a straight flush!");
            return 2;
        }
        if(numberOfAKind() == 4)
        {
            System.out.println("You have 4 of a Kind!");
            return 3;
        }
        if(checkFullHouse())
        {
            System.out.println("You have a Full House");
            return 4;
        }
        if(checkFlush())
        {
            System.out.println("You have a Flush!");
            return 5;
        }
        if(checkStraight())
        {
            System.out.println("You have a Straight!");
            return 6;
        }
        if(numberOfAKind() == 3)
        {
            System.out.println("You have 3 of a Kind!");
            return 7;
        }
        if(checkTwoPair())
        {
            System.out.println("You have 2 pairs!");
            return 8;
        }
        if(numberOfAKind() == 2)
        {
            System.out.println("You have a pair!");
            return 9;
        }
        return 10;
    }
}
