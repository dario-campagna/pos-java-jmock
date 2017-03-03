package it.esteco.pos.adapters;

import it.esteco.pos.domain.Barcode;
import it.esteco.pos.domain.Display;
import it.esteco.pos.domain.MessageFormatter;
import it.esteco.pos.domain.Money;

public class ConsoleDisplay implements Display {

    private MessageFormatter messageFormatter;

    public ConsoleDisplay(MessageFormatter messageFormatter) {
        this.messageFormatter = messageFormatter;
    }

    @Override
    public void displayPrice(Money money) {
        System.out.println(messageFormatter.formatPrice(money));
    }

    @Override
    public void displayProductNotFound(Barcode barcode) {
        System.out.println(messageFormatter.formatNotFound(barcode));
    }

    @Override
    public void displayEmptyBarcodeError() {
        System.out.println(messageFormatter.emptyBarcode());
    }


}
