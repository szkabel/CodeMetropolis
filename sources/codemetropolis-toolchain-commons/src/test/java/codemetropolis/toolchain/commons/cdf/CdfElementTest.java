package codemetropolis.toolchain.commons.cdf;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import junit.framework.TestCase;

/**
 * Test class for CdfElement's not most basic methods.
 * 
 * @author Abel Szkalisity {@literal <SZAVAET.SZE>}
 *
 */
public class CdfElementTest extends TestCase {
	
	private CdfElement ce = new CdfElement();		

	@Test
	public void testCdfElementStringString() {
		assertNotNull(new CdfElement("name", "type"));
	}

	@Test
	public void testGetIntPropertyValue() {		
		ce.addProperty("prop1", "3", CdfProperty.Type.INT);
		assertEquals("3",ce.getPropertyValue("prop1"));
	}
	
	@Test
	public void testFailGetPropertyValue() {				
		assertNull(ce.getPropertyValue("nonExisting"));
	}
	
	@Test	
	public void testGetNumberOfChildren() {				
		ce.addChildElement(new CdfElement());
		ce.addChildElement(new CdfElement());
		assertEquals(2, ce.getNumberOfChildren());
	}
	
	

}
