import java.util.Scanner;
/**
 *
 * @author Sravani Bhamidipaty
 * @version 2021
 */
public class Game
{
    public static void main (String args[])
    {
       Deck deck = new Deck();
       deck.shuffleDeck();
       System.out.println("Shuffling...");
       Hand one = new Hand();
       Hand two = new Hand();
       System.out.println("Dealing...");
       for(int i = 0; i < 10; i++)
       {
           if(i % 2 == 0)
           {
               one.addCard(deck.getCard());
           }
           else
           {
               two.addCard(deck.getCard());
           }
       }
       System.out.println("Ready! Hit Enter to continue.");
       Scanner scan = new Scanner(System.in);
       String start = scan.nextLine();
       one.printHand();
       System.out.println("How many cards would you like to discard?");
       int discard = scan.nextInt();
       for(int i = 0; i < discard; i++)
       {
            System.out.println("Enter the number of a card you want to discard");
            int num = scan.nextInt();
            one.discardCard(num);
       }
       for(int i = 0; i < discard; i++)
       {
            one.addCard(deck.getCard());
       }
       two.printHand();
       System.out.println("How many cards would you like to discard?");
       int discardTwo = scan.nextInt();
       for(int i = 0; i < discardTwo; i++)
       {
            System.out.println("Enter the number of a card you want to discard");
            int numTwo = scan.nextInt();
            two.discardCard(numTwo);
       }
       for(int i = 0; i < discardTwo; i++)
       {
            two.addCard(deck.getCard());
       }
       one.printHand();
       two.printHand();
       int bestHandOne = one.checkBestHand();
       int bestHandTwo = two.checkBestHand();
       if(bestHandOne < bestHandTwo)
       {
           System.out.println("Player 1 has the best hand");
       }
       else if(bestHandTwo < bestHandOne)
       {
           System.out.println("Player 2 has the best hand");
       }
       else
       {
           System.out.println("It is a tie");
       }
    }
}
