package codemetropolis.toolchain.mapping.conversions;

import org.junit.Test;

/**
 * Testing the {@link NormalizeConversion} class.
 *
 * @author Adam Bankeszi {@literal <BAAVAGT.SZE>}
 */
public class NormalizeConversionTest {

  private NormalizeConversion conversion = new NormalizeConversion();

  @Test(expected = NullPointerException.class)
  public void testApplyNull() {
    conversion.apply(null, null);
  }

  @Test(expected = NullPointerException.class)
  public void testApplyNullLimit() {
    conversion.apply("2.3", null);
  }

}
