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
        fakeOperator.input("\n");
        applicationRunner.start("12345,115");
        applicationRunner.showsEmptyBarcodeError();
    }

    @Test
    public void productFound() throws Exception {
        fakeOperator.input("12345\n");
        applicationRunner.start("12345,115");
        applicationRunner.showsPriceMessage("$11.50");
    }

    @Test
    public void productNotFound() throws Exception {
        fakeOperator.input("99999\n");
        applicationRunner.start("12345,115");
        applicationRunner.showsProductNotFoundMessage("99999");
    }

    @Test
    public void totalForNoProducts() throws Exception {
        fakeOperator.input("TOTAL\n");
        applicationRunner.start("12345,115");
        applicationRunner.showsTotal("$0.00");
    }

    @Test
    public void totalForTwoScannedProducts() throws Exception {
        fakeOperator.input("12345\n54321\nTOTAL\n");
        applicationRunner.start("12345,115;54321,799");
        applicationRunner.showsPriceMessage("$11.50");
        applicationRunner.showsPriceMessage("$7.99");
        applicationRunner.showsTotal("$19,49");
    }
}
