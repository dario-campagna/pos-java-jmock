package it.esteco.pos.domain;

import it.esteco.pos.domain.Catalog;
import it.esteco.pos.domain.Display;
import it.esteco.pos.domain.PointOfSale;
import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;

public class ScanProduct {

    @Rule
    public JUnitRuleMockery context = new JUnitRuleMockery();
    private Catalog catalog = context.mock(Catalog.class);
    private final Display display = context.mock(Display.class);
    private PointOfSale pointOfSale = new PointOfSale(catalog, display);

    @Test
    public void productFound() throws Exception {
        context.checking(new Expectations() {{
            allowing(catalog).findPriceBy("12345");
            will(returnValue("$11.50"));
            oneOf(display).displayPrice("$11.50");
        }});

        pointOfSale.onBarcode("12345");
    }

    @Test
    public void anotherProductFound() throws Exception {
        context.checking(new Expectations() {{
            allowing(catalog).findPriceBy("54321");
            will(returnValue("$7.99"));
            oneOf(display).displayPrice("$7.99");
        }});

        pointOfSale.onBarcode("54321");
    }

    @Test
    public void productNotFound() throws Exception {
        context.checking(new Expectations() {{
            allowing(catalog).findPriceBy("99999");
            will(returnValue(null));
            oneOf(display).displayProductNotFound("99999");
        }});

        pointOfSale.onBarcode("99999");
    }

    @Test
    public void emptyBarcode() throws Exception {
        context.checking(new Expectations() {{
            oneOf(display).displayEmptyBarcodeError();
        }});

        pointOfSale.onBarcode("");
    }
}
