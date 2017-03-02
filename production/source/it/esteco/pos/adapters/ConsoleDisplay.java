package it.esteco.pos.adapters;

import it.esteco.pos.domain.Display;
import it.esteco.pos.domain.Money;

public class ConsoleDisplay implements Display {

    @Override
    public void displayPrice(Money price) {
        System.out.println(price.getAmount());
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
