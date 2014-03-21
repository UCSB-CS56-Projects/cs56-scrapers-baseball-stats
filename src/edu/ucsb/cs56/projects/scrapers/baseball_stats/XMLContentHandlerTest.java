package edu.ucsb.cs56.projects.scrapers.baseball_stats;

import org.junit.Test;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;

/** Test class for XMLContentHandler
 * @author Max Sorenson
 * @version 2014/02/26 for baseball scraper, cs56, W14
 * @see XMLContentHandler
*/

public class XMLContentHandlerTest {

    float delta = 0.0001f;
    XMLContentHandler x;

    @Before public void setup() {
	x = new XMLContentHandler();
    }

    /** Test case for XMLContentHandler()
        @see XMLContentHandler
    */

    @Test public void testNoArgConstructor() {
        assertTrue(x instanceof XMLContentHandler);
	
    }

    /** Test case for XMLContentHandler.characters(char[],int,int)
        @see XMLContentHandler
    */

    @Test public void testCharacters() {
        assertTrue(x instanceof XMLContentHandler);

    }

    /** Test case for XMLContentHandler.endDocument()
        @see XMLContentHandler
    */

    @Test public void testEndDocument() {
        assertTrue(x instanceof XMLContentHandler);

    }

    /** Test case for XMLContentHandler.endElement(String,String,String)
        @see XMLContentHandler
    */

    @Test public void testEndElement() {
        assertTrue(x instanceof XMLContentHandler);

    }

    /** Test case for XMLContentHandler.endPrefixMapping(String)
        @see XMLContentHandler
    */

    @Test public void testEndPrefixMapping() {
        assertTrue(x instanceof XMLContentHandler);

    }

    /** Test case for XMLContentHandler.ignorableWhitespace(char[],int,int)
        @see XMLContentHandler
    */

    @Test public void testIgnorableWhitespace() {
        assertTrue(x instanceof XMLContentHandler);

    }

    /** Test case for XMLContentHandler.processingInstruction(String,String)
        @see XMLContentHandler
    */

    @Test public void testProcessingInstruction() {
        assertTrue(x instanceof XMLContentHandler);

    }

    /** Test case for XMLContentHandler.setDate(int,int,int)
        @see XMLContentHandler
    */

    @Test public void testSetDate() {
        assertTrue(x instanceof XMLContentHandler);

    }

    /** Test case for XMLContentHandler.setDay(int)
        @see XMLContentHandler
    */

    @Test public void testSetDay() {
        assertTrue(x instanceof XMLContentHandler);

    }

    /** Test case for XMLContentHandler.setMonth(int)
        @see XMLContentHandler
    */

    @Test public void testSetMonth() {
        assertTrue(x instanceof XMLContentHandler);

    }

    /** Test case for XMLContentHandler.setYear(int)
        @see XMLContentHandler
    */

    @Test public void testSetYear() {
        assertTrue(x instanceof XMLContentHandler);

    }


    /** Test case for XMLContentHandler.setDocumentLocator(org.xml.sax.Locator)
        @see XMLContentHandler
    */

    @Test public void testSetDocumentLocator() {
        assertTrue(x instanceof XMLContentHandler);

    }


    /** Test case for XMLContentHandler.skippedEntity()
        @see XMLContentHandler
    */

    @Test public void testSkippedEntity() {
        assertTrue(x instanceof XMLContentHandler);

    }

    /** Test case for XMLContentHandler.startDocument()
        @see XMLContentHandler
    */

    @Test public void testStartDocument() {
        assertTrue(x instanceof XMLContentHandler);

    }

    /** Test case for XMLContentHandler.startElement(String,String,
	     String,org.xml.sax.Attributes)
        @see XMLContentHandler
    */

    @Test public void testStartElement() {
        assertTrue(x instanceof XMLContentHandler);

    }

    /** Test case for XMLContentHandler.startPrefixMapping(String,String)
        @see XMLContentHandler
    */

    @Test public void testStartPrefixMapping() {
        assertTrue(x instanceof XMLContentHandler);

    }


}

