package codemetropolis.toolchain.mapping.conversions;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

/**
 * Testing the static methods of {@link Conversion}.
 *
 * @author Adam Bankeszi {@literal <BAAVAGT.SZE>}
 */
public class ConversionTest {

  @Test
  public void testCreateFromNameForEmptyString() {
    Assert.assertNull(Conversion.createFromName(""));
  }

  @Test(expected = NullPointerException.class)
  public void testCreateFromNameForNull() {
    Conversion.createFromName(null);
  }

  @Test
  public void testCreateFromNameForInvalidString() {
    Assert.assertNull(Conversion.createFromName("INVALID_STRING"));
  }

  @Test
  public void testCreateFromNameForToInt() {
    Conversion conversion = Conversion.createFromName(ToIntConversion.NAME);
    Assert.assertThat(conversion, CoreMatchers.instanceOf(ToIntConversion.class));
  }

  @Test
  public void testCreateFromNameForToDouble() {
    Conversion conversion = Conversion.createFromName(ToDoubleConversion.NAME);
    Assert.assertThat(conversion, CoreMatchers.instanceOf(ToDoubleConversion.class));
  }

  @Test
  public void testCreateFromNameForMultiply() {
    Conversion conversion = Conversion.createFromName(MultiplyConversion.NAME);
    Assert.assertThat(conversion, CoreMatchers.instanceOf(MultiplyConversion.class));
  }

  @Test
  public void testCreateFromNameForQuantization() {
    Conversion conversion = Conversion.createFromName(QuantizationConversion.NAME);
    Assert.assertThat(conversion, CoreMatchers.instanceOf(QuantizationConversion.class));
  }

  @Test
  public void testCreateFromNameForNormalize() {
    Conversion conversion = Conversion.createFromName(NormalizeConversion.NAME);
    Assert.assertThat(conversion, CoreMatchers.instanceOf(NormalizeConversion.class));
  }

  @Test
  public void testCreateFromNameForSwitch() {
    Conversion conversion = Conversion.createFromName(SwitchConversion.NAME);
    Assert.assertThat(conversion, CoreMatchers.instanceOf(SwitchConversion.class));
  }

  @Test
  public void testToDoubleForDouble() {
    Assert.assertEquals(Conversion.toDouble("1.2"), 1.2D, 0.00000001);
  }

  @Test
  public void testToDoubleForFloat() {
    Assert.assertEquals(Conversion.toDouble("3.4f"), 3.4D, 0.00000001);
  }

  @Test
  public void testToDoubleForInt() {
    Assert.assertEquals(Conversion.toDouble("8"), 8.0D, 0.00000001);
  }

  @Test(expected = NumberFormatException.class)
  public void testToDoubleForEmptyString() {
    Conversion.toDouble("");
  }

  @Test(expected = NullPointerException.class)
  public void testToDoubleForNull() {
    Conversion.toDouble(null);
  }

  @Test
  public void testToIntForDouble() {
    Assert.assertEquals(Conversion.toInt("1.2"), 1);
  }

  @Test
  public void testToIntForFloat() {
    Assert.assertEquals(Conversion.toInt("3.4f"), 3);
  }

  @Test
  public void testToIntForInt() {
    Assert.assertEquals(Conversion.toInt("8"), 8);
  }

  @Test(expected = NumberFormatException.class)
  public void testToIntForEmptyString() {
    Conversion.toInt("");
  }

  @Test(expected = NullPointerException.class)
  public void testToIntForNull() {
    Conversion.toInt(null);
  }

}
