package codemetropolis.toolchain.mapping.conversions;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

/**
 * Test the {@link ToIntConversion}.
 * 
 * @author Adam Bankeszi {@literal <BAAVAGT.SZE>}
 */
public class ToIntConversionTest {

  private ToIntConversion conversion = new ToIntConversion();

  @Test
  public void testApply() {
    Object result = conversion.apply("2", null);
    Assert.assertThat(result, CoreMatchers.instanceOf(Integer.class));
  }

}
