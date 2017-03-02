package it.esteco.pos;

import it.esteco.pos.adapters.ConsoleDisplay;
import it.esteco.pos.adapters.InMemoryCatalog;
import it.esteco.pos.domain.PointOfSale;

import java.util.Scanner;

public class Main {

    private PointOfSale pointOfSale;

    public Main(String textCatalog) {
        this.pointOfSale = new PointOfSale(InMemoryCatalog.from(textCatalog), new ConsoleDisplay());
    }

    public static void main(String... args) {
        Main main = new Main(args[0]);
        main.start();
    }

    private void start() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            if ("TOTAL".equals(input)) {
                pointOfSale.onTotalRequested();
            } else {
                pointOfSale.onBarcode(input);
            }
        }
    }

}
