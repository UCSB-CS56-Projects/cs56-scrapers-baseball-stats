package edu.ucsb.cs56.projects.scrapers.baseball_stats;

import org.junit.Test;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;

/** Test class for StatKeeper
 * @author Max Sorenson
 * @version 2014/02/26 for baseball scraper, cs56, W14
 * @see StatKeeper
*/

public class StatKeeperTest {

    float delta = 0.00001f;
    StatKeeper x;
    Player a,b;

    @Before public void setup() {
	x = new StatKeeper();
        a = new Player(1234567, "Jim Jones");
        b = new Player(7654321, "Jon Jennings");
    }
    
    /** Test case for StatKeeper()
        @see StatKeeper
    */

    @Test public void testNoArgConstructor() {
        assertTrue(x instanceof StatKeeper);
	
    }

    /** Test case for StatKeeper.addPlayer(ArrayList<Player>)
        @see StatKeeper
    */

    @Test public void testAddPlayer() {
	ArrayList<Player> y = new ArrayList<Player>();
	y.add(a);
	x.addPlayer(y);
        assertEquals(a, x.getPlayer(0));
    }

    /** Test case for StatKeeper.addPlayer(Player)
        @see StatKeeper
    */

    @Test public void testAddPlayer2() {
        x.addPlayer(a);
        assertEquals(a, x.getPlayer(0));
    }

    /** Test case for StatKeeper.getPlayer()
        @see StatKeeper
    */

    @Test public void testGetPlayer() {
        x.addPlayer(a);
        assertEquals(a, x.getPlayer(0));
    }

    /** Test case for StatKeeper.getPlayerCount()
        @see StatKeeper
    */

    @Test public void testGetPlayerCount() {
        x.addPlayer(a);
        x.addPlayer(b);
        assertEquals(2, x.getPlayerCount());
    }


    /** Test case for StatKeeper.getPlayerIndex(int)
        @see StatKeeper
    */

    @Test public void testGetPlayerIndex_onePlayer() {
        x.addPlayer(a);
        assertEquals(0, x.getPlayerIndex(1234567));
    }

    /** Test case for StatKeeper.getPlayerIndex(int)
        @see StatKeeper
    */

    @Test public void testGetPlayerIndex_twoPlayer() {
        x.addPlayer(a);
        x.addPlayer(b);
	assertEquals(1, x.getPlayerIndex(7654321));
    }


    /** Test case for StatKeeper.getPlayerName(int)
        @see StatKeeper
    */

    @Test public void testGetPlayerName() {
        x.addPlayer(b);
        assertEquals("Jon Jennings", x.getPlayerName(0));
    }

    /** Test case for StatKeeper.newStats()
        @see StatKeeper
    */

    @Test public void testNewStats() {
        x.addPlayer(a);
        x.addPlayer(b);
	x.newStats();
	x.addPlayer(b);
	x.addPlayer(a);
        assertEquals(a, x.getPlayer(1));
    }

    

}

