import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

/**
 * The test class Phase1Tester.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class Phase1Tester
{
    
    /**
     * Default constructor for test class Phase1Tester
     */
    public Phase1Tester()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {

    }

    @Test
    public void TestValuesInConstructor()
    {

    }
    //Size of Hand 
    @Test
    public void HandGetHandSize()
    {
        Hand h1 = new Hand();
        h1.addCard(new Card(0));
        h1.addCard(new Card(5));
        h1.addCard(new Card(10));
        assertEquals(3, h1.getHandSize());
        Card c = h1.getCard();
        c = h1.getCard();
        assertEquals(1, h1.getHandSize());
        c = h1.getCard();
        assertEquals(0, h1.getHandSize());
    }

    //Get Rank from Hand
    @Test
    public void HandGetRank()
    {
        Hand h1 = new Hand();
        h1.addCard(new Card(4));
        h1.addCard(new Card(9));
        h1.addCard(new Card(14));
        Card c = h1.getCard();
        assertEquals("Two",c.getRank());
        c = h1.getCard();
        assertEquals("Three",c.getRank());
        c = h1.getCard();
        assertEquals("Four",c.getRank());
    }

    @Test
    public void TestAddCardSorting()
    {
        Hand h = new Hand();
        h.addCard(new Card(36));
        h.addCard(new Card(48));
        h.addCard(new Card(8));
        h.addCard(new Card(20));
        h.addCard(new Card(44));
        h.addCard(new Card(12));
        h.addCard(new Card(4));
        h.addCard(new Card(28));
        h.addCard(new Card(32));
        h.addCard(new Card(0));
        h.addCard(new Card(40));
        h.addCard(new Card(16));
        h.addCard(new Card(24));
        Card c = h.getCard();
        assertEquals("Two",c.getRank());
        c = h.getCard();
        assertEquals("Three",c.getRank());
        c = h.getCard();
        assertEquals("Four",c.getRank());
        c = h.getCard();
        assertEquals("Five",c.getRank());
        c = h.getCard();
        assertEquals("Six",c.getRank());
        c = h.getCard();
        assertEquals("Seven",c.getRank());
        c = h.getCard();
        assertEquals("Eight",c.getRank());
        c = h.getCard();
        assertEquals("Nine",c.getRank());
        c = h.getCard();
        assertEquals("Ten",c.getRank());
        c = h.getCard();
        assertEquals("Jack",c.getRank());
        c = h.getCard();
        assertEquals("Queen",c.getRank());
        c = h.getCard();
        assertEquals("King",c.getRank());
        c = h.getCard();
        assertEquals("Ace",c.getRank());
    }

    @Test
    public void TestFlush()
    {
        Hand h=new Hand();
        h.addCard(new Card(20));
        h.addCard(new Card(39));
        h.addCard(new Card(41));
        h.addCard(new Card(14));
        h.addCard(new Card(44));
        assertEquals(false, h.checkFlush());
        h=new Hand();
        h.addCard(new Card(21));
        h.addCard(new Card(37));
        h.addCard(new Card(41));
        h.addCard(new Card(13));
        h.addCard(new Card(45));
        assertEquals(true, h.checkFlush());
    }

    @Test
    public void TestCheckRoyal()
    {
        Hand h=new Hand();
        h.addCard(new Card(48));
        h.addCard(new Card(39));
        h.addCard(new Card(41));
        h.addCard(new Card(2));
        h.addCard(new Card(44));
        assertEquals(true, h.checkRoyal());
        h=new Hand();
        h.addCard(new Card(48));
        h.addCard(new Card(3));
        h.addCard(new Card(45));
        h.addCard(new Card(34));
        h.addCard(new Card(44));
        assertEquals(false, h.checkRoyal());
    }

    @Test
    public void TestStraight()
    {
        Hand h=new Hand();
        h.addCard(new Card(48));
        h.addCard(new Card(39));
        h.addCard(new Card(41));
        h.addCard(new Card(2));
        h.addCard(new Card(44));
        assertEquals(true, h.checkStraight());
        h=new Hand();
        h.addCard(new Card(48));
        h.addCard(new Card(43));
        h.addCard(new Card(37));
        h.addCard(new Card(34));
        h.addCard(new Card(28));
        assertEquals(false, h.checkStraight());
        h=new Hand();
        h.addCard(new Card(0));
        h.addCard(new Card(15));
        h.addCard(new Card(5));
        h.addCard(new Card(18));
        h.addCard(new Card(8));
        assertEquals(false, h.checkStraight());
    }

    @Test
    public void TestAddCardTotalNumber()
    {
        Hand h=new Hand();
        h.addCard(new Card(48));
        h.addCard(new Card(39));
        h.addCard(new Card(41));
        h.addCard(new Card(2));
        h.addCard(new Card(44));
        assertEquals("000000000011111", h.totalNumber());
        h=new Hand();
        h.addCard(new Card(48));
        h.addCard(new Card(39));
        h.addCard(new Card(49));
        h.addCard(new Card(2));
        h.addCard(new Card(44));
        assertEquals("000000000010121", h.totalNumber());
        h=new Hand();
        h.addCard(new Card(0));
        h.addCard(new Card(4));
        h.addCard(new Card(8));
        h.addCard(new Card(12));
        h.addCard(new Card(16));
        h.addCard(new Card(20));
        h.addCard(new Card(24));
        h.addCard(new Card(28));
        h.addCard(new Card(32));
        h.addCard(new Card(36));
        h.addCard(new Card(40));
        h.addCard(new Card(44));
        h.addCard(new Card(48));

    }
    @Test
    public void TestDiscardCard()
    {
        Hand h=new Hand();
        h.addCard(new Card(0));
        h.addCard(new Card(4));
        h.addCard(new Card(8));
        h.addCard(new Card(12));
        h.addCard(new Card(16));
        h.addCard(new Card(20));
        h.addCard(new Card(24));
        h.addCard(new Card(28));
        h.addCard(new Card(32));
        h.addCard(new Card(36));
        h.addCard(new Card(40));
        h.addCard(new Card(44));
        h.addCard(new Card(48));
        assertEquals(13, h.getHandSize());
        assertEquals("001111111111111", h.totalNumber());
        h.discardCard(0);
        assertEquals("000111111111111", h.totalNumber());
        h.discardCard(3);
        assertEquals("000111011111111", h.totalNumber());
        h.discardCard(10);
        assertEquals("000111011111110", h.totalNumber());
        h.discardCard(7);
        assertEquals("000111011110110", h.totalNumber());
        assertEquals(9, h.getHandSize());
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
}
