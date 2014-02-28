package edu.ucsb.cs56.projects.scrapers.baseball_stats;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.ArrayList;

/** Test class for StatManager
 * @author Max Sorenson
 * @version 2014/02/26 for baseball scraper, cs56, W14
 * @see StatManager
*/

public class StatManagerTest {

    float delta = 0.0001f;
    ArrayList<Player> players = new ArrayList<Player>();

    /** Test case for StatManager()
        @see StatManager
    */

    @Test public void testNoArgConstructor() {
	StatManager x = new StatManager();
        assertEquals(true, x instanceof StatManager);
    }


    /** Test case for StatManager.endGame()
        @see StatManager
    */

    @Test public void testEndGame() {
        StatManager x = new StatManager();
	Statistic y = new Statistic("Home Run", 4);
	x.incrementPlayerStat(1234567, y);
	//x.endGame();
        assertEquals(true, x instanceof StatManager);
    }


    /** Test case for StatManager.incrementPlayerStat(int,Statistic)
        @see StatManager
    */

    @Test public void testIncrementPlayerStat() {
        StatManager x = new StatManager();
	Statistic y = new Statistic("Home Run", 4);
        x.incrementPlayerStat(1234567, y);
        assertEquals(0, x.getPlayerIndex(1234567));
    }

    /** Test case for StatManager.getPlayerIndex(int)
        @see StatManager
    */

    @Test public void testGetPlayerIndex() {
        StatManager x = new StatManager();
        Statistic y = new Statistic("Home Run", 4);
        x.incrementPlayerStat(1234567, y);
	x.incrementPlayerStat(7654321, y);
        assertEquals(0, x.getPlayerIndex(1234567));
	assertEquals(1, x.getPlayerIndex(7654321));
    }

    /** Test case for StatManager.setPlayerName(int,String)
        @see StatManager
    */

    @Test public void testSetPlayerName() {
        StatManager x = new StatManager();
        Statistic y = new Statistic("Home Run", 4);
	x.incrementPlayerStat(1234567, y);
	x.incrementPlayerStat(7654321, y);
	x.setPlayerName(1234567, "Jim Jones");
	x.setPlayerName(7654321, "Jon Jennings");
	assertEquals(0, x.getPlayerIndex(1234567));
    }

    /** Test case for StatManager.startNewGame(int,int,int)
        @see StatManager
    */

    @Test public void testStartNewGame() {
        /*StatManager x = new StatManager();
        saving for future use
        x.startNewGame(1,2,3);;
        assertEquals(0, 0);*/
    }

    /** Test case for StatManager.toString()
        @see StatManager
    */

    @Test public void testToString() {
        StatManager x = new StatManager();
        assertEquals("Game Stats:\n" , x.toString());
	Statistic y = new Statistic("Home Run", 4);
        x.incrementPlayerStat(1234567, y);
        x.setPlayerName(1234567, "Jim Jones");
	assertEquals("Game Stats:\nJim Jones| ID = 1234567: Home Run = 4\n",
		     x.toString());
    }



    

}

