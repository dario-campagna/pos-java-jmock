package it.esteco.pos;

public class PointOfSale {

    private Catalog catalog;
    private Display display;

    public PointOfSale(Catalog catalog, Display display) {
        this.catalog = catalog;
        this.display = display;
    }

    public void onBarcode(String barcode) {
        if (barcode.isEmpty()) {
            display.show("Scanning error: empty barcode!");
        } else {
            String price = catalog.findBy(barcode);
            if (price != null) {
                display.show(price);
            } else {
                display.show(barcode +
                        " Not exists!");
            }
        }
    }
}
