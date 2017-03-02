package it.esteco.pos;

import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;

public class ScanProduct {

    @Rule
    public JUnitRuleMockery context = new JUnitRuleMockery();
    private final Display display = context.mock(Display.class);
    private PointOfSale pointOfSale = new PointOfSale(display);

    @Test
    public void productFound() throws Exception {
        context.checking(new Expectations(){{
            oneOf(display).show("$11.50");
        }});

        pointOfSale.onBarcode("12345");
    }

    @Test
    public void anotherProductFound() throws Exception {
        context.checking(new Expectations(){{
            oneOf(display).show("$7.99");
        }});

        pointOfSale.onBarcode("54321");
    }
}
