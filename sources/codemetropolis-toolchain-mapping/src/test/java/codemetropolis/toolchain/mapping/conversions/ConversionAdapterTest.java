package codemetropolis.toolchain.mapping.conversions;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

import codemetropolis.toolchain.mapping.conversions.ConversionAdapter.AdaptedConversion;

/**
 * Testing the marshalling functions in {@link ConversionAdapter}.
 *
 * @author Adam Bankeszi {@literal <BAAVAGT.SZE>}
 */
public class ConversionAdapterTest {

  private ConversionAdapter adapter = new ConversionAdapter();

  @Test
  public void testMarshalNull() {
    try {
      Assert.assertNull(adapter.marshal(null));
    } catch (Exception e) {
      Assert.fail();
    }
  }

  @Test
  public void testMarshalToIntConversion() {
    try {
      ToIntConversion conversion = new ToIntConversion();
      AdaptedConversion result = adapter.marshal(conversion);
      Assert.assertEquals(result.type, ToIntConversion.NAME);
      Assert.assertEquals(result.parameters, conversion.parameters);
    } catch (Exception e) {
      Assert.fail();
    }
  }

  @Test
  public void testMarshalToDoubleConversion() {
    try {
      ToDoubleConversion conversion = new ToDoubleConversion();
      AdaptedConversion result = adapter.marshal(conversion);
      Assert.assertEquals(result.type, ToDoubleConversion.NAME);
      Assert.assertEquals(result.parameters, conversion.parameters);
    } catch (Exception e) {
      Assert.fail();
    }
  }

  @Test
  public void testMarshalMultiplyConversion() {
    try {
      MultiplyConversion conversion = new MultiplyConversion();
      AdaptedConversion result = adapter.marshal(conversion);
      Assert.assertEquals(result.type, MultiplyConversion.NAME);
      Assert.assertEquals(result.parameters, conversion.parameters);
    } catch (Exception e) {
      Assert.fail();
    }
  }

  @Test
  public void testMarshalQuantizationConversion() {
    try {
      QuantizationConversion conversion = new QuantizationConversion();
      AdaptedConversion result = adapter.marshal(conversion);
      Assert.assertEquals(result.type, QuantizationConversion.NAME);
      Assert.assertEquals(result.parameters, conversion.parameters);
    } catch (Exception e) {
      Assert.fail();
    }
  }

  @Test
  public void testMarshalNormalizeConversion() {
    try {
      NormalizeConversion conversion = new NormalizeConversion();
      AdaptedConversion result = adapter.marshal(conversion);
      Assert.assertEquals(result.type, NormalizeConversion.NAME);
      Assert.assertEquals(result.parameters, conversion.parameters);
    } catch (Exception e) {
      Assert.fail();
    }
  }

  @Test
  public void testMarshalSwitchConversion() {
    try {
      SwitchConversion conversion = new SwitchConversion();
      AdaptedConversion result = adapter.marshal(conversion);
      Assert.assertEquals(result.type, SwitchConversion.NAME);
      Assert.assertEquals(result.parameters, conversion.parameters);
    } catch (Exception e) {
      Assert.fail();
    }
  }

  @Test(expected = NullPointerException.class)
  public void testUnmarshalNull() throws Exception {
    adapter.unmarshal(null);
  }

  @Test
  public void testUnmarshalFromToIntAdapter() {
    try {
      ToIntConversion conversion = new ToIntConversion();
      AdaptedConversion conversionAdapter = adapter.marshal(conversion);
      Conversion result = adapter.unmarshal(conversionAdapter);

      Assert.assertThat(result, CoreMatchers.instanceOf(ToIntConversion.class));
      Assert.assertEquals(result.parameters, conversion.parameters);
    } catch (Exception e) {
      Assert.fail();
    }
  }

  @Test
  public void testUnmarshalFromToDoubleAdapter() {
    try {
      ToDoubleConversion conversion = new ToDoubleConversion();
      AdaptedConversion conversionAdapter = adapter.marshal(conversion);
      Conversion result = adapter.unmarshal(conversionAdapter);

      Assert.assertThat(result, CoreMatchers.instanceOf(ToDoubleConversion.class));
      Assert.assertEquals(result.parameters, conversion.parameters);
    } catch (Exception e) {
      Assert.fail();
    }
  }

  @Test
  public void testUnmarshalFromMultiplyAdapter() {
    try {
      MultiplyConversion conversion = new MultiplyConversion();
      AdaptedConversion conversionAdapter = adapter.marshal(conversion);
      Conversion result = adapter.unmarshal(conversionAdapter);

      Assert.assertThat(result, CoreMatchers.instanceOf(MultiplyConversion.class));
      Assert.assertEquals(result.parameters, conversion.parameters);
    } catch (Exception e) {
      Assert.fail();
    }
  }

  @Test
  public void testUnmarshalFromQuantizationAdapter() {
    try {
      QuantizationConversion conversion = new QuantizationConversion();
      AdaptedConversion conversionAdapter = adapter.marshal(conversion);
      Conversion result = adapter.unmarshal(conversionAdapter);

      Assert.assertThat(result, CoreMatchers.instanceOf(QuantizationConversion.class));
      Assert.assertEquals(result.parameters, conversion.parameters);
    } catch (Exception e) {
      Assert.fail();
    }
  }

  @Test
  public void testUnmarshalFromNormalizeAdapter() {
    try {
      NormalizeConversion conversion = new NormalizeConversion();
      AdaptedConversion conversionAdapter = adapter.marshal(conversion);
      Conversion result = adapter.unmarshal(conversionAdapter);

      Assert.assertThat(result, CoreMatchers.instanceOf(NormalizeConversion.class));
      Assert.assertEquals(result.parameters, conversion.parameters);
    } catch (Exception e) {
      Assert.fail();
    }
  }

  @Test
  public void testUnmarshalFromSwitchAdapter() {
    try {
      SwitchConversion conversion = new SwitchConversion();
      AdaptedConversion conversionAdapter = adapter.marshal(conversion);
      Conversion result = adapter.unmarshal(conversionAdapter);

      Assert.assertThat(result, CoreMatchers.instanceOf(SwitchConversion.class));
      Assert.assertEquals(result.parameters, conversion.parameters);
    } catch (Exception e) {
      Assert.fail();
    }
  }

}
