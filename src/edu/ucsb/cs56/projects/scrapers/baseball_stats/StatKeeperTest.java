package edu.ucsb.cs56.projects.scrapers.baseball_stats;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.ArrayList;

/** Test class for StatKeeper
 * @author Max Sorenson
 * @version 2014/02/26 for baseball scraper, cs56, W14
 * @see StatKeeper
*/

public class StatKeeperTest {

    float delta = 0.00001f;

    /** Test case for StatKeeper()
        @see StatKeeper
    */

    @Test public void testNoArgConstructor() {
	StatKeeper x = new StatKeeper();
        assertEquals(true, x instanceof StatKeeper);
	
    }

    /** Test case for StatKeeper.addPlayer(ArrayList<Player>)
        @see StatKeeper
    */

    @Test public void testAddPlayer() {
        StatKeeper x = new StatKeeper();
	ArrayList<Player> y = new ArrayList<Player>();
	Player a = new Player(1234567,"Jim Jones");
	y.add(a);
	x.addPlayer(y);
        assertEquals(a, x.getPlayer(0));
    }

    /** Test case for StatKeeper.addPlayer(Player)
        @see StatKeeper
    */

    @Test public void testAddPlayer2() {
        StatKeeper x = new StatKeeper();
        Player a = new Player(1234567,"Jim Jones");
        x.addPlayer(a);
        assertEquals(a, x.getPlayer(0));
    }

    /** Test case for StatKeeper.getPlayer()
        @see StatKeeper
    */

    @Test public void testGetPlayer() {
        StatKeeper x = new StatKeeper();
        Player a = new Player(1234567, "Jim Jones");
	Player b = new Player(7654321, "Jon Jennings");
        x.addPlayer(a);
	x.addPlayer(b);
        assertEquals(a, x.getPlayer(0));
	assertEquals(b, x.getPlayer(1));
    }

    /** Test case for StatKeeper.getPlayerCount()
        @see StatKeeper
    */

    @Test public void testGetPlayerCount() {
        StatKeeper x = new StatKeeper();
        Player a = new Player(1234567, "Jim Jones");
        Player b = new Player(7654321, "Jon Jennings");
        x.addPlayer(a);
        x.addPlayer(b);
        assertEquals(2, x.getPlayerCount());
    }


    /** Test case for StatKeeper.getPlayerIndex(int)
        @see StatKeeper
    */

    @Test public void testGetPlayerIndex() {
        StatKeeper x = new StatKeeper();
        Player a = new Player(1234567, "Jim Jones");
        Player b = new Player(7654321, "Jon Jennings");
        x.addPlayer(a);
        x.addPlayer(b);
        assertEquals(0, x.getPlayerIndex(1234567));
	assertEquals(1, x.getPlayerIndex(7654321));
    }

    /** Test case for StatKeeper.getPlayerIndex(Player)
        @see StatKeeper
    */

    @Test public void testGetPlayerIndex2() {
        StatKeeper x = new StatKeeper();
        Player a = new Player(1234567, "Jim Jones");
        Player b = new Player(7654321, "Jon Jennings");
        x.addPlayer(a);
        x.addPlayer(b);
        assertEquals(0, x.getPlayerIndex(a));
        assertEquals(1, x.getPlayerIndex(b));
    }


    /** Test case for StatKeeper.getPlayerName(int)
        @see StatKeeper
    */

    @Test public void testGetPlayerName() {
        StatKeeper x = new StatKeeper();
        Player a = new Player(1234567, "Jim Jones");
        Player b = new Player(7654321, "Jon Jennings");
        x.addPlayer(a);
        x.addPlayer(b);
        assertEquals("Jim Jones", x.getPlayerName(0));
        assertEquals("Jon Jennings", x.getPlayerName(1));
    }

    /** Test case for StatKeeper.newStats()
        @see StatKeeper
    */

    @Test public void testNewStats() {
        StatKeeper x = new StatKeeper();
        Player a = new Player(1234567, "Jim Jones");
        Player b = new Player(7654321, "Jon Jennings");
        x.addPlayer(a);
        x.addPlayer(b);
	x.newStats();
	x.addPlayer(b);
	x.addPlayer(a);
        assertEquals("Jim Jones", x.getPlayerName(1));
        assertEquals("Jon Jennings", x.getPlayerName(0));
    }

    

}

