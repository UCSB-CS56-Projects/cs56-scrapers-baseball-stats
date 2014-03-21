package edu.ucsb.cs56.projects.scrapers.baseball_stats;

import org.junit.Test;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;

/** Test class for StatReader
 * @author Max Sorenson
 * @version 2014/02/26 for baseball scraper, cs56, W14
 * @see StatReader
*/

public class StatReaderTest {

    StatReader x;

    @Before public void setup() {
	x = new StatReader();
    }
    
    /** Test case for StatReader()
        @see StatReader
    */

    @Test public void testNoArgConstructor() {
        assertTrue(x instanceof StatReader);
	
    }

    /** Test case for StatReader.parseDay(int,int,int)
        @see StatReader
    */

    @Test public void testParseDay() {
        assertTrue(x instanceof StatReader);

    }


    /** Test case for StatReader.readDemoStats()
        @see StatReader
    */

    @Test public void testReadDemoStats() {
        assertTrue(x instanceof StatReader);

    }

    /** Test case for StatReader.getStatManager()
        @see StatReader
    */

    @Test public void testGetStatManager() {
        assertTrue(x instanceof StatReader);

    }

    /** Test case for StatReader.readStats(int,int,int,int,int,int)
        @see StatReader
    */

    @Test public void testReadStats() {
        assertTrue(x instanceof StatReader);

    }



}

