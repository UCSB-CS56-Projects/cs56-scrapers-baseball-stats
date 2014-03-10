package edu.ucsb.cs56.projects.scrapers.baseball_stats;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.ArrayList;

/** Test class for Statistic
 * @author Max Sorenson
 * @version 2014/02/26 for baseball scraper, cs56, W14
 * @see Statistic
*/

public class StatisticTest {

    float delta = 0.00001f;
    //float comparisons
    
    /** Test case for Statistic(String,float)
        @see Statistic
    */

    @Test public void testTwoArgConstructorFloat() {
	Statistic x = new Statistic("Home Run", 4.0f);
        assertEquals(4.0, x.getFloatValue(), delta);
	assertEquals("Home Run", x.getName());
    }

    /** Test case for Statistic(String,int)
        @see Statistic
    */

    @Test public void testTwoArgConstructorInt() {
        Statistic x = new Statistic("Home Run", 4);
        assertEquals(4, x.getIntValue());
        assertEquals("Home Run", x.getName());
    }

    /** Test case for Statistic.addSplit(Split)
        @see Statistic
    */

    @Test public void testAddSplit() {
        Statistic x = new Statistic("Home Run", 4);
	Split y = new Split("vs. L",4);
	x.addSplit(y);
        assertEquals(0, x.getSplitIndex(y));
        assertEquals(true, x.hasSplit(y));
    }


    
    /** Test case for Statistic.hasSplit(Split)
        @see Statistic
    */

    @Test public void testHasSplit() {
        Statistic x = new Statistic("Home Run", 4);
        Split y = new Split("vs. L",4);
        x.addSplit(y);
        assertEquals(true, x.hasSplit(y));
    }


    /** Test case for Statistic.getSplitIndex(Split)
        @see Statistic
    */

    @Test public void testGetSplitIndex() {
        Statistic x = new Statistic("Home Run", 4);
        Split y = new Split("vs. L",4);
        x.addSplit(y);
        assertEquals(0, x.getSplitIndex(y));
    }


    
    /** Test case for Statistic.getFloatValue()
        @see Statistic
    */

    @Test public void testGetFloatValue() {
        Statistic x = new Statistic("Home Run", 4.0f);
        assertEquals(4.0, x.getFloatValue(), delta);
    }

    /** Test case for Statistic.getIntValue()
        @see Statistic
    */

    @Test public void testGetIntValue() {
        Statistic x = new Statistic("Home Run", 4);
        assertEquals(4, x.getIntValue());
    }


    /** Test case for Statistic.getValue()
        @see Statistic
    */

    @Test public void testGetValue() {
        Statistic x = new Statistic("Home Run", 4);
        assertEquals(4, x.getValue());
    }


    /** Test case for Statistic.getName()
        @see Statistic
    */

    @Test public void testGetName() {
        Statistic x = new Statistic("Home Run", 4);
        assertEquals("Home Run", x.getName());
    }


    /** Test case for Statistic.getSplits()
        @see Statistic
    */

    @Test public void testGetSplits() {
        Statistic x = new Statistic("Home Run", 4);
	Split y = new Split("vs. L", 2);
	Split z = new Split("vs. R", 2);
	x.addSplit(y);
	x.addSplit(z);
        assertEquals(y, x.getSplits().get(0));
	assertEquals(z, x.getSplits().get(1));
    }


    /** Test case for Statistic.increment(int,ArrayList<Split>)
        @see Statistic
    */

    @Test public void testIncrement() {
        Statistic x = new Statistic("Home Run", 4);
        Split y = new Split("vs. L", 2);
        Split z = new Split("vs. R", 2);
        ArrayList<Split> a = new ArrayList<Split>();
	a.add(y);
	a.add(z);
	x.increment(4,a);
        assertEquals(y, x.getSplits().get(0));
        assertEquals(z, x.getSplits().get(1));
	assertEquals(8, x.getValue());
    }

    /** Test case for Statistic.incrementSplit(Split)
        @see Statistic
    */

    @Test public void testIncrementSplit() {
        Statistic x = new Statistic("Home Run", 4);
        Split y = new Split("vs. L", 2);
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
        Statistic x = new Statistic("Home Run", 4);
        Statistic y = new Statistic("Home Run", 5.0f);
        assertEquals(true, y.isFloat());
	assertEquals(false, x.isFloat());
    }



    /** Test case for Statistic.equals(Object)
        @see Statistic
    */

    @Test public void testEquals() {
	Statistic x = new Statistic("Home Run", 4);
	Statistic y = new Statistic("Home Run", 5);
	assertEquals(true, x.equals(y));
    }

    

    /** Test case for Statistic.toString()
        @see Statistic
    */

    @Test public void testToString() {
        Statistic x = new Statistic("Home Run", 4);
        assertEquals("Home Run = 4", x.toString());
    }


    


}

