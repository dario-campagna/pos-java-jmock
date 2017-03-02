package it.esteco.pos.domain;

public interface Display {
    void displayPrice(Money price);

    void displayProductNotFound(String barcode);

    void displayEmptyBarcodeError();
}
