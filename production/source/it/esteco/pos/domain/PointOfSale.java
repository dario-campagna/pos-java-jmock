package it.esteco.pos.domain;

public class PointOfSale {

    private Catalog catalog;
    private Display display;

    public PointOfSale(Catalog catalog, Display display) {
        this.catalog = catalog;
        this.display = display;
    }

    public void onBarcode(String barcode) {
        if (barcode.isEmpty()) {
            display.displayEmptyBarcodeError();
        } else {
            String price = catalog.findPriceBy(barcode);
            if (price != null) {
                display.displayPrice(price);
            } else {
                display.displayProductNotFound(barcode);
            }
        }
    }

    public void onTotalRequested() {
        display.displayPrice("$0.00");
    }
}
