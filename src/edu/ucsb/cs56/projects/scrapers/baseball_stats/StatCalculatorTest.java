package edu.ucsb.cs56.projects.scrapers.baseball_stats;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/** Test class for StatCalculator
 * @author Max Sorenson
 * @version 2014/02/26 for baseball scraper, cs56, W14
 * @see StatCalculator
*/

public class StatCalculatorTest {

    float delta = 0.0001f;

    /** Test case for StatCalculator()
        @see StatCalculator
    */

    @Test public void testNoArgConstructor() {
	StatCalculator x = new StatCalculator();
        assertEquals(true, x instanceof StatCalculator);
    }

    /** Test case for StatCalculator.calculate1B(Player)
        @see StatCalculator
    */

    @Test public void testCalculate1B() {
        StatCalculator x = new StatCalculator();
	Player y = new Player(1234567,"Jim Jones");
	Statistic z = new Statistic("Single", 5);
	y.addStatistic(z);
        assertEquals(5, x.calculate1B(y));
    }

    /** Test case for StatCalculator.calculate2B(Player)
        @see StatCalculator
    */

    @Test public void testCalculate2B() {
        StatCalculator x = new StatCalculator();
        Player y = new Player(1234567);
        Statistic z = new Statistic("Double", 5);
        y.addStatistic(z);
        assertEquals(5, x.calculate2B(y));
    }


    /** Test case for StatCalculator.calculate3B(Player)
        @see StatCalculator
    */

    @Test public void testCalculate3B() {
        StatCalculator x = new StatCalculator();
        Player y = new Player(1234567);
        Statistic z = new Statistic("Triple", 5);
        y.addStatistic(z);
        assertEquals(5, x.calculate3B(y));
    }

    /** Test case for StatCalculator.calculateHR(Player)
        @see StatCalculator
    */

    @Test public void testCalculateHR() {
        StatCalculator x = new StatCalculator();
        Player y = new Player(1234567);
        Statistic z = new Statistic("Home Run", 5);
        y.addStatistic(z);
        assertEquals(5, x.calculateHR(y));
    }

    /** Test case for StatCalculator.calculateBB(Player)
        @see StatCalculator
    */

    @Test public void testCalculateBB() {
        StatCalculator x = new StatCalculator();
        Player y = new Player(1234567);
        Statistic z = new Statistic("Walk", 5);
        y.addStatistic(z);
        assertEquals(5, x.calculateBB(y));
    }

    /** Test case for StatCalculator.calculatePA(Player)
        @see StatCalculator
    */

    @Test public void testCalculatePA() {
        StatCalculator x = new StatCalculator();
        Player y = new Player(1234567);
        Statistic z = new Statistic("PA", 5);
        y.addStatistic(z);
        assertEquals(5, x.calculatePA(y));
    }


    /** Test case for StatCalculator.calculateAB(Player)
        @see StatCalculator
    */

    @Test public void testCalculateAB() {
        StatCalculator x = new StatCalculator();
        Player y = new Player(1234567, "Jim Jones");
        Statistic z = new Statistic("PA", 10);
	Statistic a = new Statistic("Walk", 5);
        y.addStatistic(z);
	y.addStatistic(a);
        assertEquals(5, x.calculateAB(y));
    }

    /** Test case for StatCalculator.calculateAVG(Player)
        @see StatCalculator
    */

    @Test public void testCalculateAVG() {
        StatCalculator x = new StatCalculator();
        Player y = new Player(1234567,"Jim Jones");
        Statistic z = new Statistic("PA", 10);
	Statistic a = new Statistic("Single", 4);
        y.addStatistic(z);
	y.addStatistic(a);
        assertEquals(.400f, x.calculateAVG(y), delta);
    }


    /** Test case for StatCalculator.calculateOBP(Player)
        @see StatCalculator
    */

    @Test public void testCalculateOBP() {
        StatCalculator x = new StatCalculator();
        Player y = new Player(1234567);
        Statistic z = new Statistic("PA", 10);
	Statistic a = new Statistic("Double", 2);
	Statistic b = new Statistic("Single", 1);
        y.addStatistic(z);
	y.addStatistic(a); 
	y.addStatistic(b);
        assertEquals(.300f, x.calculateOBP(y), delta);
    }

    /** Test case for StatCalculator.calculateOPS(Player)
        @see StatCalculator
    */

    @Test public void testCalculateOPS() {
        StatCalculator x = new StatCalculator();
        Player y = new Player(1234567);
        Statistic z = new Statistic("PA", 10);
        Statistic a = new Statistic("Double", 2);
        Statistic b = new Statistic("Single", 1);
        y.addStatistic(z);
        y.addStatistic(a);
        y.addStatistic(b);
	float result = ( (1*1 + 2*2) / 10.0f ) + (.3f); 
        assertEquals(result, x.calculateOPS(y), delta);
    }

    
    /** Test case for StatCalculator.calculateSLG(Player)
        @see StatCalculator
    */

    @Test public void testCalculateSLG() {
        StatCalculator x = new StatCalculator();
        Player y = new Player(1234567);
        Statistic z = new Statistic("PA", 10);
        Statistic a = new Statistic("Double", 2);
        Statistic b = new Statistic("Single", 1);
        y.addStatistic(z);
        y.addStatistic(a);
        y.addStatistic(b);
	float result = (1*1 + 2*2) / 10.0f;
        assertEquals(result, x.calculateSLG(y), delta);
    }

    /** Test case for StatCalculator.calculateSO(Player)
        @see StatCalculator
    */

    @Test public void testCalculateSO() {
        StatCalculator x = new StatCalculator();
        Player y = new Player(1234567);
        Statistic z = new Statistic("Strikeout", 5);
        y.addStatistic(z);
        assertEquals(5, x.calculateSO(y));
    }





}

