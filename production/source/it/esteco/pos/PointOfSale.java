package it.esteco.pos;

public class PointOfSale {

    private Display display;

    public PointOfSale(Display display) {
        this.display = display;
    }

    public void onBarcode(String barcode) {
        if ("12345".equals(barcode)) {
            display.show("$11.50");
        } else if ("54321".equals(barcode)) {
            display.show("$7.99");
        } else {
            display.show("99999 Not exists!");
        }
    }
}
