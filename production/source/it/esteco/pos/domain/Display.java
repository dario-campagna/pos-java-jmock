package it.esteco.pos.domain;

public interface Display {
    void displayPrice(String price);

    void displayProductNotFound(String barcode);

    void displayEmptyBarcodeError();
}
