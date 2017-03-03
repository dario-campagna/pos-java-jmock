package it.esteco.pos.domain;

public class PointOfSale {

    private Catalog catalog;
    private Display display;
    private Cart cart;

    public PointOfSale(Catalog catalog, Display display, Cart cart) {
        this.catalog = catalog;
        this.display = display;
        this.cart = cart;
    }

    public void onTotalRequested() {
        display.displayPrice(cart.total());
    }

    public void onBarcode(Barcode barcode) {
        if (barcode.toString().isEmpty()) {
            display.displayEmptyBarcodeError();
        } else {
            Money price = catalog.findPriceBy(barcode);
            if (price != null) {
                cart.add(price);
                display.displayPrice(price);
            } else {
                display.displayProductNotFound(barcode);
            }
        }
    }
}
