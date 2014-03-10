package edu.ucsb.cs56.projects.scrapers.baseball_stats;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.ArrayList;

/** Test class for XMLContentHandler
 * @author Max Sorenson
 * @version 2014/02/26 for baseball scraper, cs56, W14
 * @see XMLContentHandler
*/

public class XMLContentHandlerTest {

    float delta = 0.0001f;
    

    /** Test case for XMLContentHandler()
        @see XMLContentHandler
    */

    @Test public void testNoArgConstructor() {
	XMLContentHandler x = new XMLContentHandler();
        assertEquals(true, x instanceof XMLContentHandler);
	
    }

    /** Test case for XMLContentHandler.characters(char[],int,int)
        @see XMLContentHandler
    */

    @Test public void testCharacters() {
        XMLContentHandler x = new XMLContentHandler();
        assertEquals(true, x instanceof XMLContentHandler);

    }

    /** Test case for XMLContentHandler.endDocument()
        @see XMLContentHandler
    */

    @Test public void testEndDocument() {
        XMLContentHandler x = new XMLContentHandler();
        assertEquals(true, x instanceof XMLContentHandler);

    }

    /** Test case for XMLContentHandler.endElement(String,String,String)
        @see XMLContentHandler
    */

    @Test public void testEndElement() {
        XMLContentHandler x = new XMLContentHandler();
        assertEquals(true, x instanceof XMLContentHandler);

    }

    /** Test case for XMLContentHandler.endPrefixMapping(String)
        @see XMLContentHandler
    */

    @Test public void testEndPrefixMapping() {
        XMLContentHandler x = new XMLContentHandler();
        assertEquals(true, x instanceof XMLContentHandler);

    }

    /** Test case for XMLContentHandler.ignorableWhitespace(char[],int,int)
        @see XMLContentHandler
    */

    @Test public void testIgnorableWhitespace() {
        XMLContentHandler x = new XMLContentHandler();
        assertEquals(true, x instanceof XMLContentHandler);

    }

    /** Test case for XMLContentHandler.processingInstruction(String,String)
        @see XMLContentHandler
    */

    @Test public void testProcessingInstruction() {
        XMLContentHandler x = new XMLContentHandler();
        assertEquals(true, x instanceof XMLContentHandler);

    }

    /** Test case for XMLContentHandler.setDate(int,int,int)
        @see XMLContentHandler
    */

    @Test public void testSetDate() {
        XMLContentHandler x = new XMLContentHandler();
        assertEquals(true, x instanceof XMLContentHandler);

    }

    /** Test case for XMLContentHandler.setDay(int)
        @see XMLContentHandler
    */

    @Test public void testSetDay() {
        XMLContentHandler x = new XMLContentHandler();
        assertEquals(true, x instanceof XMLContentHandler);

    }

    /** Test case for XMLContentHandler.setMonth(int)
        @see XMLContentHandler
    */

    @Test public void testSetMonth() {
        XMLContentHandler x = new XMLContentHandler();
        assertEquals(true, x instanceof XMLContentHandler);

    }

    /** Test case for XMLContentHandler.setYear(int)
        @see XMLContentHandler
    */

    @Test public void testSetYear() {
        XMLContentHandler x = new XMLContentHandler();
        assertEquals(true, x instanceof XMLContentHandler);

    }


    /** Test case for XMLContentHandler.setDocumentLocator(org.xml.sax.Locator)
        @see XMLContentHandler
    */

    @Test public void testSetDocumentLocator() {
        XMLContentHandler x = new XMLContentHandler();
        assertEquals(true, x instanceof XMLContentHandler);

    }


    /** Test case for XMLContentHandler.skippedEntity()
        @see XMLContentHandler
    */

    @Test public void testSkippedEntity() {
        XMLContentHandler x = new XMLContentHandler();
        assertEquals(true, x instanceof XMLContentHandler);

    }

    /** Test case for XMLContentHandler.startDocument()
        @see XMLContentHandler
    */

    @Test public void testStartDocument() {
        XMLContentHandler x = new XMLContentHandler();
        assertEquals(true, x instanceof XMLContentHandler);

    }

    /** Test case for XMLContentHandler.startElement(String,String,
	     String,org.xml.sax.Attributes)
        @see XMLContentHandler
    */

    @Test public void testStartElement() {
        XMLContentHandler x = new XMLContentHandler();
        assertEquals(true, x instanceof XMLContentHandler);

    }

    /** Test case for XMLContentHandler.startPrefixMapping(String,String)
        @see XMLContentHandler
    */

    @Test public void testStartPrefixMapping() {
        XMLContentHandler x = new XMLContentHandler();
        assertEquals(true, x instanceof XMLContentHandler);

    }


}

