package it.esteco.pos.e2e;

import org.junit.Before;
import org.junit.Test;

public class PointOfSaleEndToEndTest {

    private FakeOperator fakeOperator;
    private ApplicationRunner applicationRunner;

    @Before
    public void setUp() throws Exception {
        fakeOperator = new FakeOperator();
        applicationRunner = new ApplicationRunner();
    }

    @Test
    public void emptyBarcode() throws Exception {
        fakeOperator.scan("\n");
        applicationRunner.start("12345,$11.50");
        applicationRunner.showsEmptyBarcodeError();
    }

    @Test
    public void productFound() throws Exception {
        fakeOperator.scan("12345\n");
        applicationRunner.start("12345,$11.50");
        applicationRunner.showsPriceMessage();
    }

    @Test
    public void productNotFound() throws Exception {
        fakeOperator.scan("99999\n");
        applicationRunner.start("12345,$11.50");
        applicationRunner.showsProductNotFoundMessage("99999");
    }

    @Test
    public void totalForNoProducts() throws Exception {
        fakeOperator.requestTotal();
        applicationRunner.start("12345,$11.50");
        applicationRunner.showsTotal("$0.00");
    }
}
