package it.esteco.pos.domain;

import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;

public class ScanProductTest {

    @Rule
    public JUnitRuleMockery context = new JUnitRuleMockery();
    private final Catalog catalog = context.mock(Catalog.class);
    private final Display display = context.mock(Display.class);
    private final Cart cart = context.mock(Cart.class);
    private PointOfSale pointOfSale = new PointOfSale(catalog, display, cart);

    @Test
    public void productFound() throws Exception {
        context.checking(new Expectations() {{
            allowing(catalog).findPriceBy(new Barcode("12345"));
            will(returnValue(new Money(115)));
            oneOf(cart).add(new Money(115));
            oneOf(display).displayPrice(new Money(115));
        }});

        pointOfSale.onBarcode(new Barcode("12345"));
    }

    @Test
    public void anotherProductFound() throws Exception {
        context.checking(new Expectations() {{
            allowing(catalog).findPriceBy(new Barcode("54321"));
            will(returnValue(new Money(799)));
            oneOf(cart).add(new Money(799));
            oneOf(display).displayPrice(new Money(799));
        }});

        pointOfSale.onBarcode(new Barcode("54321"));
    }

    @Test
    public void productNotFound() throws Exception {
        context.checking(new Expectations() {{
            allowing(catalog).findPriceBy(new Barcode("99999"));
            will(returnValue(null));
            oneOf(display).displayProductNotFound(new Barcode("99999"));
        }});

        pointOfSale.onBarcode(new Barcode("99999"));
    }

    @Test
    public void emptyBarcode() throws Exception {
        context.checking(new Expectations() {{
            oneOf(display).displayEmptyBarcodeError();
        }});

        pointOfSale.onBarcode(new Barcode(""));
    }
}
