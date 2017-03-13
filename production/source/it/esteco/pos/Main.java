package it.esteco.pos;

import it.esteco.pos.adapters.ConsoleDisplay;
import it.esteco.pos.adapters.InMemoryCatalog;
import it.esteco.pos.adapters.ListCart;
import it.esteco.pos.domain.*;

import java.io.InputStream;
import java.util.Scanner;

public class Main {

    public static final String TOTAL_COMMAND = "TOTAL";
    private PointOfSale pointOfSale;
    private final OperatorInputTranslator operatorInputTranslator;

    public Main(String textCatalog) {
        ConsoleDisplay display = new ConsoleDisplay(new MessageFormatter());
        this.pointOfSale = new PointOfSale(InMemoryCatalog.from(textCatalog), display, new ListCart());
        this.operatorInputTranslator = new OperatorInputTranslator(new BarcodeValidator(display));
    }

    public static void main(String... args) {
        Main main = new Main(args[0]);
        main.start();
    }

    private void start() {
        operatorInputTranslator.listenOn(System.in);
    }

    private class OperatorInputTranslator {

        private BarcodeValidator validator;

        public OperatorInputTranslator(BarcodeValidator validator) {
            this.validator = validator;
        }

        public void listenOn(InputStream inputStream) {
            Scanner scanner = new Scanner(inputStream);
            while (scanner.hasNextLine()) {
                String input = scanner.nextLine();
                if (TOTAL_COMMAND.equals(input)) {
                    pointOfSale.onTotalRequested();
                } else if(validator.isValidBarcode(input)) {
                    pointOfSale.onBarcode(new Barcode(input));
                }
            }
        }

    }

}
