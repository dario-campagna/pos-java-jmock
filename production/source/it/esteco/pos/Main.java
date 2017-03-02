package it.esteco.pos;

import java.util.Scanner;

public class Main implements Display, Catalog {

    private PointOfSale pointOfSale = new PointOfSale(this, this);

    public static void main(String... args) {
        Main main = new Main();
        main.start();
    }

    private void start() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            pointOfSale.onBarcode(scanner.nextLine());
        }
    }

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

    @Override
    public String findPriceBy(String barcode) {
        if ("12345".equals(barcode)) {
            return "$11.50";
        }
        return null;
    }
}
