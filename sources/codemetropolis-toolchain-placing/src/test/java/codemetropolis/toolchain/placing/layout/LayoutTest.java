package codemetropolis.toolchain.placing.layout;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

import codemetropolis.toolchain.placing.exceptions.NonExistentLayoutException;
import codemetropolis.toolchain.placing.layout.pack.PackLayout;
import codemetropolis.toolchain.placing.layout.tetris.TetrisLayout;

/**
 * Testing the {@link Layout#parse(String)} method.
 *
 * @author Adam Bankeszi {@literal <BAAVAGT.SZE>}
 */
public class LayoutTest {

  @Test
  public void testParsePack() {
    try {
      Layout layout = Layout.parse("PACK");
      Assert.assertThat(layout, CoreMatchers.instanceOf(PackLayout.class));
    } catch (NonExistentLayoutException e) {
      Assert.fail();
    }
  }

  @Test
  public void testParseTetris() {
    try {
      Layout layout = Layout.parse("TETRIS");
      Assert.assertThat(layout, CoreMatchers.instanceOf(TetrisLayout.class));
    } catch (NonExistentLayoutException e) {
      Assert.fail();
    }
  }

  @Test(expected = NonExistentLayoutException.class)
  public void testParseUnknownLayoutType() throws NonExistentLayoutException {
    Layout.parse("UNKNOWN_LAYOUT_TYPE");
  }

  @Test(expected = NonExistentLayoutException.class)
  public void testParseEmptyString() throws NonExistentLayoutException {
    Layout.parse("");
  }

  @Test(expected = NullPointerException.class)
  public void testParseNull() throws NonExistentLayoutException {
    Layout.parse(null);
  }

}
