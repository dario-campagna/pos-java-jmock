package it.esteco.pos;

public class ConsoleDisplay implements Display {

    @Override
    public void displayPrice(String price) {
        System.out.println(price);
    }

    @Override
    public void displayProductNotFound(String barcode) {
        System.out.println(barcode + " not found!");
    }

    @Override
    public void displayEmptyBarcodeError() {
        System.out.println("Scan error: empty barcode!");
    }

}
