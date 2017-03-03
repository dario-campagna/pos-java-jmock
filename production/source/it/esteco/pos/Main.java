package it.esteco.pos;

import it.esteco.pos.adapters.ConsoleDisplay;
import it.esteco.pos.adapters.InMemoryCatalog;
import it.esteco.pos.adapters.ListCart;
import it.esteco.pos.domain.MessageFormatter;
import it.esteco.pos.domain.PointOfSale;

import java.io.InputStream;
import java.util.Scanner;

public class Main {

    public static final String TOTAL_COMMAND = "TOTAL";
    private PointOfSale pointOfSale;

    public Main(String textCatalog) {
        this.pointOfSale = new PointOfSale(InMemoryCatalog.from(textCatalog), new ConsoleDisplay(new MessageFormatter()), new ListCart());
    }

    public static void main(String... args) {
        Main main = new Main(args[0]);
        main.start();
    }

    private void start() {
        OperatorInputTranslator operatorInputTranslator = new OperatorInputTranslator();
        operatorInputTranslator.listenOn(System.in);
    }

    private class OperatorInputTranslator {

        public void listenOn(InputStream inputStream) {
            Scanner scanner = new Scanner(inputStream);
            while (scanner.hasNextLine()) {
                String input = scanner.nextLine();
                if (TOTAL_COMMAND.equals(input)) {
                    pointOfSale.onTotalRequested();
                } else {
                    pointOfSale.onBarcode(input);
                }
            }
        }

    }

}
