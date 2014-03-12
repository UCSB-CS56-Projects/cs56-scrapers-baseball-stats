package edu.ucsb.cs56.projects.scrapers.baseball_stats;

import org.junit.*;
import static org.junit.Assert.*;

/** Test class for Split
 * @author Max Sorenson
 * @version 2014/02/26 for baseball scraper, cs56, W14
 * @see Split
*/

public class SplitTest {
    Split x;
    String splitType = "vs. L";
    int splitValue = 4;

    @Before public void setup() {
	x = new Split(splitType,splitValue);
    }


    /** Test case for Split(String)
        @see Split
    */

    @Test public void testOneArgConstructor() {
	Split y = new Split(splitType);
        assertEquals(splitType, x.getName());
    }


    /** Test case for Split(String,int)
        @see Split
    */

    @Test public void testTwoArgConstructor() {
	assertEquals(splitValue, x.getValue());
    }

    /** Test case for Split.equals(Object)
        @see Split
    */

    @Test public void testEquals() {
        assertTrue(x.equals(x));
    }

    /** Test case for false value Split.equals(Object)
        @see Split
    */

    @Test public void testEquals_trueValue() {
	Split y = new Split(splitType, 3);
        assertTrue(y.equals(x));
    }

    /** Test case for false name Split.equals(Object)
        @see Split
    */

    @Test public void testEquals_falseName() {
	Split y = new Split("vs. R", splitValue);
        assertFalse(y.equals(x));
    }

    /** Test case for Split.increment(int)
        @see Split
    */

    @Test public void testIncrement() {
	x.increment(2);
        assertEquals(splitValue + 2, x.getValue());
    }
    
    /** Test case for Split.setValue(int)
        @see Split
    */

    @Test public void testSetValue() {
        x.setValue(6);
        assertEquals(6, x.getValue());
    }

    /** Test case for Split.getValue()
        @see Split
    */

    @Test public void testGetValue() {
        assertEquals(splitValue, x.getValue());

    }

    /** Test case for Split.getName()
        @see Split
    */

    @Test public void testGetName() {
        assertEquals(splitType, x.getName());
    }


}

