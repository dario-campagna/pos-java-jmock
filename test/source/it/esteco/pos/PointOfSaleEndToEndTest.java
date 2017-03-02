package it.esteco.pos;

import org.junit.Before;
import org.junit.Test;

public class PointOfSaleEndToEndTest {

    private FakeScanner fakeScanner;
    private ApplicationRunner applicationRunner;

    @Before
    public void setUp() throws Exception {
        fakeScanner = new FakeScanner();
        applicationRunner = new ApplicationRunner();
    }

    @Test
    public void emptyBarcode() throws Exception {
        fakeScanner.scan("\n");
        applicationRunner.start("12345,$11.50");
        applicationRunner.showsEmptyBarcodeError();
    }

    @Test
    public void productFound() throws Exception {
        fakeScanner.scan("12345\n");
        applicationRunner.start("12345,$11.50");
        applicationRunner.showsPriceMessage();
    }

    @Test
    public void productNotFound() throws Exception {
        fakeScanner.scan("99999\n");
        applicationRunner.start("12345,$11.50");
        applicationRunner.showsProductNotFoundMessage("99999");
    }
}
