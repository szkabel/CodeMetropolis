package codemetropolis.toolchain.commons.cmxml;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Test class for buildable methods.
 * @author Abel Szkalisity {@literal <SZAVAET.SZE>}
 *
 */
public class BuildableTest {
	
	private Buildable a;
	private Buildable b;
	private Buildable c;
	private Buildable d;
	
	@Before
	public void setUpBeforeAllMethods() {		
		a = new Buildable("build1", "first", Buildable.Type.CELLAR, new Point(0, 0, 0), new Point(2, 2, 2));
		c = new Buildable("build3", "third", Buildable.Type.CELLAR);
		d = new Buildable("build4", "fourth", Buildable.Type.CONTAINER);
		a.addChildren(c);
		c.addChildren(d);
	}

	@Test
	public void testBuildableStringStringType() {
		assertNotNull(new Buildable("build1", "wall", Buildable.Type.CELLAR));
	}

	@Test
	public void testIsNotOverlappingBuildable() {		
		b = new Buildable("build2", "second", Buildable.Type.CELLAR, new Point(3, 2, 2), new Point(1, 1, 1));
		assertFalse(b.isOverlapping(a));
	}
	
	@Test
	public void testIsOverlappingBuildable() {		
		b = new Buildable("build2", "second", Buildable.Type.CELLAR, new Point(1, 1, 1), new Point(2, 2, 2));
		assertTrue(b.isOverlapping(a));
	}

	@Test
	public void testIsNotOverlappingIntInt() {				
		assertFalse(a.isOverlapping(1, 5));	
	}
	
	@Test
	public void testIsOverlappingIntInt() {				
		assertTrue(a.isOverlapping(1, 2));	
	}

	@Test
	public void testGetCenter() {
		assertEquals(1, a.getCenter().getX());
		assertEquals(1, a.getCenter().getY());
		assertEquals(1, a.getCenter().getZ());
	}

	@Test
	public void testCompareToEqual() {
		a = new Buildable("build1", "first", Buildable.Type.CELLAR, new Point(0, 0, 0), new Point(2, 4, 3));
		b = new Buildable("build2", "second", Buildable.Type.CELLAR, new Point(0, 0, 0), new Point(12, 2, 1));
		assertEquals(0, b.compareTo(a));
	}
	
	@Test
	public void testCompareToLess() {
		a = new Buildable("build1", "first", Buildable.Type.CELLAR, new Point(0, 0, 0), new Point(2, 4, 3));
		b = new Buildable("build2", "second", Buildable.Type.CELLAR, new Point(0, 0, 0), new Point(12, 3, 1));
		assertTrue(0 < b.compareTo(a));
	}
	
	@Test
	public void testGetNumberOfDescendants() {		
		assertEquals(2, a.getNumberOfDescendants());
	}
	
	@Test
	public void testGetNumberOfChildren() {		
		assertEquals(1, a.getNumberOfChildren());
	}
	
	@Test
	public void testGetDescendantLevelGrandChild() {
		assertEquals(3, d.getDescendantLevel());
	}
	
	@Test
	public void testGetDescendantLevelRoot() {
		assertEquals(1, a.getDescendantLevel());
	}
	
	@Test
	public void testGetType() {
		assertEquals(Buildable.Type.CELLAR, a.getType());	
	}
	

}
