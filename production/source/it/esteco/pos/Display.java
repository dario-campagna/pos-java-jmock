package it.esteco.pos;

public interface Display {
    void displayPrice(String price);

    void displayProductNotFound(String barcode);

    void displayEmptyBarcodeError();
}
