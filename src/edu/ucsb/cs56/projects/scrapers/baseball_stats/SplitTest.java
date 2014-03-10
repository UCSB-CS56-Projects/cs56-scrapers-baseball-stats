package edu.ucsb.cs56.projects.scrapers.baseball_stats;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/** Test class for Split
 * @author Max Sorenson
 * @version 2014/02/26 for baseball scraper, cs56, W14
 * @see Split
*/

public class SplitTest {

    /** Test case for Split(String)
        @see Split
    */

    @Test public void testOneArgConstructor() {
        Split x = new Split("vs. L");
        assertEquals("vs. L", x.getName());
        assertEquals(0, x.getValue());
    }


    /** Test case for Split(String,int)
        @see Split
    */

    @Test public void testTwoArgConstructor() {
	Split x = new Split("vs. L", 4);
        assertEquals("vs. L", x.getName());
	assertEquals(4, x.getValue());
    }

    /** Test case for Split.equals(Object)
        @see Split
    */

    @Test public void testEquals() {
        Split x = new Split("vs. L", 4);
	Split y = new Split("vs. L", 4);
        assertEquals(true, x.equals(y));
        assertEquals(true, y.equals(x));
    }

    /** Test case for Split.increment(int)
        @see Split
    */

    @Test public void testIncrement() {
        Split x = new Split("vs. L", 4);
	x.increment(2);
        assertEquals(6, x.getValue());
    }
    
    /** Test case for Split.setValue(int)
        @see Split
    */

    @Test public void testSetValue() {
        Split x = new Split("vs. L", 4);
        x.setValue(6);
        assertEquals(6, x.getValue());
    }

    /** Test case for Split.getValue()
        @see Split
    */

    @Test public void testGetValue() {
        Split x = new Split("vs. L", 4);
        Split y = new Split("vs. R");
        assertEquals(4, x.getValue());
        assertEquals(0, y.getValue());

    }

    /** Test case for Split.getName()
        @see Split
    */

    @Test public void testGetName() {
        Split x = new Split("vs. L", 4);
	Split y = new Split("vs. R");
        assertEquals("vs. L", x.getName());
        assertEquals("vs. R", y.getName());
    }





}

