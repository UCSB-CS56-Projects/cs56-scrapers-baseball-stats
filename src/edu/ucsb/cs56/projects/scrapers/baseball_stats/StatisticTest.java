package edu.ucsb.cs56.projects.scrapers.baseball_stats;

import org.junit.Test;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;

/** Test class for Statistic
 * @author Max Sorenson
 * @version 2014/02/26 for baseball scraper, cs56, W14
 * @see Statistic
*/

public class StatisticTest {

    float delta = 0.00001f;
    Split y,z;
    Statistic x;
    int statValue = 4;
    String statName = "Home Run";

    @Before public void setup() {
	x = new Statistic(statName,statValue);
	y = new Split("vs. L", 2);
	z = new Split("vs. R", 2);
    }

    /** Test case for Statistic(String,float)
        @see Statistic
    */

    @Test public void testTwoArgConstructorFloat() {
	Statistic x = new Statistic("Home Run", 4.0f);
        assertEquals((float)statValue, x.getFloatValue(), delta);
    }

    /** Test case for Statistic(String,int)
        @see Statistic
    */

    @Test public void testTwoArgConstructorInt() {
        assertEquals(statValue, x.getIntValue());
    }

    /** Test case for Statistic.addSplit(Split)
        @see Statistic
    */

    @Test public void testAddSplit() {
	x.addSplit(y);
        assertTrue(x.hasSplit(y));
    }


    
    /** Test case for Statistic.hasSplit(Split)
        @see Statistic
    */

    @Test public void testHasSplit() {
        x.addSplit(y);
        assertTrue(x.hasSplit(y));
    }


    /** Test case for Statistic.getSplitIndex(Split)
        @see Statistic
    */

    @Test public void testGetSplitIndex() {
        x.addSplit(y);
        assertEquals(0, x.getSplitIndex(y));
    }


    
    /** Test case for Statistic.getFloatValue()
        @see Statistic
    */

    @Test public void testGetFloatValue() {
        Statistic x = new Statistic("Home Run", 4.0f);
        assertEquals((float)statValue, x.getFloatValue(), delta);
    }

    /** Test case for Statistic.getIntValue()
        @see Statistic
    */

    @Test public void testGetIntValue() {
        assertEquals(statValue, x.getIntValue());
    }


    /** Test case for Statistic.getValue()
        @see Statistic
    */

    @Test public void testGetValue() {
        assertEquals(statValue, x.getValue());
    }


    /** Test case for Statistic.getName()
        @see Statistic
    */

    @Test public void testGetName() {
        assertEquals(statName, x.getName());
    }


    /** Test case for Statistic.getSplits()
        @see Statistic
    */

    @Test public void testGetSplits_one() {
	x.addSplit(y);
	x.addSplit(z);
        assertEquals(y, x.getSplits().get(0));
    }

    /** Test case 2 for Statistic.getSplits()
        @see Statistic
    */

    @Test public void testGetSplits_two() {
	x.addSplit(y);
	x.addSplit(z);
	assertEquals(z, x.getSplits().get(1));
    }


    /** Test case for Statistic.increment(int,ArrayList<Split>)
        @see Statistic
    */

    @Test public void testIncrement() {
        ArrayList<Split> a = new ArrayList<Split>();
	a.add(y);
	a.add(z);
	x.increment(statValue,a);
	assertEquals(8, x.getValue());
    }

    /** Test case for Statistic.incrementSplit(Split)
        @see Statistic
    */

    @Test public void testIncrementSplit() {
	ArrayList<Split> z = new ArrayList<Split>();
	z.add(y);
	x.addSplit(y);
	x.incrementSplit(y);
        assertEquals(z, x.getSplits());
    }


    /** Test case for Statistic.isFloat()
        @see Statistic
    */

    @Test public void testisFloat() {
        Statistic y = new Statistic("Home Run", 5.0f);
        assertTrue(y.isFloat());
    }

    /** Test case 2 for Statistic.isFloat()
        @see Statistic
    */

    @Test public void testisFloat_false() {
        assertFalse(x.isFloat());
    }


    /** Test case for Statistic.equals(Object)
        @see Statistic
    */

    @Test public void testEquals() {
	assertTrue(x.equals(x));
    }

    
    /** Test case for Statistic.equals(Object)
        @see Statistic
    */

    @Test public void testEquals_false() {
	Statistic y = new Statistic("Single", 7);
	assertFalse(x.equals(y));
    }


    /** Test case for Statistic.toString()
        @see Statistic
    */

    @Test public void testToString() {
        assertEquals("Home Run = 4", x.toString());
    }


    


}

