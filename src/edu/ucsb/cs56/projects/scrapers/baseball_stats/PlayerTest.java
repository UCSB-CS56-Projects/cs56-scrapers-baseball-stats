package edu.ucsb.cs56.projects.scrapers.baseball_stats;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/** Test class for Player

 * @author Max Sorenson
 * @author Eric Palyan
 * @author Max Sorenson
 * @version 2014/02/26 for baseball scraper, cs56, W14
 * @see Player

*/

public class PlayerTest {

    /** Test case for Player(int)
        @see Player
    */

    @Test public void testOneArgConstructor() {
	Player x = new Player(1234567);
        assertEquals(1234567, x.getID());
    }


    /** Test case for Player(int,String)
        @see Player
    */

    @Test public void testTwoArgConstructor() {
        Player x = new Player(1234567, "Jim Jones");
        assertEquals(1234567, x.getID());
	assertEquals("Jim Jones", x.getFullName());
    }

    /** Test case for Player(int,String,String)
        @see Player
    */

    @Test public void testThreeArgConstructor() {
        Player x = new Player(1234567, "Jim", "Jones");
        assertEquals(1234567, x.getID());
        assertEquals("Jim", x.getFirstName());
	assertEquals("Jones", x.getLastName());
    }

    
    
    /** Test case for Player.addStatistic(Statistic)
        @see Player
    */

    @Test public void testAddStatistic() {
        Player x = new Player(1234567, "Jim", "Jones");
	Statistic y = new Statistic("Home Run", 4);
        x.addStatistic(y);
	assertEquals(4, x.getStatValue("Home Run"));
    }



    /** Test case for Player.equals(Object)
        @see Player
    */

    @Test public void testEquals() {
        Player x = new Player(1234567, "Jim", "Jones");
        Player y = new Player(1234567, "Jim", "Jones");
        assertEquals(true, x.equals(y));
    }

    

    /** Test case for Player.getFirstName()
	@see Player
    */
    
    @Test public void testGetFirstName() {
	Player x = new Player(1234567, "Jim", "Jones");
	assertEquals("Jim", x.getFirstName());
    }

    
    /** Test case for Player.getLastName()
        @see Player
    */

    @Test public void testGetLastName() {
        Player x = new Player(1234567, "Jim", "Jones");
        assertEquals("Jones", x.getLastName());
    }


    /** Test case for Player.getFullName()
        @see Player
    */

    @Test public void testGetFullName() {
        Player x = new Player(1234567, "Jim", "Jones");
        assertEquals("Jim Jones", x.getFullName());
    }
 

    /** Test case for Player.getLastName()
        @see Player
    */

    @Test public void testGetID() {
        Player x = new Player(1234567, "Jim", "Jones");
        assertEquals(1234567, x.getID());
    }
   
    /** Test case for Player.getStat()
        @see Player
    */

    @Test public void testGetStat() {
        Player x = new Player(1234567, "Jim", "Jones");
        Statistic y = new Statistic("Home Run", 4);
	x.addStatistic(y);
	assertEquals(y, x.getStat(0));
    }

    /** Test case for Player.getStatisticIndex(Statistic)
        @see Player
    */

    @Test public void testGetStatisticIndex() {
        Player x = new Player(1234567, "Jim", "Jones");
        Statistic y = new Statistic("Home Run", 4);
        x.addStatistic(y);
        assertEquals(0, x.getStatisticIndex(y));
    }

    
    /** Test case for Player.getStatValue(String)
        @see Player
    */

    @Test public void testGetStatValue() {
        Player x = new Player(1234567, "Jim", "Jones");
        Statistic y = new Statistic("Home Run", 4);
        x.addStatistic(y);
        assertEquals(4, x.getStatValue("Home Run"));
    }

    
    /** Test case for Player.setFirstName(String)
        @see Player
    */

    @Test public void testSetFirstName() {
        Player x = new Player(1234567, "Jim", "Jones");
        x.setFirstName("Jon");
        assertEquals("Jon", x.getFirstName());
    }

    /** Test case for Player.setLastName(String)
        @see Player
    */

    @Test public void testSetLastName() {
        Player x = new Player(1234567, "Jim", "Jones");
        x.setLastName("Jennings");
        assertEquals("Jennings", x.getLastName());
    }
    
    /** Test case for Player.setFullName(String)
        @see Player
    */

    @Test public void testSetFullName() {
        Player x = new Player(1234567, "Jim", "Jones");
        x.setFullName("Jon Jennings");
        assertEquals("Jon Jennings", x.getFullName());
    }

    /** Test case for Player.toString()
        @see Player
    */

    @Test public void testToString() {
        Player x = new Player(1234567, "Jim", "Jones");
        assertEquals("Jim Jones| ID = 1234567: ", x.toString());
    }


    


}

