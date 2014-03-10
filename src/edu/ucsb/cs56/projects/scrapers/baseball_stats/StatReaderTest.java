package edu.ucsb.cs56.projects.scrapers.baseball_stats;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.ArrayList;

/** Test class for StatReader
 * @author Max Sorenson
 * @version 2014/02/26 for baseball scraper, cs56, W14
 * @see StatReader
*/

public class StatReaderTest {

    
    /** Test case for StatReader()
        @see StatReader
    */

    @Test public void testNoArgConstructor() {
	StatReader x = new StatReader();
        assertEquals(true, x instanceof StatReader);
	
    }

    /** Test case for StatReader.parseDay(int,int,int)
        @see StatReader
    */

    @Test public void testParseDay() {
        StatReader x = new StatReader();
	//assertEquals();

    }


    /** Test case for StatReader.readDemoStats()
        @see StatReader
    */

    @Test public void testReadDemoStats() {
        StatReader x = new StatReader();
        assertEquals(true, x instanceof StatReader);

    }

    /** Test case for StatReader.getStatManager()
        @see StatReader
    */

    @Test public void testGetStatManager() {
        StatReader x = new StatReader();
        assertEquals(true, x instanceof StatReader);

    }

    /** Test case for StatReader.readStats(int,int,int,int,int,int)
        @see StatReader
    */

    @Test public void testReadStats() {
        StatReader x = new StatReader();
        assertEquals(true, x instanceof StatReader);

    }



}

