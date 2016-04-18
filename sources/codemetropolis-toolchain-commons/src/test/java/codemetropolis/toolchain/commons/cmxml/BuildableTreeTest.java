package codemetropolis.toolchain.commons.cmxml;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Test class for BuildableTree methods.
 * @author Abel Szkalisity {@literal <SZAVAET.SZE>}
 *
 */
public class BuildableTreeTest {
	
	private BuildableTree bt;
	private Buildable a,b;
	
	@Before
	public void setUpBeforeMethod() {
		a = new Buildable("build1", "first", Buildable.Type.CELLAR, new Point(5, 5, 5), new Point(4, 1, 3));
		b = new Buildable("build2", "second", Buildable.Type.CELLAR, new Point(0,0,0), new Point(2,1,1));
		b.addChild(a);
		bt = new BuildableTree(b);		
	}

	@Test
	public void testFindBuildables() {
		assertEquals(a, bt.findBuildables(6, 7)[0]);
	}
	
	@Test
	public void testFindBuildablesNull() {
		assertEquals(0, (bt.findBuildables(10, 9)).length);
	}		

}
