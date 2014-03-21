package edu.ucsb.cs56.projects.scrapers.baseball_stats;

import org.junit.Test;
import org.junit.*;
import static org.junit.Assert.*;

/** Test class for StatCalculator
 * @author Max Sorenson
 * @version 2014/02/26 for baseball scraper, cs56, W14
 * @see StatCalculator
*/

public class StatCalculatorTest {

    float delta = 0.0001f;
    StatCalculator x;
    Player y;
    Statistic s1,s5,p10,d2;

    @Before public void setup() {
	x = new StatCalculator();
	y = new Player(1234567,"Jim Jones");
	s5 = new Statistic("Single", 5);
	s1 = new Statistic("Single", 1);
	d2 = new Statistic("Double", 2);
	p10 = new Statistic("PA", 10);
    }

    /** Test case for StatCalculator()
        @see StatCalculator
    */

    @Test public void testNoArgConstructor() {
        assertTrue(x instanceof StatCalculator);
    }

    /** Test case for StatCalculator.calculate1B(Player)
        @see StatCalculator
    */

    @Test public void testCalculate1B() {
	y.addStatistic(s1);
        assertEquals(1, x.calculate1B(y));
    }

    /** Test case for StatCalculator.calculate2B(Player)
        @see StatCalculator
    */

    @Test public void testCalculate2B() {
        y.addStatistic(d2);
        assertEquals(2, x.calculate2B(y));
    }


    /** Test case for StatCalculator.calculate3B(Player)
        @see StatCalculator
    */

    @Test public void testCalculate3B() {
        Statistic t = new Statistic("Triple", 5);
        y.addStatistic(t);
        assertEquals(5, x.calculate3B(y));
    }

    /** Test case for StatCalculator.calculateHR(Player)
        @see StatCalculator
    */

    @Test public void testCalculateHR() {
        Statistic h = new Statistic("Home Run", 5);
        y.addStatistic(h);
        assertEquals(5, x.calculateHR(y));
    }

    /** Test case for StatCalculator.calculateBB(Player)
        @see StatCalculator
    */

    @Test public void testCalculateBB() {
        Statistic b = new Statistic("Walk", 5);
        y.addStatistic(b);
        assertEquals(5, x.calculateBB(y));
    }

    /** Test case for StatCalculator.calculatePA(Player)
        @see StatCalculator
    */

    @Test public void testCalculatePA() {
        y.addStatistic(p10);
        assertEquals(10, x.calculatePA(y));
    }


    /** Test case for StatCalculator.calculateAB(Player)
        @see StatCalculator
    */

    @Test public void testCalculateAB() {
        StatCalculator x = new StatCalculator();
	Statistic w = new Statistic("Walk", 5);
        y.addStatistic(p10);
	y.addStatistic(w);
        assertEquals(5, x.calculateAB(y));
    }

    /** Test case for StatCalculator.calculateAVG(Player)
        @see StatCalculator
    */

    @Test public void testCalculateAVG() {
        y.addStatistic(p10);
	y.addStatistic(s5);
        assertEquals(.500f, x.calculateAVG(y), delta);
    }


    /** Test case for StatCalculator.calculateOBP(Player)
        @see StatCalculator
    */

    @Test public void testCalculateOBP() {
        y.addStatistic(p10);
	y.addStatistic(s1); 
	y.addStatistic(d2);
        assertEquals(.300f, x.calculateOBP(y), delta);
    }

    /** Test case for StatCalculator.calculateOPS(Player)
        @see StatCalculator
    */

    @Test public void testCalculateOPS() {
	y.addStatistic(p10);
	y.addStatistic(s1); 
	y.addStatistic(d2);
	float result = ( (1*1 + 2*2) / 10.0f ) + (.3f); 
        assertEquals(result, x.calculateOPS(y), delta);
    }

    
    /** Test case for StatCalculator.calculateSLG(Player)
        @see StatCalculator
    */

    @Test public void testCalculateSLG() {
	y.addStatistic(p10);
	y.addStatistic(s1); 
	y.addStatistic(d2);
	float result = (1*1 + 2*2) / 10.0f;
        assertEquals(result, x.calculateSLG(y), delta);
    }

    /** Test case for StatCalculator.calculateSO(Player)
        @see StatCalculator
    */

    @Test public void testCalculateSO() {
        Statistic so = new Statistic("Strikeout", 5);
        y.addStatistic(so);
        assertEquals(5, x.calculateSO(y));
    }





}

