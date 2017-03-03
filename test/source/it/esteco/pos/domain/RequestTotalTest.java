package it.esteco.pos.domain;

import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;

public class RequestTotalTest {

    private static final Catalog UNUSED_CATALOG = null;
    @Rule
    public JUnitRuleMockery context = new JUnitRuleMockery();
    private Display display = context.mock(Display.class);
    private Cart cart = context.mock(Cart.class);
    private PointOfSale pointOfSale = new PointOfSale(UNUSED_CATALOG, display, cart);

    @Test
    public void noScannedProduct() throws Exception {
        context.checking(new Expectations() {{
            oneOf(cart).total();
            will(returnValue(new Money(0)));
            oneOf(display).displayPrice(new Money(0));
        }});
        pointOfSale.onTotalRequested();
    }
}
